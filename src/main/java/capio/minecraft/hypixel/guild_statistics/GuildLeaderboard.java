package capio.minecraft.hypixel.guild_statistics;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GuildLeaderboard {


    private final Document doc;

    public GuildLeaderboard() {
        try {
            doc = Jsoup.connect("https://sk1er.club/leaderboards/newdata/GUILD_LEVEL").get();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parses the sk1er.club website to get the guild leaderboard information.
     * @param amount Amount of guilds around the retrieved guild the List should return.
     * @param guildName The name of the guild that the User is trying to access.
     * @return
     */
    public List<Guild> getGuildFromHTML(final int amount, final String guildName) {

        final ArrayList<Guild> guildList = new ArrayList<Guild>();

        final Elements tbody =  doc.select("tbody");
        final Elements tr = tbody.select("tr");

        tr.forEach(td -> {
            final Guild guild = new Guild();
            guild.setPosition(Integer.parseInt(td.child(0).text()));
            guild.setName(td.child(2).text());
            guild.setLevel(Double.parseDouble(td.child(3).text()));
            guild.setExp(td.child(5).text());

            guildList.add(guild);
        });

        final int index = IntStream.range(0, guildList.size())
                .filter(i -> guildList.get(i).getName().equalsIgnoreCase(guildName))
                .findFirst()
                .orElse(-1);

        try {
            return guildList.subList(index - amount / 2, index + amount / 2);
        } catch(final IndexOutOfBoundsException e) {
            try {
                return guildList.subList((index + 1) * -1, amount);
            } catch(final IndexOutOfBoundsException e1) {
                try {
                    return guildList.subList(index + 1, amount);
                } catch(final IndexOutOfBoundsException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }
}
