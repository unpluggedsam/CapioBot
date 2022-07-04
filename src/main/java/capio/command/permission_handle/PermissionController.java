package capio.command.permission_handle;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Used to control User access to {@link Command}'s.
 */
public interface PermissionController {
    /**
     * If the User has a {@link Role} that is present in the returned {@link List} of {@link Role}'s
     * then they have acess to the {@link Command}..
     *
     * @return A {@link List} of {@link Role}'s that are needed to acess the {@link Command}.
     */
    ArrayList<Role> getRequiredRoles();

    default void addRequiredRole(Role role) {
        getRequiredRoles().add(role);
    }

    default void removeRequiredRole(Role role) {
        getRequiredRoles().remove(role);
    }
}
