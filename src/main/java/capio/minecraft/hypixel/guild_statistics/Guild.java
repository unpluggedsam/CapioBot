package capio.minecraft.hypixel.guild_statistics;

/**
 * Used to keep track of guild objects. 
 */
public class Guild {

    private double level;
    private String exp;

    private int position;
    private String name;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
