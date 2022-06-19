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
     * Whatever the Command should do
     *
     * @param event
     */
    void execute(MessageReceivedEvent event, String[] args);

    /**
     * The command name
     *
     * @return the command name
     */
    String getCommandName();


    default List<Role> getRequiredRoles(MessageReceivedEvent event) {
        List list = new ArrayList<Role>();
        getPermissionController().forEach(controller -> {
            controller.getRequiredRoles(event).forEach(role -> {
                list.add(role);
            });
        });
        return list;
    }

    default List<PermissionController> getPermissionController() {
        return List.of(new BasicPermission());
    }
}
