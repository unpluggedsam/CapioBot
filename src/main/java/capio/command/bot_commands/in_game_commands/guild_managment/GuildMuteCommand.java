package capio.command.bot_commands.in_game_commands.guild_managment;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class GuildMuteCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final Map<Class<? extends Command>, Command> commandList) {

    }

    @Override
    public String getCommandName() {
        return "guild-mute";
    }

    @Override
    public String getDescription() {
        return "Mute a member in the guild. First argument is the Players IGN.";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
