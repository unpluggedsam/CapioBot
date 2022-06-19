package capio.command.handle;

import capio.command.bot_commands.Command;
import capio.command.bot_commands.DeleteCommand;
import capio.command.bot_commands.PingPong;

import java.util.Collections;
import java.util.List;

/**
 * A list of all the {@link Command} Objects that can be used.
 * When creating a new command add it to the List.
 */
public class CommandList {

    private static List<Command> commandList = List.of(new PingPong(), new DeleteCommand());

    private CommandList() {

    }
    public static List<Command> getCommandList() {
        return Collections.unmodifiableList(commandList);
    }
}
