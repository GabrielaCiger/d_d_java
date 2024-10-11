package personnages.heroes;
import equipement.defensif.Potion;
import equipement.offensif.Spell;
import personnages.Personnage;

public class Wizard extends Personnage {
    public Wizard(String name) {
        super(name, "wizard", 6);
        this.attackStrength = 15;
        this.equipmentDefensif = new Potion();
        this.equipmentOffensive = new Spell();
    }
}
