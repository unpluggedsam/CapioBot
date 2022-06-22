package capio.minecraft.hypixel;

import capio.minecraft.hypixel.guild_statistics.IGuildLeveling;
import capio.minecraft.users.Player;
import com.google.gson.JsonObject;
import net.hypixel.api.HypixelAPI;

import java.util.concurrent.ExecutionException;

public class HypixelAPIHelper {

    private final static HypixelAPI api = HypixelAPIKey.getHypixelAPIKey();

    public static double getGuildLevel(String name)  {
        try {
            return IGuildLeveling.getExactLevel(api.getGuildByName(name).get().getGuild().getExp());
        }  catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Player createPlayerFromUsername(String name) {
        try {
            JsonObject jsonPlayerObject = api.getPlayerByUuid(name).get().getPlayer();

            // set player fields by the json object

            return null;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
