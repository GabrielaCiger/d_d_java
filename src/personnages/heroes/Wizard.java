package personnages.heroes;
import equipement.defensif.Potion;
import equipement.defensif.Shield;
import equipement.offensif.Spell;
import equipement.offensif.Weapon;
import personnages.Personnage;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Wizard extends Personnage {

    public Wizard(String name) {
        super(name, "wizard", 6);
        this.attackStrength = 14;
        this.equipmentDefensif = new Potion();
        this.equipmentOffensive = new Spell();
        this.id = creationTimeHashed() + name.hashCode() + type.hashCode();
    }

    public Wizard(String name, String type, int life, int maxLife, int strength, String attackName, int attackValue, String defenseName, int defenseValue) {
        this.name = name;
        this.type = type;
        this.life = life;
        this.maxLife = maxLife;
        this.attackStrength = strength;
        this.equipmentOffensive = new Spell(attackName, attackValue);
        this.equipmentDefensif = new Potion(defenseName, defenseValue);
    }

    @Override
    public String toString() {
        return  "Name: " + this.name +
                ", Type: " + this.type +
                ", Life: " + this.life +
                ", Max Life: " + this.maxLife;
    }



}
