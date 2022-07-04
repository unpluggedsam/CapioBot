package capio.command.listener;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(@Nonnull final ReadyEvent event) {

    }

    public void onGuildReady(@Nonnull GuildReadyEvent event) {
        if(event.getGuild().getRolesByName("admin", true).isEmpty()) {
            event.getGuild().createRole()
                    .setName("Admin")
                    .setColor(Color.red)
                    .setHoisted(true)
                    .setMentionable(false)
                    .setPermissions(Permission.ADMINISTRATOR);
        }
    }
}
