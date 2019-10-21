package by.epam.training.command.impl;

import by.epam.training.util.JspAttr;
import by.epam.training.command.ActionCommand;

import javax.servlet.http.HttpServletRequest;

public class LocaleCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String lang = request.getParameter(JspAttr.LANGUAGE);
        request.getSession().setAttribute(JspAttr.LOCAL, lang);
        request.getSession().setAttribute(JspAttr.MESSAGE, JspAttr.CHANGED_LOCALE);
        request.setAttribute(JspAttr.MESSAGE, JspAttr.CHANGED_LOCALE);
        return "/main";
    }
}
