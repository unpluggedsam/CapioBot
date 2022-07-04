package capio.command.listener;

import capio.bot.CapioBot;
import capio.command.handle.CommandBuilder;
import capio.command.handle.CommandHandler;
import capio.command.handle.CommandList;
import capio.command.handle.GuildCommandsHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Optional;

public class MessageListener extends ListenerAdapter {
    private final CommandHandler handler = new CommandHandler();
    private final GuildCommandsHandler guildCommandHandler = new GuildCommandsHandler();

    @Override
    public void onMessageReceived(final MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(CapioBot.prefix)) {
            final Guild guild = event.getGuild();
            final Optional<CommandList> commandList = Optional.ofNullable(guildCommandHandler.getGuildCommandList(guild));
            commandList.ifPresentOrElse((localCommandList) -> {
                final String[] args = event.getMessage().getContentRaw().split("\\s+");
                handler.executeCommand(CommandBuilder.createCommand(args[0].substring(1), commandList.get().getCommandList()), event, args, guildCommandHandler);
            }, () -> {
                guildCommandHandler.addGuild(guild);
            });
        }
    }
}
