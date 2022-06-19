package capio.command.bot_commands.misc_commands;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingPong implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getGuildChannel().sendMessage("Pong!").queue();
    }

    @Override
    public String getCommandName() {
        return "ping";
    }

    @Override
    public String getDescription() {
        return "Let's play some pingpong!";
    }


}
