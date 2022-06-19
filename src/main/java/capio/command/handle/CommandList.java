package capio.command.handle;

import capio.command.bot_commands.Command;
import capio.command.bot_commands.DeleteCommand;
import capio.command.bot_commands.PingPong;

import java.util.Collections;
import java.util.List;

/**
 * A list of all the {@link Command} Objects that can be used
 */
public class CommandList {

    private static List<Command> commandList = List.of(new PingPong(), new DeleteCommand());

    private CommandList() {

    }

    public static List<Command> getCommandList() {
        return Collections.unmodifiableList(commandList);
    }
}
