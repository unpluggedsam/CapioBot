package capio.minecraft.hypixel;

import capio.config.ConfigReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.skyerzz.hypixellib.util.hypixelapi.HypixelPlayer;
import com.skyerzz.hypixellib.util.hypixelapi.PlayerAPI;
import net.hypixel.api.HypixelAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HypixelAPIWrapper {

    public static HypixelPlayer getPlayer(String username) {
        return new HypixelPlayer(getUUID(username), ConfigReader.getHypixelAPIKey());
    }

    public static String getUUID(String name) {
        String uuid = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL("https://api.mojang.com/users/profiles/minecraft/" + name).openStream()));
            uuid = (((JsonObject)new JsonParser().parse(in)).get("id")).toString().replaceAll("\"", "");
            uuid = uuid.replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
            in.close();
        } catch (Exception e) {
            System.out.println("Unable to get UUID of: " + name + "!");
            uuid = "er";
        }
        return uuid;
    }
}
