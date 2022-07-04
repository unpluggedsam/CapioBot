package capio.command.handle;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Delegates and executes {@link Command}'s.
 */
public class CommandHandler {

    /**
     * Executes the command
     *
     * @param command     The Command that is being executed.
     * @param event       The message event.
     * @param commandList
     */
    public void executeCommand(final Command command, final MessageReceivedEvent event, final String[] args, GuildCommandsHandler guildCommandHandler) {
        try {
            if(!Collections.disjoint(Objects.requireNonNull(event.getMember()).getRoles(), command.getRequiredRoles(event))) {
                final Thread commandThread = new Thread(() ->  command.execute(event, args, guildCommandHandler.getGuildCommandList(event.getGuild()).getCommandList()));
                commandThread.setUncaughtExceptionHandler((th, ex) -> {
                    ex.printStackTrace();
                    event.getGuildChannel().sendMessage("Not enough arguments!").queue();
                });
                commandThread.start();
                commandThread.interrupt();
            } else {
                event.getGuildChannel().sendMessage("Invalid permissions!").queue();
            }
        } catch(final IndexOutOfBoundsException e) {
            e.printStackTrace();

        }
    }
}
