package personnages.heroes;
import equipement.defensif.Shield;
import equipement.offensif.Weapon;
import personnages.Personnage;

public class Warrior extends Personnage {
    public Warrior(String name) {
        super(name, "warrior", 10);
        this.attackStrength = 10;
        this.equipmentDefensif = new Shield();
        this.equipmentOffensive = new Weapon();
    }

    public Warrior(String name, String type, int life, int maxLife, int strength, String weaponName, int weaponAttack, String shieldName, int shieldDefense) {
        super(name, type, life, maxLife, strength);
        this.equipmentOffensive = new Weapon(weaponName, weaponAttack);
        this.equipmentDefensif = new Shield(shieldName, shieldDefense);
    }

}
