package capio.command.handle;

import net.dv8tion.jda.api.entities.Guild;

import java.util.HashMap;
import java.util.Map;

public class GuildCommandsHandler {
    private Map<Guild, CommandList> guildCommandList = new HashMap();

    public void addGuild(Guild guild) {
        guildCommandList.put(guild, new CommandList());
    }

    public CommandList getGuildCommandList(Guild guild) {
        return guildCommandList.get(guild);
    }

}
