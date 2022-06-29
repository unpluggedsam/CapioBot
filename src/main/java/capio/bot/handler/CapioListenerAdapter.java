package capio.bot.handler;

import capio.bot.CapioBot;
import capio.command.handle.CommandBuilder;
import capio.command.handle.CommandHandler;
import capio.command.handle.CommandList;
import capio.command.listener.MessageListener;
import capio.command.listener.UserJoinListener;
import capio.command_observer.CommandExecutedObserver;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class CapioListenerAdapter extends ListenerAdapter implements CommandExecutedObserver {

    private static final String loadingString = "Attempting to load Command .";
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(CapioBot.prefix)) {
            event.getGuildChannel().sendMessage(loadingString);
            Handler handler = createHandlerFromGuild(event.getGuild());
            handler.getCommandHandler().onMessageReceived(event);
        }
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Handler handler = createHandlerFromGuild(event.getGuild());
        handler.getUserJoinListener().onGuildMemberJoin(event);
    }

    private Handler createHandlerFromGuild(Guild guild) {
        if (CapiosGuilds.getHandlerFromGuild(guild) != null) {
            return CapiosGuilds.getHandlerFromGuild(guild);
        } else {
            Handler handler = new Handler();
            handler.setCommandHandler(new MessageListener());
            handler.setUserJoinListener(new UserJoinListener());
            CapiosGuilds.addGuild(guild, handler);
            return handler;
        }
    }

    @Override
    public void commandExecuted(MessageReceivedEvent event) {
        List<Message> messages = event.getChannel().getHistory().retrievePast(5).complete();
        event.getGuildChannel().deleteMessages(messages.stream().filter(message -> message.getContentRaw().equals(loadingString)).collect(Collectors.toList())).queue();
    }
}

