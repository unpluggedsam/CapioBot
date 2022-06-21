package capio.command.bot_commands.hypixel.guild;

import capio.command.bot_commands.Command;
import capio.command.permission_handle.AdminPermission;
import capio.command.permission_handle.BasicPermission;
import capio.command.permission_handle.PermissionController;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class DisplayGuildLeaderboardHourlyCommand implements Command {

    private boolean isEnabled = false;

    private final Command glc = new GuildLeaderboardCommand();






    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        final Timer timer = new Timer();
        TimerTask hourlyTask = new TimerTask() {
            @Override
            public void run() {
                if(isEnabled) {
                    glc.execute(event, args);
                } else {
                    timer.cancel();
                }

            }
        };

        if(!isEnabled) {
            event.getGuildChannel().sendMessage("Enabled GuildLeaderboardCommand").queue();
            isEnabled = true;

            timer.schedule (hourlyTask, 0l, 1000*60*60*3);
        }
        else {
            event.getGuildChannel().sendMessage("Disabled GuildLeaderboardCommand").queue();
            isEnabled = false;
        }



    }

    @Override
    public String getCommandName() {
        return "print-leaderboard";
    }

    @Override
    public List<PermissionController> getPermissionController() {
         return List.of(new AdminPermission());
    }

    @Override
    public String getDescription() {
        return "Print the guild leaderboard in a channel every 3 hours. ";
    }
}
