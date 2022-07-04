package capio.command.bot_commands.in_game_commands.guild_managment;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GuildKickCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {

    }

    @Override
    public String getCommandName() {
        return "guild-kick";
    }

    @Override
    public String getDescription() {
        return "Kick a member from the guild. First argument is the name.";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
