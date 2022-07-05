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
    }

    @Override
    public String getCommandName() {
        return "set-role";
    }

    @Override
    public String getDescription() {
        return "Sets the required role to PermissionEnum. First argument is the " +
                "type of Permission you would like to set the role to." +
                "1. ADMIN  \n" +
                "2. MOD \n" +
                "3. BASIC \n" +
                "The second argument is the role you would like to add to the permission. " +
                "Mention the role to provide it as an argument.";
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
