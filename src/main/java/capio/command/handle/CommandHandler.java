package capio.command.handle;

import capio.CapioBot;
import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Collections;
import java.util.Objects;

public class CommandHandler extends ListenerAdapter {

    /**
     * Delegates commands and executes them
     * @param event message event
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args[0].substring(0, 1).equals(CapioBot.prefix)) {
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
