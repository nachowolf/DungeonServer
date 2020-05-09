package dungeon.weapons;

import java.util.Random;

public abstract class BaseWeapon implements Weapon {

    protected final WeaponType weaponType;
    protected int level;

    protected BaseWeapon(WeaponType weaponType, int level) {
        this.weaponType = weaponType;
        this.level = level;
    }

    @Override
    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    @Override
    public double attack() {
        Random random = new Random();
        double dmg = (random.nextDouble() + random.nextInt(level));
        dmg = dmg * 100;
        dmg = Math.round(dmg);
        dmg = dmg /100;
        return dmg;
    }

    @Override
    public int getWeaponLevel() {
        return this.level;
    }

    @Override
    public boolean levelUpWeapon(){
        if(this.level < weaponType.getCappedLevel()){
            level++;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getDescription() {
        return weaponType.getDescription();
    }


}
