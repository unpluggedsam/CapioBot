package capio.command.listener;

import capio.bot.CapioBot;
import capio.bot.handler.CapiosGuilds;
import capio.bot.handler.Handler;
import capio.command.handle.CommandBuilder;
import capio.command.handle.CommandHandler;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.stream.Collectors;

public class MessageListener extends ListenerAdapter {

    private final CommandHandler handler = new CommandHandler();

    private static final String loadingString = "Attempting to load Command .";
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(CapioBot.prefix)) {
            String[] args = event.getMessage().getContentRaw().split("\\s+");
            handler.executeCommand(CommandBuilder.createCommand(args[0].substring(1)), event, args);
        }
    }
}
