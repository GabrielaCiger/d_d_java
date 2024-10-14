package personnages;

import menu.Menu;

import static displayutils.Colors.*;

import equipement.EquipementOffensif;
import equipement.EquipementDefensif;

public abstract class Personnage {
    protected boolean foundKey = false;
    protected int maxLife;
    protected String name;
    protected String type;
    protected int life;
    protected int attackStrength;
    protected EquipementOffensif equipmentOffensive;
    protected EquipementDefensif equipmentDefensif;


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
    public Personnage(String name, String type, int maxLife) {
        setName(name);
        setType(type);
        this.maxLife = maxLife;
        setLife(maxLife);
    }

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


    /* ? METHODS */
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
        return this.attackStrength + this.equipmentOffensive.getAttackLevel();
    }

    public void doAttack(Personnage opponent) {
        int damage = countAttackPower();
        int opponentLife = opponent.getLife() + opponent.getEquipmentDefensif().getDefenseLevel();
        opponent.setLife(Math.max(0, opponentLife - damage));
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getMaxLife() { return maxLife; }
    public void setFoundKey(boolean foundKey) {
        this.foundKey = foundKey;
    }

    public boolean isFoundKey() {return foundKey;}
}
