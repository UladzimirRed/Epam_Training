package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements ActionCommand {
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if (LoginLogic.checkLogin(login, password)){
            request.getSession().setAttribute("user", login);
            request.setAttribute("user", login);
            page = "/main";
        }else {
            request.setAttribute("wrongData", "Wrong password");
            page = "/login";
        }
        return page;
    }
}
