package capio.command.handle;

import capio.CapioBot;
import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Collections;
import java.util.Objects;

/**
 * Delegates and executes {@link Command}'s.
 */
public class CommandHandler extends ListenerAdapter {

    /**
     * When a message is sent on the server this method gets called.
     * It checks if the message starts with the bot prefix and if it does then
     * calls the executeCommand method().
     * @param event The message event.
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().substring(0, CapioBot.prefix.length()).equals(CapioBot.prefix)) {
            String[] args = event.getMessage().getContentRaw().split("\\s+");
            executeCommand(CommandBuilder.createCommand(args[0].substring(1)), event, args);
        }
    }

    /**
     * Executes the command
     * @param command The Command that is being executed.
     * @param event The message that calls the command
     */
    public void executeCommand(Command command, MessageReceivedEvent event, String[] args) {
        try {
            if(!Collections.disjoint(Objects.requireNonNull(event.getMember()).getRoles(), command.getRequiredRoles(event))) {
                command.execute(event, args);
            } else {
                event.getGuildChannel().sendMessage("Invalid permissions!").queue();
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            event.getGuildChannel().sendMessage("Not enough arguments!").queue();
        }
    }
}
