package capio.command.bot_commands.hypixel.application;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class DenyCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {

    }

    @Override
    public String getCommandName() {
        return "deny";
    }

    @Override
    public String getDescription() {
        return "Deny a player from the guild. First argument is the mention of the User that is being denied.";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
