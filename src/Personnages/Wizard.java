package Personnages;
import Equipement.Potion;
import Equipement.Spell;

public class Wizard extends Personnage {
    public Wizard(String name) {
        super(name, "wizard");
        this.life = 6;
        this.attackStrength = 15;
        this.equipmentDefensif = new Potion();
        this.equipmentOffensive = new Spell();
    }
}
