package capio.bot.handler;

import capio.command.handle.CommandHandler;
import capio.command.listener.UserJoinListener;

public class Handler {

    private CommandHandler commandHandler;
    private UserJoinListener userJoinListener;


    public UserJoinListener getUserJoinListener() {
        return userJoinListener;
    }

    public void setUserJoinListener(UserJoinListener userJoinListener) {
        this.userJoinListener = userJoinListener;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    public void setCommandHandler(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }


}
