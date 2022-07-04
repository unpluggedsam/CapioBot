package capio.command.bot_commands;

import capio.command.handle.GuildCommandsHandler;
import capio.command.permission_handle.BasicPermission;
import capio.command.permission_handle.PermissionController;
import capio.command.permission_handle.PermissionEnum;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

/**
 * Used to show that a class is a command. The execute() method is called
 * to execute the Commands functionality.
 */
public interface Command {


    /**
     * The functionality that the command should execute when the User calls it.
     *
     * @param event       The event triggered by the User sending a message.
     * @param guildCommandsHandler
     */
    void execute(MessageReceivedEvent event, String[] args, GuildCommandsHandler guildCommandsHandler);

    /**
     * @return The command name (the text needed to trigger the command).
     */
    String getCommandName();

    /**
     * Gets the {@link PermissionController} for that command. Returns a {@link BasicPermission} controller
     * unless it is overriden.
     *
     * @return A {@link List} of {@link PermissionController}'s that the {@link Command} uses to control
     * Users access to it.
     */
    default List<PermissionEnum> getPermissionEnum() {
        return List.of(PermissionEnum.Basic);
    }

    /**
     *
     * @return A description of the {@link Command}.
     */
    String getDescription();

    /**
     * @return A boolean of whether a Command is enabled or not.
     */
    boolean isEnabled();
}
