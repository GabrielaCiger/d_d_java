package Equipement;

public abstract class EquipementDefensif {
    protected String name;
    protected int defenseLevel;

    public EquipementDefensif() {
        this.name = "Defense weapon";
    }
    public EquipementDefensif(String name) {
        this.name = name;
        this.defenseLevel = 0;
    }
    public EquipementDefensif(String newName, int newDefenseLevel) {
        this.name = newName;
        this.defenseLevel = newDefenseLevel;
    }
    public String getDefenseWeaponName() {
        return name;
    }
    public int getDefenseLevel() {
        return defenseLevel;
    }
}
