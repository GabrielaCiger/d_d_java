package Personnages;
import Equipement.Shield;
import Equipement.Weapon;

public class Goblin extends Personnage {
    public Goblin() {
        super("Goblin", "enemy");
        this.attackStrength = 2;
        this.life = 6;
        this.equipmentOffensive = new Weapon("Wooden sword", 1);
        this.equipmentDefensif = new Shield("Leather armor", 0);
    }
}
