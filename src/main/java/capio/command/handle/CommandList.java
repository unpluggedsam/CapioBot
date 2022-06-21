package capio.command.handle;

import capio.command.bot_commands.Command;
import capio.command.bot_commands.hypixel.guild.CurrentGuildLevelCommand;
import capio.command.bot_commands.hypixel.guild.DisplayGuildLeaderboardHourlyCommand;
import capio.command.bot_commands.hypixel.guild.GuildLeaderboardCommand;
import capio.command.bot_commands.moderation.BanCommand;
import capio.command.bot_commands.moderation.DeleteCommand;
import capio.command.bot_commands.help.ListCommand;
import capio.command.bot_commands.misc.PingPong;
import capio.command.bot_commands.moderation.KickCommand;
import capio.command.bot_commands.moderation.MuteCommand;

import java.util.Collections;
import java.util.List;

/**
 * A list of all the {@link Command} Objects that can be used.
 * If a new {@link Command} object is created then all the developer has
 * to do to enable it is add it to the <code>commandList</code> {@link List}.
 */
public class CommandList {

    private static final List<Command> commandList = List.of(
            new PingPong(), new DeleteCommand(), new ListCommand(),
            new KickCommand(), new BanCommand(), new MuteCommand(),
            new CurrentGuildLevelCommand(), new GuildLeaderboardCommand(),
            new DisplayGuildLeaderboardHourlyCommand(), new DisplayGuildLeaderboardHourlyCommand());

    private CommandList() {

    }

    /**
     *
     * @return A {@link List} of all the {@link Command}'s.
     */
    public static List<Command> getCommandList() {
        return Collections.unmodifiableList(commandList);
    }
}
