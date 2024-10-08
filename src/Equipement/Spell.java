package Equipement;

public class Spell extends EquipementOffensif {
    public Spell() {
        this.name = "Simple spell";
        this.attackLevel = 3;
    }

    public Spell(String newName, int newAttackLevel) {
        this.name = newName;
        this.attackLevel = newAttackLevel;
    }
}
