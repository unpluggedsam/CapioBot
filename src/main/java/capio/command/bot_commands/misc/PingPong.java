package capio.command.bot_commands.misc;

import capio.command.bot_commands.Command;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;

public class PingPong implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args,  Map<Class<? extends Command>, Command> commandList) {
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

    @Override
    public boolean isEnabled() {
        return true;
    }


}
