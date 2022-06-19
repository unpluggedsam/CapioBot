package capio.command.bot_commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * A command used to avoid a {@link NullPointerException} being thrown
 * when a User trys to enter a {@link Command} that does not exist.
 */
public class NullCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getGuildChannel().sendMessage("Not a valid command!").queue();
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
