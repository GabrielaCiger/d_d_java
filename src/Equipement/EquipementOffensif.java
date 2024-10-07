package Equipement;

import java.security.PublicKey;

public class EquipementOffensif {
    protected String name;
    protected int attackLevel;

    public EquipementOffensif() {
        this.name = "Attack weapon";
        this.attackLevel = 0;
    }

    public EquipementOffensif(String name) {
        this.name = name;
        setAttackLevel(name);
    }

    public String getWeaponName() {
        return name;
    }
    public Integer getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(String name){
        switch (name){
            case "weapon": this.attackLevel = 5;
            break;
            case "spell" : this.attackLevel = 7;
            break;
            default: this.attackLevel = 0;
        }
    }
}
