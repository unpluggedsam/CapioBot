package capio.command.bot_commands.in_game_commands.guild_managment;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class GuildInviteCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args, Map<Class<? extends Command>, Command> commandList) {

    }

    @Override
    public String getCommandName() {
        return "guild-invite";
    }

    @Override
    public String getDescription() {
        return "Invite a member to the guild. First argument is the players IGN.";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
