package by.epam.training.controller;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.factory.CommandFactory;
import by.epam.training.exception.CommandException;
import by.epam.training.util.JspAddresses;
import by.epam.training.util.JspAttribute;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "MainController", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String commandName = request.getParameter(JspAttribute.COMMAND);
        try {
            ActionCommand command = CommandFactory.getInstance().defineCommand(commandName);
            String page = command.execute(request);
            request.getRequestDispatcher(Objects.requireNonNullElse(page, JspAddresses.MAIN_PAGE)).forward(request, response);
        } catch (CommandException e) {
            request.getRequestDispatcher(JspAddresses.ERROR_PAGE).forward(request, response);
        }
    }
}
