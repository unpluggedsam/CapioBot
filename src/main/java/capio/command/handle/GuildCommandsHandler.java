package capio.command.handle;

import capio.command.permission_handle.*;
import net.dv8tion.jda.api.entities.Guild;

import java.util.HashMap;
import java.util.Map;

public class GuildCommandsHandler {
    private final static Map<Guild, CommandList> guildCommandList = new HashMap();

    public static Map<PermissionEnum, PermissionController> getGuildPermissionController(Guild guild) {
        return guildPermissionController.get(guild);
    }

    private final static Map<Guild, Map<PermissionEnum, PermissionController>> guildPermissionController = new HashMap();

    public static void addGuildToCommandList(final Guild guild) {
        guildCommandList.put(guild, new CommandList());
    }

    public static CommandList getGuildCommandList(final Guild guild) {
        return guildCommandList.get(guild);
    }

    public static void addGuildToPermissionController(Guild guild) {

        Map<PermissionEnum, PermissionController> permissionEnumToController = new HashMap<>();
        permissionEnumToController.put(PermissionEnum.Basic, new BasicPermission());
        permissionEnumToController.put(PermissionEnum.Moderator, new ModeratorPermission());
        AdminPermission adminPermission = new AdminPermission();
        adminPermission.addRequiredRole(guild.getRolesByName("admin", true).get(0));
        permissionEnumToController.put(PermissionEnum.Administrator, adminPermission);

        guildPermissionController.put(guild, permissionEnumToController);
    }


    public static PermissionController getPermissionControllerFromEnum(Guild guild, PermissionEnum permissionEnum) {
        return guildPermissionController.get(guild).get(permissionEnum);
    }

}
