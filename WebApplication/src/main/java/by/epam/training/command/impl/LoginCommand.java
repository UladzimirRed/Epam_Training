package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.logic.LoginLogic;
import by.epam.training.util.JspAddress;
import by.epam.training.util.JspAttribute;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(JspAttribute.PARAM_NAME_LOGIN);
        String password = request.getParameter(JspAttribute.PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login, password)){
            request.getSession().setAttribute("user", login);
            request.setAttribute("user", login);
            page = JspAddress.MAIN_PAGE;
        }else {
            request.setAttribute("wrongData", "Wrong password");
            page = JspAddress.LOGIN_PAGE;
        }
        return page;
    }
}
