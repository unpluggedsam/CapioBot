package capio.command.bot_commands.hypixel.kicklist;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class KicklistCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public String getCommandName() {
        return "kicklist";
    }

    @Override
    public String getDescription() {
        return "Gets the kicklist for a guild. First argument is the guild, second argument is the amount of GXP each member needs.";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
