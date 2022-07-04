package capio.command.permission_handle;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class ModeratorPermission implements PermissionController {
    @Override
    public List<Role> getRequiredRoles(final MessageReceivedEvent event) {
        return List.of(RoleFactory.createRole(event.getGuild(), 988961939965243423L, "Moderator"));
    }
}
