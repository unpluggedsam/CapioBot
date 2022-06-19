package capio.command.bot_commands;

import capio.command.permission_handle.BasicPermission;
import capio.command.permission_handle.PermissionController;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to show that a class is a command. The execute() method is called
 * to execute the Commands functionality.
 */
public interface Command {

    /**
     * The functionality that the command should execute when the User calls it.
     * @param event The event triggered by the User sending a message.
     */
    void execute(MessageReceivedEvent event, String[] args);

    /**
     * @return The command name (the text needed to trigger the command).
     */
    String getCommandName();


    /**
     * A convience method to reduce inter-dependency between Objects. It allows a User to
     * get all of the required {@link Role}'s without accessing the {@link PermissionController}.
     * @param event The event triggered by the User sending a message.
     * @return A {@link List} of {@link Role}'s that the User must have to execute the command.
     */
    default List<Role> getRequiredRoles(MessageReceivedEvent event) {
        List list = new ArrayList<Role>();
        getPermissionController().forEach(controller -> {
            controller.getRequiredRoles(event).forEach(role -> {
                list.add(role);
            });
        });
        return list;
    }

    /**
     * Gets the {@link PermissionController} for that command. Returns a {@link BasicPermission} controller
     * unless it is overriden.
     * @return A {@link List} of {@link PermissionController}'s that the {@link Command} uses to control
     * Users access to it.
     */
    default List<PermissionController> getPermissionController() {
        return List.of(new BasicPermission());
    }

    /**
     *
     * @return A description of the {@link Command}.
     */
    String getDescription();
}
