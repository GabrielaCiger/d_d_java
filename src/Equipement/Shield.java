package Equipement;

public class Shield extends EquipementDefensif {
    public Shield() {
        this.name = "Shield";
        this.defenseLevel = 2;
    }
    public Shield(String newName, int newDefenseLevel) {
        super(newName, newDefenseLevel);
    }
}
