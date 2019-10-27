package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.entity.User;
import by.epam.training.exception.ServiceException;
import by.epam.training.service.UserService;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements ActionCommand {
    private static Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String page = null;
        String login = request.getParameter(JspAttribute.PARAM_NAME_LOGIN);
        String password = request.getParameter(JspAttribute.PARAM_NAME_PASSWORD);
        try {
            UserService service = new UserService();
            User user = service.loginUser(login, password);
            if (user != null){
                request.setAttribute(JspAttribute.USER, login); //FIXME maybe user in constructor?
                session.setAttribute(JspAttribute.USER, login);
                page = JspAddress.MAIN_PAGE;
            } else {
                request.setAttribute(JspAttribute.WRONG_DATA, JspAttribute.WRONG_DATA);
                page = JspAddress.LOGIN_PAGE;
            }
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
//        if (LoginLogic.checkLogin(login, password)){
//            request.getSession().setAttribute("user", login);
//            request.setAttribute("user", login);
//            page = JspAddress.MAIN_PAGE;
//        }else {
//            request.setAttribute("wrongData", "Wrong password");
//            page = JspAddress.LOGIN_PAGE;
//        }
        return page;
    }
}
