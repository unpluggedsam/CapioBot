package capio.command.handle;

import capio.command.bot_commands.Command;
import capio.command.bot_commands.moderation_commands.DeleteCommand;
import capio.command.bot_commands.ListCommand;
import capio.command.bot_commands.PingPong;

import java.util.Collections;
import java.util.List;

/**
 * A list of all the {@link Command} Objects that can be used.
 * If a new {@link Command} object is created then all the developer has
 * to do to enable it is add it to the <code>commandList</code> {@link List}.
 */
public class CommandList {

    private static List<Command> commandList = List.of(new PingPong(), new DeleteCommand(), new ListCommand());

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
