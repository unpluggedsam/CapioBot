package capio.command.permission_handle;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class AdminPermission implements PermissionController {
    @Override
    public List getRequiredRoles(MessageReceivedEvent event) {
      return List.of(RoleFactory.createRole(event.getGuild(), 988155607586599012L, "Admin"));
    }
}
