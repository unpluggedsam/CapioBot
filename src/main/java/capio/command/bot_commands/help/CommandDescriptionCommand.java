package capio.command.bot_commands.help;

import capio.command.bot_commands.Command;
import capio.command.handle.CommandBuilder;
import capio.command.handle.GuildCommandsHandler;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class CommandDescriptionCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args, GuildCommandsHandler guildCommandsHandler) {

        Command command = CommandBuilder.createCommand(args[1], event.getGuild());

        final EmbedBuilder embed = new EmbedBuilder()
                .setColor(Color.red)
                .addField(command.getCommandName(), command.getDescription(), false);

        event.getGuildChannel().sendMessageEmbeds(embed.build()).queue();
    }

    @Override
    public String getCommandName() {
        return "get-command";
    }

    @Override
    public String getDescription() {
        return "Gets a description of a command. First argument is the command name.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
