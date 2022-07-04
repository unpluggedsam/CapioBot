package capio.command.bot_commands.hypixel.application;

import capio.command.bot_commands.Command;
import capio.command.bot_commands.in_game_commands.guild_managment.GuildInviteCommand;
import capio.command.handle.CommandList;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class AcceptCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final Map<Class<? extends Command>, Command> commandList) {
        final Command command = commandList.get(GuildInviteCommand.class);
        command.execute(event, args, commandList);
    }

    @Override
    public String getCommandName() {
        return "accept";
    }

    @Override
    public String getDescription() {
        return "Accept a member into the guild. First argument is the mention of the User that is being accepted.";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
