package personnages;
import static displayutils.Colors.*;
import equipement.EquipementOffensif;
import equipement.EquipementDefensif;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public abstract class Personnage {
    protected int id;
    protected boolean foundKey = false;
    protected int wonGame = 0;
    protected int maxLife;
    protected String name;
    protected String type;
    protected int life;
    protected int attackStrength;
    protected EquipementOffensif equipmentOffensive;
    protected EquipementDefensif equipmentDefensif;


    /* ! CONSTRUCTORS: */
    public Personnage() {}

    public Personnage(String name, String type, int life, int maxLife, int attackStrength) {
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
        this.name = name;
        this.type = type;
        this.maxLife = maxLife;
        setLife(maxLife);
    }

    public Personnage(String name, String type, int life, int maxLife, int attackStrength, String weaponName, int weaponAttack, String shieldName, int shieldDefense) {
        setName(name);
        setType(type);
        this.life = life;
        this.maxLife = maxLife;
        this.attackStrength = attackStrength;
    }

    /* * SETTERS */
    public void setName(String name) {
        if (name.isEmpty()) {
            this.name = "Henry Cavill [default]";
        } else {
            this.name = name;
        }
    }

    public void setWonGame(int wonGame) {
        this.wonGame = wonGame;
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

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public void setFoundKey(boolean foundKey) {
        this.foundKey = foundKey;
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

    public int getMaxLife() { return maxLife; }

    public boolean isFoundKey() {return foundKey;}

    public int getId() { return id; }

    public int getHashId() { return this.id; }

    public int getWonGame() { return wonGame; }

    /* ? METHODS */
    /**
     * Constructs and returns a string representation of the player's stats.
     * @return a formatted string containing the player's name, HP, attack level,
     *         damage (with equipped weapon information), and defense (with equipped defense information).
     */
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

    /**
     * Calculates the total attack power of the player.
     * @return the sum of the player's base attack strength and the attack level of the equipped offensive weapon.
     */
    public int countAttackPower() {
        return this.attackStrength + this.equipmentOffensive.getAttackLevel();
    }

    /**
     * Performs an attack on the specified opponent, calculating damage based on the attacker's
     * attack power and the opponent's defense.
     * @param opponent the target character to be attacked.
     */
    public void doAttack(Personnage opponent) {
        int damage = countAttackPower();
        int opponentLife = opponent.getLife() + opponent.getEquipmentDefensif().getDefenseLevel();
        opponent.setLife(Math.max(0, opponentLife - damage));
    }

    public int creationTimeHashed() {
        Instant instant = Instant.now();
        LocalDateTime now = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return now.hashCode();
    }


}
