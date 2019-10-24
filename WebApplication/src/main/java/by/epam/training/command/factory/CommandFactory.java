package by.epam.training.command.factory;

import by.epam.training.command.ActionCommand;
import by.epam.training.command.CommandEnum;
import by.epam.training.command.impl.EmptyCommand;
import by.epam.training.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public final class CommandFactory {
    private final static CommandFactory instance = new CommandFactory();

    public static CommandFactory getInstance() {
        return instance;
    }

    public ActionCommand defineCommand(String commandName) throws CommandException {
        CommandEnum type = CommandEnum.getCommandType(commandName);
        if(type == null){
            return type.getCurrentCommand();
        }else {
            throw new CommandException();
        }
    }
}
