package capio.command.bot_commands.hypixel.application;

import capio.command.bot_commands.Command;
import capio.command.bot_commands.in_game_commands.guild_managment.GuildInviteCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AcceptCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        Command command = new GuildInviteCommand();
        command.execute(event, args);
    }

    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
