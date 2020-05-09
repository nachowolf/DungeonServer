package dungeon.player;

import dungeon.weapons.Fists;
import dungeon.weapons.Weapon;
import org.apache.commons.lang3.StringUtils;

public class Player {

    private String name;
    private int level;
    private Weapon fists;
    private Weapon activeWeapon;
    private Weapon sheathedWeapon;

    public Player(String name) {
        this.name = StringUtils.capitalize(name);
        this.level = 1;
        this.fists = new Fists(this.level);
        this.activeWeapon = fists;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void equipWeapon(Weapon weapon){
        this.activeWeapon = weapon;
    }

    public void sheathWeapon(){
        this.sheathedWeapon = activeWeapon;
        this.activeWeapon = fists;
    }
}
