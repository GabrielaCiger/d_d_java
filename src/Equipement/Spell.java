package Equipement;

public class Spell extends EquipementOffensif {
    public Spell() {
        this.name = "Spell";
        this.attackLevel = 4;
    }

    public Spell(String newName, int newAttackLevel) {
        this.name = newName;
        this.attackLevel = newAttackLevel;
    }
}
