package dungeon.weapons;

public interface Weapon {
    double attack();
    int getWeaponLevel();
    String getDescription();
    boolean levelUpWeapon();
    WeaponType getWeaponType();


}
