package capio.command.bot_commands.moderation;

import capio.command.bot_commands.Command;
import capio.command.permission_handle.AdminPermission;
import capio.command.permission_handle.PermissionEnum;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Map;

public class BanCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final Map<Class<? extends Command>, Command> commandList) {
        final Member member = event.getMessage().getMentions().getMembers().get(0);
        if (member.hasPermission(Permission.ADMINISTRATOR)) {
            event.getGuildChannel().sendMessage("Can't ban an Administrator!").queue();
        } else {
            event.getGuild().ban(member, 0, args[2]).complete();
        }
    }

    @Override
    public String getCommandName() {
        return "ban";
    }

    @Override
    public String getDescription() {
        return "Ban a member. First argument is tagging the member and the second one is the reason.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public List<PermissionEnum> getPermissionEnum() {
        return List.of(new AdminPermission());
    }
}
