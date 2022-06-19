package capio.command.bot_commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * A command that does nothing
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

}
