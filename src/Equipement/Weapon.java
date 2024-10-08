package Equipement;

public class Weapon extends EquipementOffensif {
    public Weapon() {
        this.name = "Rusty sword";
        this.attackLevel = 5;
    }
    public Weapon(String newName, int newAttackLevel) {
        super(newName, newAttackLevel);
    }
}
