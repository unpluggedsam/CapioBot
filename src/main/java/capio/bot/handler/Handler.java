package capio.bot.handler;

import capio.command.handle.CommandHandler;
import capio.command.listener.MessageListener;
import capio.command.listener.UserJoinListener;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Handler {

    private ListenerAdapter messageListener;
    private ListenerAdapter userJoinListener;


    public ListenerAdapter getUserJoinListener() {
        return userJoinListener;
    }

    public void setUserJoinListener(UserJoinListener userJoinListener) {
        this.userJoinListener = userJoinListener;
    }

    public ListenerAdapter getCommandHandler() {
        return messageListener;
    }

    public void setCommandHandler(ListenerAdapter messageListener) {
        this.messageListener = messageListener;
    }


}
