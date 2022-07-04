package capio.command.bot_commands.hypixel.guild;

import capio.command.bot_commands.Command;
import capio.minecraft.hypixel.guild_statistics.GuildLeaderboard;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class GuildLeaderboardCommand implements Command {

    private final GuildLeaderboard guildLB = new GuildLeaderboard();
    @Override
    public void execute(final MessageReceivedEvent event, final String[] args, final Map<Class<? extends Command>, Command> commandList) {

        final EmbedBuilder eb = new EmbedBuilder();
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
