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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Guild> getGuildFromHTML(int amount, String guildName) {

        ArrayList<Guild> guildList = new ArrayList<Guild>();

        Elements tbody =  doc.select("tbody");
        Elements tr = tbody.select("tr");




        tr.forEach(td -> {
            Guild guild = new Guild();
            guild.setPosition(Integer.parseInt(td.child(0).text()));
            guild.setName(td.child(2).text());
            guild.setLevel(Double.parseDouble(td.child(3).text()));
            guild.setExp(td.child(5).text());

            guildList.add(guild);
        });

        int index = IntStream.range(0, guildList.size())
                .filter(i -> guildList.get(i).getName().equals(guildName))
                .findFirst()
                .orElse(-1);

        return guildList.subList(index - amount / 2, index + amount / 2);
    }

}
