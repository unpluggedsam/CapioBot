package capio.command.permission_handle;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

/**
 * Basic permission access. Everyone (besides muted Users) should have access to {@link Command}'s with these rights.
 */
public class BasicPermission implements PermissionController {
    @Override
    public List<Role> getRequiredRoles(MessageReceivedEvent event) {
        return List.of(RoleFactory.createRole(event.getGuild(), 988161656787984504L, "All"));
    }
}
