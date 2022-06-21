package capio.command.bot_commands.hypixel.guild;

import capio.command.bot_commands.Command;
import capio.minecraft.hypixel.guild_statistics.Guild;
import capio.minecraft.hypixel.guild_statistics.GuildLeaderboard;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.hypixel.api.HypixelAPI;

import java.awt.*;


public class GuildLeaderboardCommand implements Command {

    private final GuildLeaderboard guildLB = new GuildLeaderboard();
    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Guild Leaderboard", null);

        guildLB.getGuildFromHTML(6, args[1]).forEach(guild -> {
            if(guild.getName().equals(args[1])) eb.addField(String.format("_`%s. %s - %s (%s)`_", guild.getPosition(), guild.getName(), guild.getLevel(), guild.getExp()),  "** **", false);
            else eb.addField(String.format("\n`%s. %s - %s (%s)`", guild.getPosition(), guild.getName(), guild.getLevel(), guild.getExp()), "** **", false);
        });

        eb.setColor(Color.CYAN);

        event.getGuildChannel().sendMessageEmbeds(eb.build()).queue();
    }

    @Override
    public String getCommandName() {
        return "leaderboard";
    }

    @Override
    public String getDescription() {
        return "Gets the guilds current position in the leaderboard.";
    }
}
