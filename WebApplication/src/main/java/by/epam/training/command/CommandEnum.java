package by.epam.training.command;

import by.epam.training.command.impl.LocaleCommand;
import by.epam.training.command.impl.LoginCommand;
import by.epam.training.command.impl.LogoutCommand;

public enum CommandEnum {
    LOCALE(new LocaleCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand());

    private ActionCommand command;


    CommandEnum(ActionCommand command) {
        this.command = command;
    }

    public static ActionCommand getCurrentCommand(String action) {
        return CommandEnum.valueOf(action.toUpperCase()).command;
    }
}
