package capio.command.listener;

import capio.command.handle.CommandBuilder;
import capio.command.handle.CommandHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    private final CommandHandler handler = new CommandHandler();

    /**
     * When a message is sent on the server this method gets called.
     * It checks if the message starts with the bot prefix and if it does then it
     * calls the executeCommand method().
     * @param event The message event.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        handler.executeCommand(CommandBuilder.createCommand(args[0].substring(1)), event, args);
    }

}
