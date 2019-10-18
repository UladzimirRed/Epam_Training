package by.epam.training.command.factory;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandEnum;
import by.epam.training.command.impl.EmptyCommand;
import by.epam.training.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request){
        ActionCommand currentCommand = new EmptyCommand();
        String action = request.getParameter("command");
        if(action == null || action.isEmpty()){
            return currentCommand;
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            currentCommand = currentEnum.getCurrentCommand();
        }catch (IllegalArgumentException e){
            request.setAttribute("wrongAction", action + MessageManager.getProperty("message.wrongaction"));
        }
        return currentCommand;
    }
}
