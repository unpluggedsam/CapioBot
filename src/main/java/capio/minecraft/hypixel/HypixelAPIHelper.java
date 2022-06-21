package capio.minecraft.hypixel;

import capio.minecraft.hypixel.guild_statistics.IGuildLeveling;
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


}
