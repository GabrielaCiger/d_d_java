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

}
