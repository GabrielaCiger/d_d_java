package personnages.heroes;
import equipement.defensif.Potion;
import equipement.defensif.Shield;
import equipement.offensif.Spell;
import equipement.offensif.Weapon;
import personnages.Personnage;

public class Wizard extends Personnage {
    public Wizard(String name) {
        super(name, "wizard", 6);
        this.attackStrength = 14;
        this.equipmentDefensif = new Potion();
        this.equipmentOffensive = new Spell();
    }

    public Wizard(String name, String type, int life, int maxLife, int strength, String attackName, int attackValue, String defenseName, int defenseValue) {
        super(name, type, life, maxLife, strength);
        this.equipmentOffensive = new Spell(attackName, attackValue);
        this.equipmentDefensif = new Potion(defenseName, defenseValue);
    }
}
