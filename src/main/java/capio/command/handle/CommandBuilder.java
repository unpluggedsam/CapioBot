package capio.command.handle;


import capio.command.bot_commands.Command;
import capio.command.bot_commands.utilitys.NullCommand;

/**
 * Builds {@link Command} Objects
 */
public class CommandBuilder {


    /**
     * Checks the {@link CommandList#getCommandList} method to see if the name
     * that the User entered is a {@link Command} that exists.
     * @param commandName the name of the Command the User is trying to use.
     * @return a {@link Command} with the name that the user enters or a
     * {@link NullCommand}.
     */
    public static Command createCommand(String commandName) {

        final Command[] command = new Command[1];

        CommandList.getCommandList().values().stream().filter(Command -> Command.getCommandName().equalsIgnoreCase(commandName)).findFirst().ifPresentOrElse(
                (Command) -> command[0] = Command,
                () -> command[0] = new NullCommand()
        );
        return command[0];
    }
}
