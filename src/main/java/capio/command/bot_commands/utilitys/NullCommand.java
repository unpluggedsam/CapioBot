package capio.command.bot_commands.utilitys;

import capio.bot.CapioBot;
import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

/**
 * A command used to avoid a {@link NullPointerException} being thrown
 * when a User trys to enter a {@link Command} that does not exist.
 */
public class NullCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {
        event.getGuildChannel().sendMessage("Not a valid command! Use " + CapioBot.prefix + "commands to get a full list of commands.").queue();
    }

    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
