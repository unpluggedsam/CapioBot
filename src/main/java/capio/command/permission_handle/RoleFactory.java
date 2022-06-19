package capio.command.permission_handle;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;

public class RoleFactory {
    public static Role createRole(Guild guild, long ID) {
        return guild.getRoleById(ID);
    }

    // Overloaded just so the user can tell the name of the Role
    public static Role createRole(Guild guild, long ID, String name) {
        return guild.getRoleById(ID);
    }

}
