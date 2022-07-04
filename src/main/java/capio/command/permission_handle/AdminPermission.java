package capio.command.permission_handle;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

/**
 * Administrative access control. Users with Admin roles have access to these {@link Command}'s.
 */
public class AdminPermission implements PermissionController {
    @Override
    public List getRequiredRoles(final MessageReceivedEvent event) {
      return List.of(RoleFactory.createRole(event.getGuild(), 988155607586599012L, "Admin"));
    }
}
