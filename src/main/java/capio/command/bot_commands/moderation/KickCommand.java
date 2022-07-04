package capio.command.bot_commands.moderation;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import capio.command.permission_handle.PermissionEnum;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

/**
 * Kicks a member out of the server.
 */
public class KickCommand implements Command {

    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {
        final Member member = event.getMessage().getMentions().getMembers().get(0);
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
    public List<PermissionEnum> getPermissionEnum() {
        return List.of(PermissionEnum.Administrator);
    }
}
