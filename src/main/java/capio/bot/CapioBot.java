package capio.bot;

import capio.command.listener.MessageListener;
import capio.command.listener.ReadyListener;
import capio.config.ConfigReader;
import capio.command.listener.UserJoinListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class CapioBot {

    public static final String prefix = "^";


    public static void main(final String[] args) throws LoginException {
        final JDA bot = JDABuilder.createDefault(ConfigReader.getDiscordToken())
                .setActivity(Activity.listening("Serving the loldirt guild"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                        .build();

        bot.addEventListener(new MessageListener());
        bot.addEventListener(new ReadyListener());
        bot.addEventListener(new UserJoinListener());
    }
}
