package capio.command.handle;

import capio.command.bot_commands.Command;
import capio.command_observer.CommandExecutedObserver;
import capio.command_observer.CommandExecutedSubject;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Delegates and executes {@link Command}'s.
 */
public class CommandHandler implements CommandExecutedSubject {

    List<CommandExecutedObserver> commandExecutedObserver = new ArrayList<>();

    /**
     * Executes the command
     * @param command The Command that is being executed.
     * @param event The message event.
     */
    public void executeCommand(Command command, MessageReceivedEvent event, String[] args) {
        try {
            if(!Collections.disjoint(Objects.requireNonNull(event.getMember()).getRoles(), command.getRequiredRoles(event))) {
                command.execute(event, args);
            } else {
                event.getGuildChannel().sendMessage("Invalid permissions!").queue();
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            event.getGuildChannel().sendMessage("Not enough arguments!").queue();
        } finally {
            notifiyObservers(event);
        }
    }

    @Override
    public void notifiyObservers(MessageReceivedEvent event) {
        commandExecutedObserver.forEach(observer -> observer.commandExecuted(event));
    }

    @Override
    public void addObserver(CommandExecutedObserver observer) {
        commandExecutedObserver.add(observer);
    }

    @Override
    public void removeObserver(CommandExecutedObserver observer) {
        commandExecutedObserver.remove(observer);
    }
}
