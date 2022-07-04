package capio.command.bot_commands.hypixel.guild;

import capio.command.bot_commands.Command;
import capio.command.permission_handle.AdminPermission;
import capio.command.permission_handle.PermissionEnum;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.*;

public class DisplayGuildLeaderboardHourlyCommand implements Command {

    private boolean isEnabled;

    private final Command glc = new GuildLeaderboardCommand();

    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final Map<Class<? extends Command>, Command> commandList) {
        Timer timer = new Timer();
        final TimerTask hourlyTask = new TimerTask() {
            @Override
            public void run() {
                if(isEnabled) {
                    glc.execute(event, args, commandList);
                } else {
                    timer.cancel();
                }

            }
        };

        if(!isEnabled) {
            event.getGuildChannel().sendMessage("Enabled GuildLeaderboardCommand").queue();
            isEnabled = true;

            timer.schedule (hourlyTask, 0L, 1000*60*60*3);
        }
        else {
            event.getGuildChannel().sendMessage("Disabled GuildLeaderboardCommand").queue();
            isEnabled = false;
        }

    }

    @Override
    public String getCommandName() {
        return "hourly-leaderboard";
    }

    @Override
    public List<PermissionEnum> getPermissionEnum() {
         return List.of(new AdminPermission());
    }

    @Override
    public String getDescription() {
        return "Print the guild leaderboard in a channel every 3 hours. First argument is the guild that is being tracked.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
