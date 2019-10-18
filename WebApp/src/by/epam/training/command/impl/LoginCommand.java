package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.logic.LoginLogic;
import by.epam.training.resource.ConfigurationManager;
import by.epam.training.resource.MessageManager;

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
            request.setAttribute("user", login);
            page = ConfigurationManager.getProperty("path.page.main");
        }else {
            request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
