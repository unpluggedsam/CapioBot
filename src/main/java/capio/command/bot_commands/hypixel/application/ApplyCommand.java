package capio.command.bot_commands.hypixel.application;

import capio.command.bot_commands.Command;
import capio.minecraft.hypixel.HypixelAPIHelper;
import capio.minecraft.hypixel.RequiredStatistics;
import capio.minecraft.users.Player;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class ApplyCommand implements Command {

    RequiredStatistics stats = new RequiredStatistics();
    Command command;
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final Map<Class<? extends Command>, Command> commandList) {
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
