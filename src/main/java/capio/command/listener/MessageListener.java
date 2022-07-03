package capio.command.listener;

import capio.bot.CapioBot;
import capio.command.handle.CommandBuilder;
import capio.command.handle.CommandHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {

    private final CommandHandler handler = new CommandHandler();
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(CapioBot.prefix)) {
            String[] args = event.getMessage().getContentRaw().split("\\s+");
            handler.executeCommand(CommandBuilder.createCommand(args[0].substring(1)), event, args);
        }
    }
}
