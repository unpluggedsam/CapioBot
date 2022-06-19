package capio.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Reads the config.properties file.
 */
public class ConfigReader {

    public static String getToken() {
        try {
            final Properties prop = new Properties();
            final File file = new File("src/main/resources/config.properties");
            final FileInputStream ip = new FileInputStream(file);
            prop.load(ip);
            return prop.getProperty("token");
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
