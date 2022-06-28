package capio.bot;

import capio.bot.handler.CapioListenerAdapter;
import capio.command.handle.CommandHandler;
import capio.config.ConfigReader;
import capio.command.listener.UserJoinListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class CapioBot {

    public static final String prefix = "^";


    public static void main(String[] args) throws LoginException {
        JDA bot = JDABuilder.createDefault(ConfigReader.getDiscordToken())
                .setActivity(Activity.listening("Serving the loldirt guild"))
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                        .build();

        bot.addEventListener(new CapioListenerAdapter());
    }
}
