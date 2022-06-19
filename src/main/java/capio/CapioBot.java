package capio;

import capio.command.handle.CommandHandler;
import capio.config.ConfigReader;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class CapioBot {

    public static final String prefix = "^";

    public static void main(String[] args) throws LoginException {
        JDA bot = JDABuilder.createDefault(ConfigReader.getToken())
                .setActivity(Activity.listening("Serving the loldirt guild"))
                        .build();

        bot.addEventListener(new CommandHandler());

    }
}
