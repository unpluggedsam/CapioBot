package capio.command.bot_commands.moderation;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import capio.command.permission_handle.PermissionEnum;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

public class BanCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {
        final Member member = event.getMessage().getMentions().getMembers().get(0);
        if (member.hasPermission(Permission.ADMINISTRATOR)) {
            event.getGuildChannel().sendMessage("Can't ban an ADMIN!").queue();
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
        return "Bans a member. The first argument is the mention of the member that is being banned, and the second argument is the reason for their ban.";
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
