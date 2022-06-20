package capio.command.bot_commands.hypixel.guild;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.hypixel.api.HypixelAPI;

import java.util.UUID;

public class GuildLeaderboardCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        HypixelAPI api = new HypixelAPI(UUID.fromString("9b455d0b-249b-4e04-90bb-aabee463ef6c"));


    }

    @Override
    public String getCommandName() {
        return "leaderboard";
    }

    @Override
    public String getDescription() {
        return "Gets the guilds current position in the leaderboard.";
    }
}
