package capio.command.handle;

import capio.command.permission_handle.*;
import net.dv8tion.jda.api.entities.Guild;

import java.util.HashMap;
import java.util.Map;

public class GuildCommandsHandler {
    private final Map<Guild, CommandList> guildCommandList = new HashMap();

    private final Map<Guild, Map<PermissionEnum, PermissionController>> guildPermissionController = new HashMap();

    public void addGuildToCommandList(final Guild guild) {
        guildCommandList.put(guild, new CommandList());
    }

    public CommandList getGuildCommandList(final Guild guild) {
        return guildCommandList.get(guild);
    }

    public void addGuildToPermissionController(Guild guild) {

        Map<PermissionEnum, PermissionController> permissionEnumToController = new HashMap<>();
        permissionEnumToController.put(PermissionEnum.Basic, new BasicPermission());
        permissionEnumToController.put(PermissionEnum.Moderator, new ModeratorPermission());
        permissionEnumToController.put(PermissionEnum.Administrator, new AdminPermission());

        guildPermissionController.put(guild, permissionEnumToController);
    }

    public PermissionController getPermissionControllerFromEnum(Guild guild, PermissionEnum permissionEnum) {
        return guildPermissionController.get(guild).get(permissionEnum);
    }

}
