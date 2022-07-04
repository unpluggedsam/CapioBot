package capio.command.bot_commands.moderation;

import capio.command.bot_commands.Command;
import capio.command.permission_handle.AdminPermission;
import capio.command.permission_handle.PermissionController;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Kicks a member out of the server.
 */
public class KickCommand implements Command {

    @Override
    public void execute(MessageReceivedEvent event, String[] args,  Map<Class<? extends Command>, Command> commandList) {
        Member member = event.getMessage().getMentions().getMembers().get(0);
        if (member.hasPermission(Permission.ADMINISTRATOR)) {
            event.getGuildChannel().sendMessage("Can't kick an Administrator!").queue();
        } else {
            event.getGuild().kick(member).complete();
        }
    }

    @Override
    public String getCommandName() {
        return "kick";
    }

    @Override
    public String getDescription() {
        return "Kicks a User. First argument is the User mention.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public List<PermissionController> getPermissionController() {
        return List.of(new AdminPermission());
    }
}
