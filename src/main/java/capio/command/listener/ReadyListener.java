package capio.command.listener;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(@Nonnull final ReadyEvent event) {

    }

    public void onGuildReady(@Nonnull GuildReadyEvent event) {
        if(event.getGuild().getRolesByName("admin", true) == null) {
            event.getGuild().createRole().setName("admin");
        }
    }
}
