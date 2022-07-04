package capio.command.handle;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Delegates and executes {@link Command}'s.
 */
public class CommandHandler {

    /**
     * Executes the command
     *
     * @param command              The Command that is being executed.
     * @param event                The message event.
     * @param guildCommandsHandler
     */
    public void executeCommand(final Command command, final MessageReceivedEvent event, final String[] args, GuildCommandsHandler guildCommandsHandler) {
        try {
            List<Role> requiredRoles = new ArrayList();

            command.getPermissionEnum().forEach(permissionEnum -> {
                GuildCommandsHandler.getPermissionControllerFromEnum(event.getGuild(), permissionEnum).getRequiredRoles().forEach(role -> requiredRoles.add(role));
            });

            if (!Collections.disjoint(Objects.requireNonNull(event.getMember()).getRoles(), requiredRoles)) {
                final Thread commandThread = new Thread(() -> command.execute(event, args, guildCommandsHandler));
                commandThread.setUncaughtExceptionHandler((th, ex) -> {
                    ex.printStackTrace();
                    event.getGuildChannel().sendMessage("Not enough arguments!").queue();
                });
                commandThread.start();
                commandThread.interrupt();
            } else {
                event.getGuildChannel().sendMessage("Invalid permissions!").queue();
            }
        } catch (final IndexOutOfBoundsException e) {
            e.printStackTrace();

        }
    }
}
