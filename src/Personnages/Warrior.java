package Personnages;
import Equipement.Shield;
import Equipement.Weapon;

public class Warrior extends Personnage {

    public Warrior(String name) {
        super(name, "warrior");
        this.life = 10;
        this.attackStrength = 10;
        this.equipmentDefensif = new Shield();
        this.equipmentOffensive = new Weapon();
    }

}
