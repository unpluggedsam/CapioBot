package capio.command.permission_handle;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Administrative access control. Users with Admin roles have access to these {@link Command}'s.
 */
public class AdminPermission implements PermissionController {
    private final ArrayList requiredRoles = new ArrayList<>();
    @Override
    public ArrayList<Role> getRequiredRoles(final MessageReceivedEvent event) {
        return requiredRoles;
    }
}
