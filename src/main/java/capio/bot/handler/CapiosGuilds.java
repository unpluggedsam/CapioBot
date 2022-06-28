package capio.bot.handler;


import net.dv8tion.jda.api.entities.Guild;

import java.util.HashMap;

public class CapiosGuilds {

    private static HashMap<Guild, Handler> guilds = new HashMap<Guild, Handler>();


    public static Handler getHandlerFromGuild(Guild guild) {
        return guilds.get(guild);
    }

    public static void addGuild(Guild guild, Handler handler) {
        CapiosGuilds.guilds.put(guild, handler);
    }


}
