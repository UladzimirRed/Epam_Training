package by.epam.training.command.impl;

import by.epam.training.command.ActionCommand;
import by.epam.training.util.JspAddresses;

import javax.servlet.http.HttpServletRequest;

public class ErrorPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest req) {
        return JspAddresses.ERROR_PAGE;
    }
}
