package capio.command.bot_commands.hypixel.application;

import capio.command.bot_commands.Command;
import capio.command.bot_commands.in_game_commands.guild_managment.GuildInviteCommand;
import capio.minecraft.hypixel.HypixelAPIHelper;
import capio.minecraft.hypixel.RequiredStatistics;
import capio.minecraft.users.Player;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ApplyCommand implements Command {

    RequiredStatistics stats = new RequiredStatistics();
    Command command;
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        Player player = HypixelAPIHelper.createPlayerFromUsername(args[1]);

        if(stats.doesUserMeetRequirements(player)) {
            command = new GuildInviteCommand();
            command.execute(event, args);
        }
    }

    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

}
