package capio.command.bot_commands.moderation_commands;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * Kicks a member out of the server.
 */
public class KickCommand implements Command {

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
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
}
