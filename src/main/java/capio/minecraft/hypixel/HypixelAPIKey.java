package capio.minecraft.hypixel;

import capio.config.ConfigReader;
import net.hypixel.api.HypixelAPI;

import java.util.UUID;

public class HypixelAPIKey {

    static HypixelAPI api;

    private HypixelAPIKey() {

    }

    public static HypixelAPI getHypixelAPIKey() {
        if(HypixelAPIKey.api == null) HypixelAPIKey.api = new HypixelAPI(UUID.fromString(ConfigReader.getHypixelAPIKey()));
        return HypixelAPIKey.api;
    }
}
