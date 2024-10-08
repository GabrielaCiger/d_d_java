package Equipement;

public class Potion extends EquipementDefensif {
    public Potion() {
        this.name = "Potion";
        this.defenseLevel = 2;
    }
    public Potion(String newName, int newDefenseLevel) {
        super(newName, newDefenseLevel);
    }
}
