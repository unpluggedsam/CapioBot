package capio.command.handle;

import capio.bot.CapioBot;
import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Collections;
import java.util.Objects;

/**
 * Delegates and executes {@link Command}'s.
 */
public class CommandHandler {

    /**
     * Executes the command
     * @param command The Command that is being executed.
     * @param event The message event.
     */
    public void executeCommand(Command command, MessageReceivedEvent event, String[] args) {
        try {
            if(!Collections.disjoint(Objects.requireNonNull(event.getMember()).getRoles(), command.getRequiredRoles(event))) {
                Thread commandThread = new Thread(() ->  command.execute(event, args));
                commandThread.start();
                commandThread.interrupt();
            } else {
                event.getGuildChannel().sendMessage("Invalid permissions!").queue();
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            event.getGuildChannel().sendMessage("Not enough arguments!").queue();
        }
    }
}
