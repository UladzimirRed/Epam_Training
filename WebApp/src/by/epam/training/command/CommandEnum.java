package by.epam.training.command;

import by.epam.training.command.impl.LoginCommand;
import by.epam.training.command.impl.LogoutCommand;

public enum  CommandEnum {
    LOGIN{
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT{
        {
            this.command = new LogoutCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand(){
        return command;
    }
}
