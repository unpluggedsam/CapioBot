package capio.command.bot_commands.utilitys;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import capio.command.permission_handle.PermissionEnum;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Arrays;
import java.util.List;

public class SetRequiredPermissionCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args, GuildCommandsHandler guildCommandsHandler) {
        guildCommandsHandler.getGuildPermissionController(event.getGuild()).get(Arrays.stream(PermissionEnum.values())
                .filter(e -> e.name().equalsIgnoreCase(args[1])).findAny().orElse(null)).addRequiredRole(event.getMessage().getMentions().getRoles().get(0));

        event.getChannel().sendMessage(String.format("Assigned %s to the %s permission.", event.getMessage().getMentions().getRoles().get(0), args[1])).queue();
    }

    @Override
    public String getCommandName() {
        return "set-role";
    }

    @Override
    public String getDescription() {
        return "Each Command has a required permission to execute it. The permission can either be: " +
                "\n\n • BASIC" +
                "\n • MOD" +
                "\n • ADMIN" +
                "\n\n These permissions can have discord roles attached to them allowing" +
                "members in the server to access the commands. By default, the ADMIN " +
                "permission is automatically assigned the admin role retrieved from the server. " +
                "If the server does not have an admin role then one is created for it. Use this command" +
                "to assign a role to a permission. The first argument is the permission that the role is being assigned " +
                "to. The second argument is the mention of the role that is being assigned to the permission. For example: \n ```" +
                getCommandName() + " BASIC @guest```";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public List<PermissionEnum> getPermissionEnum() {
        return List.of(PermissionEnum.ADMIN);
    }
}
