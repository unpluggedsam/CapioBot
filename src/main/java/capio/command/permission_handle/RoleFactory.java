package capio.command.permission_handle;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;

import java.util.List;

/**
 * A factory class used to instantiate {@link Role}'s from an <code>ID</code>.
 */
public class RoleFactory {
    public static Role createRole(final Guild guild, final long ID) {
        return guild.getRoleById(ID);
    }

    // Method overloaded simply so the developer can easily tell the name of the Role in the code.
    public static Role createRole(final Guild guild, final long ID, final String name) {
        return guild.getRoleById(ID);
    }

}
