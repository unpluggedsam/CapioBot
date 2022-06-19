package capio.command.bot_commands.moderation_commands;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class BanCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        Member member = event.getMessage().getMentions().getMembers().get(0);
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
}
