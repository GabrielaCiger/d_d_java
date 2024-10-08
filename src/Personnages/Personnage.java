package Personnages;

import Equipement.EquipementOffensif;
import Equipement.EquipementDefensif;

public abstract class Personnage {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    protected String type;
    protected String name;
    protected int life;
    protected int attackStrength;
    protected EquipementOffensif equipmentOffensive;
    protected EquipementDefensif equipmentDefensif;

    /* * SETTERS */
    public void setName(String name) {
        if (name.isEmpty()) {
            this.name = "Henry Cavill [default]";
        } else {
            this.name = name;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setAttackStrength(int strength) {
        this.attackStrength = strength;
    }

    public void newEquipementDefensif(EquipementDefensif newDefensif) {
        this.equipmentDefensif = newDefensif;
    }

    public void newEquipementOffensive(EquipementOffensif newWeapon) {
        this.equipmentOffensive = newWeapon;
    }

    /* ? GETTERS */
    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getLife() {
        return this.life;
    }

    public int getAttackStrength() {
        return this.attackStrength;
    }

    public EquipementOffensif getEquipmentOffensive() {
        return this.equipmentOffensive;
    }

    public EquipementDefensif getEquipmentDefensif() {
        return this.equipmentDefensif;
    }

    /* ! CONSTRUCTORS: */
    public Personnage() {
        this("Player");
    }

    public Personnage(String name) {
        this(name, "warrior");
    }

    public Personnage(String name, String type) {
        setName(name);
        setType(type);
    }

    public String showPlayerStats() {
        return "\n" +
                "============================\n" +
                "  " + ANSI_GREEN + this.getName() + ANSI_RESET + "  \n" +
                "============================\n" +
                "| HP: " + this.getLife() + "\n" +
                "| Attack level: " + this.getAttackStrength() + "\n" +
                "| Damage: " +
                (this.getEquipmentOffensive() != null ?
                        this.getEquipmentOffensive().getWeaponName() + "(+" + this.getEquipmentOffensive().getAttackLevel() + ")" :
                        "[No weapon equipped]") + "\n" +
                "| Defense: " +
                (this.getEquipmentDefensif() != null ?
                        this.getEquipmentDefensif().getDefenseWeaponName() + "(+" + this.getEquipmentDefensif().getDefenseLevel() + ")" :
                        "[No defense]") + "\n" +
                "============================\n";
    }

    public int countAttackPower() {
        return attackStrength + equipmentOffensive.getAttackLevel();
    }

    public void doAttack(Personnage opponent) {
        int damage = countAttackPower();
        int opponentLife = opponent.getLife();
        opponent.setLife(Math.max(0, opponentLife - damage));
    }

    public boolean death(String opponentName) {
        if (this.life <= 0) {
            System.out.println("[ " + name + " died at the hands of " + opponentName + ".]");
            return true;
        }
        return false;
    }
}
