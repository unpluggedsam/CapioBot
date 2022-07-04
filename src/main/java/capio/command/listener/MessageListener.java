package capio.command.listener;

import capio.bot.CapioBot;
import capio.command.bot_commands.Command;
import capio.command.handle.CommandBuilder;
import capio.command.handle.CommandHandler;
import capio.command.handle.CommandList;
import capio.command.handle.GuildCommandsHandler;
import capio.command.permission_handle.PermissionController;
import capio.command.permission_handle.PermissionEnum;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Map;
import java.util.Optional;

public class MessageListener extends ListenerAdapter {
    private final CommandHandler handler = new CommandHandler();

    @Override
    public void onMessageReceived(final MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(CapioBot.prefix)) {
            final Guild guild = event.getGuild();
            final String[] args = event.getMessage().getContentRaw().split("\\s+");

            handler.executeCommand(CommandBuilder.createCommand(args[0].substring(1), guild), event, args, new GuildCommandsHandler());
        }
    }
}
