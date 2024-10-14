package personnages.enemies;
import equipement.EquipementDefensif;
import equipement.EquipementOffensif;
import menu.EnemyMenu;
import personnages.Personnage;

public abstract class Enemy extends Personnage {
    protected EnemyMenu enemyMenu = new EnemyMenu();
    protected String image;
    protected String message; /* encounter message */
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

    public void setMessage(String message) {
        this.message = message;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAttackMessage(String attackMessage) {
        this.attackMessage = attackMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getImage() {
        return image;
    }

    public boolean isDead() {
        return isDead;
    }

    public void applyEncounterChoice(int choice, Personnage personnage) {
        if (choice == 1) {
            if (this.isDead) {
                EnemyMenu.isDeadMessage(this);
                return;
            }
            fight(personnage);
        } else if (choice == 3 && this.name.equals("dragon")) {
            enemyMenu.blessedByDragon(personnage);
        } else {
            enemyMenu.leaveEnemyMessage(this);
        }
    }
    public void fight(Personnage personnage) {
        enemyMenu.playerAttackMessage(personnage, this);
        personnage.doAttack(this);
        if (this.life<1) {
            this.isDead = true;
            enemyMenu.deathMessage(this, personnage.getName());
            addStrengthLogic(personnage);
        } else {
            System.out.println(attackMessage);
            this.doAttack(personnage);
        }
    }
    public void addStrengthLogic(Personnage personnage) {
        switch (this.name){
            case "dragon": enemyMenu.addStrengthFromDragon(personnage); break;
            case "goblin" : enemyMenu.addStrengthWarrior(personnage, this); break;
            case "mage" : enemyMenu.addStrengthWizard(personnage, this); break;
        }
    }
}
