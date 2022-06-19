package capio.command.permission_handle;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public interface PermissionController {
    List<Role> getRequiredRoles(MessageReceivedEvent event);
}
