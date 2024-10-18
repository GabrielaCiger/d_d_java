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
        this.id = creationTimeHashed() + name.hashCode() + type.hashCode();
    }

    public Warrior(String name, String type, int life, int maxLife, int strength, String weaponName, int weaponAttack, String shieldName, int shieldDefense) {
        this.name = name;
        this.type = type;
        this.life = life;
        this.maxLife = maxLife;
        this.attackStrength = strength;
        this.equipmentOffensive = new Weapon(weaponName, weaponAttack);
        this.equipmentDefensif = new Shield(shieldName, shieldDefense);
    }

    @Override
    public String toString() {
        return  "Name: " + this.name +
                ", Type: " + this.type +
                ", Life: " + this.life +
                ", Max Life: " + this.maxLife;
    }
}
