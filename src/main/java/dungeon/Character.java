package dungeon;

import org.apache.commons.lang3.StringUtils;

public class Character {

    private int ID;
    private String name;
    private int level;

    public Character(String name) {
        this.name = StringUtils.capitalize(name);
        this.level = 1;
    }

    public Character(String name, int level) {
        this.name = StringUtils.capitalize(name);
        this.level = level;
    }

    public Character(int ID, String name, int level) {
        this(name,level);
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
