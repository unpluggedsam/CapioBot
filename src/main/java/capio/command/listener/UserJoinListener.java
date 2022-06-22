package capio.command.listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

/**
 * When a new User joins the server
 */
public class UserJoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        Guild guild = event.getGuild();

        EmbedBuilder eb = new EmbedBuilder();

        eb.setTitle("Welcome " + event.getMember().getEffectiveName()+ " to " + guild.getName());
        eb.setImage(event.getMember().getEffectiveAvatarUrl());
        eb.setDescription("some text about this really cool server");
        eb.setFooter("Made by Zehc2", "https://img.freepik.com/free-vector/hand-painted-watercolor-galaxy-background_52683-63441.jpg?w=2000");

        event.getGuild().getTextChannelsByName("welcome", true).get(0).sendMessageEmbeds(eb.build()).queue();
    }
}
