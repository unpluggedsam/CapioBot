package capio.command.handle;

import net.dv8tion.jda.api.entities.Guild;

import java.util.HashMap;
import java.util.Map;

public class GuildCommandsHandler {
    private final Map<Guild, CommandList> guildCommandList = new HashMap();

    public void addGuild(final Guild guild) {
        guildCommandList.put(guild, new CommandList());
    }

    public CommandList getGuildCommandList(final Guild guild) {
        return guildCommandList.get(guild);
    }

}
