package capio.minecraft.hypixel;

import capio.minecraft.hypixel.guild_statistics.IGuildLeveling;
import capio.minecraft.users.Player;
import com.google.gson.JsonObject;
import net.dv8tion.jda.api.entities.Guild;
import net.hypixel.api.HypixelAPI;

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

    public static Guild getGuildByName(final String name) {
        try {
            return (Guild) api.getGuildByName(name).get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
