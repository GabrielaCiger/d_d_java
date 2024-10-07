package Equipement;

public class EquipementDefensif {
    String name;
    int defenseLevel;

    public EquipementDefensif(String name) {
        this.name = name;
        setDefenseLevel(name);
    }

    public String getDefenseWeaponName() {
        return name;
    }
    public int getDefenseLevel() {
        return defenseLevel;
    }
    public void setDefenseLevel(String name){
        switch (name){
            case "shield": this.defenseLevel = 3;
                break;
            case "potion" : this.defenseLevel = 2;
                break;
            default: this.defenseLevel = 0;
        }
    }
}
