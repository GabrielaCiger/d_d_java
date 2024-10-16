package personnages.enemies;
import equipement.EquipementDefensif;
import equipement.EquipementOffensif;
import menu.EnemyMenu;
import personnages.Personnage;

public abstract class Enemy extends Personnage {
    protected EnemyMenu enemyMenu = new EnemyMenu();
    protected String image;
    protected String message;
    protected String attackMessage;
    protected boolean isDead = false;

    public Enemy(String name, String type) {
        super(name, type);
    }

    public Enemy(String name, String type, EquipementOffensif equipmentOffensive, EquipementDefensif equipmentDefensif, int life, int attackStrength) {
        super(name, type);
        this.equipmentOffensive = equipmentOffensive;
        this.equipmentDefensif = equipmentDefensif;
        this.life = life;
        this.attackStrength = attackStrength;
    }

    /* * GETTERS & SETTERS */
    public void setMessage(String message) {
        this.message = message;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setAttackMessage(String attackMessage) { this.attackMessage = attackMessage; }
    public String getMessage() { return message;}
    public String getImage() {
        return image;
    }
    public boolean isDead() {
        return isDead;
    }

    /* ? METHODS */
    /**
     * Applies the player's choice during an encounter with an enemy.
     * Executes the corresponding action based on the choice:
     * 1 - Fight the enemy (if not dead).
     * 3 - Perform a special action if the enemy is a Dragon.
     * Any other choice results in leaving the encounter.
     *
     * @param choice the player's chosen action during the encounter.
     * @param personnage the character involved in the encounter.
     */
    public void applyEncounterChoice(int choice, Personnage personnage) {
        if (choice == 1) {
            if (this.isDead) {
                EnemyMenu.isDeadMessage(this);
                return;
            }
            fight(personnage);
        } else if (choice == 3 && this instanceof Dragon) {
            enemyMenu.blessedByDragon(personnage);
        } else {
            enemyMenu.leaveEnemyMessage(this);
        }
    }
    /**
     * Initiates a fight between the player character and the enemy.
     * Displays attack messages, processes the player's and enemy's attacks,
     * and checks if the enemy is dead after the attack.
     * If the enemy's life drops below 1, it sets the enemy as dead
     * and executes additional logic based on the player's actions.
     * @param personnage the player character involved in the fight.
     */
    public void fight(Personnage personnage) {
        enemyMenu.playerAttackMessage(personnage, this);
        personnage.doAttack(this);
        enemyMenu.defenseValueMessage(this);
        if (this.life<1) {
            this.isDead = true;
            enemyMenu.deathMessage(this, personnage.getName());
            addStrengthLogic(personnage);
        } else {
            System.out.println(attackMessage);
            this.doAttack(personnage);
            enemyMenu.defenseValueMessage(personnage);
        }
    }
    /**
     * Adds strength to the player character based on the defeated enemy's type.
     * This method determines the enemy's type using instanceof and calls the
     * appropriate method to apply strength bonuses to the player character
     * after a successful defeat.
     * @param personnage the player character to receive strength bonuses.
     */
    public void addStrengthLogic(Personnage personnage) {
        if (this instanceof Dragon) {
            enemyMenu.addStrengthFromDragon(personnage);
        } else if (this instanceof Goblin) {
            enemyMenu.addStrengthWarrior(personnage, this);
        } else if (this instanceof EvilMage) {
            enemyMenu.addStrengthWizard(personnage, this);
        }
    }
}
