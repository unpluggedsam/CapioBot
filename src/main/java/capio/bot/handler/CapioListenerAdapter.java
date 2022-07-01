package capio.bot.handler;

import capio.bot.CapioBot;
import capio.command.listener.MessageListener;
import capio.command.listener.UserJoinListener;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class CapioListenerAdapter extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().startsWith(CapioBot.prefix)) {
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
}

