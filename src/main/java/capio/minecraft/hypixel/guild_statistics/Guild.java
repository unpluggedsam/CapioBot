package capio.minecraft.hypixel.guild_statistics;

import capio.minecraft.hypixel.HypixelAPIKey;
import net.hypixel.api.HypixelAPI;

import java.util.concurrent.ExecutionException;

public class Guild {

    private final HypixelAPI api = HypixelAPIKey.getHypixelAPIKey();

    public double getLevel(String name)  {
        try {
           return IGuildLeveling.getExactLevel(api.getGuildByName(name).get().getGuild().getExp());
        }  catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
