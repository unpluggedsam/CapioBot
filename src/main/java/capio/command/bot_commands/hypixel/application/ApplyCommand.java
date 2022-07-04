package capio.command.bot_commands.hypixel.application;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import capio.minecraft.hypixel.HypixelAPIHelper;
import capio.minecraft.hypixel.RequiredStatistics;
import capio.minecraft.users.Player;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ApplyCommand implements Command {

    RequiredStatistics stats = new RequiredStatistics();
    Command command;
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {
        final Player player = HypixelAPIHelper.createPlayerFromUsername(args[1]);
    }

    @Override
    public String getCommandName() {
        return "apply";
    }

    @Override
    public String getDescription() {
        return "Apply to the guild. First argument is the applicants IGN.";
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
