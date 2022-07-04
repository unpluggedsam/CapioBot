package capio.command.permission_handle;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic permission access. Everyone (besides muted Users) should have access to {@link Command}'s with these rights.
 */
public class BasicPermission implements PermissionController {

    private final ArrayList requiredRoles = new ArrayList<>();

    @Override
    public ArrayList<Role> getRequiredRoles(final MessageReceivedEvent event) {
        requiredRoles.add(RoleFactory.createRole(event.getGuild(), 988161656787984504L, "ALL"));
        return requiredRoles;
    }
}
