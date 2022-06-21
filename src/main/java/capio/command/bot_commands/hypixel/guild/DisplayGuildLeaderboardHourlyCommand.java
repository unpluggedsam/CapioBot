package capio.command.bot_commands.hypixel.guild;

import capio.command.bot_commands.Command;
import capio.command.permission_handle.AdminPermission;
import capio.command.permission_handle.BasicPermission;
import capio.command.permission_handle.PermissionController;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.concurrent.*;

public class DisplayGuildLeaderboardHourlyCommand implements Command {

    private boolean isEnabled;

    private final Command glc = new GuildLeaderboardCommand();


    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        if(!isEnabled) isEnabled = true;
        else isEnabled = false;
        while(isEnabled) {
            ScheduledExecutorService scheduledExecutorService =
                    Executors.newScheduledThreadPool(5);

            ScheduledFuture scheduledFuture =
                    scheduledExecutorService.schedule(new Callable() {
                                                          public Object call() throws Exception {
                                                              glc.execute(event, args);
                                                              return "Called!";
                                                          }
                                                      },
                            3,
                            TimeUnit.HOURS);
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
