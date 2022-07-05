package capio.minecraft.hypixel;

import capio.minecraft.hypixel.guild_statistics.IGuildLeveling;
import capio.minecraft.users.Player;
import com.google.gson.JsonObject;
import net.hypixel.api.HypixelAPI;
import net.hypixel.api.reply.GuildReply;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class HypixelAPIHelper {

    private static final HypixelAPI api = HypixelAPIKey.getHypixelAPIKey();

    public static double getGuildLevel(final String name)  {
        try {
            return IGuildLeveling.getExactLevel(HypixelAPIHelper.api.getGuildByName(name).get().getGuild().getExp());
        }  catch (final ExecutionException e) {
            throw new RuntimeException(e);
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static GuildReply.Guild getGuildByName(final String name) {
        try {
            return api.getGuildByName(name).get().getGuild();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getAmountOfMembersInGuild(final String name) {
        return getGuildByName(name).getMembers().size();
    }

    public static int getAmountOfMembersInGuild(final GuildReply.Guild guild) {
        return guild.getMembers().size();
    }

    public static List<GuildReply.Guild.Member> getGuildsPlayers(String name) {
        return getGuildByName(name).getMembers();
    }

    public static List<GuildReply.Guild.Member> getGuildsPlayers(final GuildReply.Guild guild) {
        return guild.getMembers();
    }



    public static Player createPlayerFromUsername(final String name) {
        try {
            final JsonObject jsonPlayerObject = HypixelAPIHelper.api.getPlayerByUuid(name).get().getPlayer();

            // set player fields by the json object

            return null;
        } catch (final InterruptedException e) {
            throw new RuntimeException(e);
        } catch (final ExecutionException e) {
            throw new RuntimeException(e);
        }
    }



}
