package capio.command.bot_commands.in_game_commands.guild_managment;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GuildMuteCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public String getCommandName() {
        return "guild-mute";
    }

    @Override
    public String getDescription() {
        return "Mute a member in the guild. First argument is the Players IGN.";
    }
}
