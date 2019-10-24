package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.logic.LoginLogic;
import by.epam.training.service.UserService;
import by.epam.training.util.JspAddresses;
import by.epam.training.util.JspAttribute;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String login = request.getParameter(JspAttribute.LOGIN);
        String password = request.getParameter(JspAttribute.PASSWORD);
        try {
            UserService service = new UserService();
            User user = service.loginUser(login, password);
            if (user != null) {
                request.setAttribute(JspAttribute.MESSAGE, JspAttribute.SIGNED_IN);
                session.setAttribute(JspAttribute.USER, user);
                return JspAddresses.MESSAGE_PAGE;
            }
            request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.WRONG_PASSWORD);
            return JspAddresses.LOGIN_PAGE;
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
        return null;
    }
}
//        String page = null;
//        String login = request.getParameter(PARAM_NAME_LOGIN);
//        String password = request.getParameter(PARAM_NAME_PASSWORD);
//        if (LoginLogic.checkLogin(login, password)){
//            request.getSession().setAttribute("user", login);
//            request.setAttribute("user", login);
//            page = "/main";
//        }else {
//            request.setAttribute("wrongData", "Wrong password");
//            page = "/login";
//        }
//        return page;