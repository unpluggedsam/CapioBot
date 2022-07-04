package capio.command.bot_commands.help;

import capio.command.bot_commands.Command;
import capio.command.handle.CommandList;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * List all of the Commands that the bot has in an embed
 */
public class ListCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event, String[] args,  Map<Class<? extends Command>, Command> commandList) {

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Command List")
                .setColor(Color.red);

        commandList.values().stream().forEach(command -> {
            embed.addField(command.getCommandName(), command.getDescription(), false);
        });

        event.getGuildChannel().sendMessageEmbeds(embed.build()).queue();
    }

    @Override
    public String getCommandName() {
        return "commands";
    }

    @Override
    public String getDescription() {
        return "A list of all the Capio commands!";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
