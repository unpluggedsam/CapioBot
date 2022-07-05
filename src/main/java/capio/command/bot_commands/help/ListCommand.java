package capio.command.bot_commands.help;

import capio.command.bot_commands.Command;
import capio.command.handle.GuildCommandsHandler;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

/**
 * List all of the Commands that the bot has in an embed
 */
public class ListCommand implements Command {
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final GuildCommandsHandler guildCommandsHandler) {

        final EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Command List")
                .setColor(Color.red);

        guildCommandsHandler.getGuildCommandList(event.getGuild()).getCommandList().values().stream().forEach(command -> {
            embed.addField(command.getCommandName(), command.getDescription() + " \n ```PERMISSION: " + command.getPermissionEnum() + "``` \n\n\n", false);
        });

        event.getGuildChannel().sendMessageEmbeds(embed.build()).queue();
    }

    @Override
    public String getCommandName() {
        return "commands";
    }

    @Override
    public String getDescription() {
        return "A list of all the Capio commands.";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
