package capio.command.bot_commands.misc;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class PingPong implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {
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
