package capio.command.permission_handle;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class ModeratorPermission implements PermissionController {
    private final ArrayList requiredRoles = new ArrayList<>();
    @Override
    public ArrayList<Role> getRequiredRoles() {
        return requiredRoles;
    }
}
