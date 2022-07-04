package capio.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Reads the discord.properties file.
 */
public class ConfigReader {

    public static String getDiscordToken() {
        try {
            Properties prop = new Properties();
            File file = new File("src/main/resources/discord.properties");
            FileInputStream ip = new FileInputStream(file);
            prop.load(ip);
            return prop.getProperty("token");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getHypixelAPIKey() {
        try {
            Properties prop = new Properties();
            File file = new File("src/main/resources/hypixel.properties");
            FileInputStream ip = new FileInputStream(file);
            prop.load(ip);
            return prop.getProperty("key");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
