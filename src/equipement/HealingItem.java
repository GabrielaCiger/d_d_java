package equipement;
import board.Case;
import board.CaseInteractionEnding;
import menu.ChestMenu;
import personnages.Personnage;

public class HealingItem implements Case {
    protected ChestMenu chestMenu = new ChestMenu();
    protected String name;
    protected int healingValue;
    protected String type = "heal";

    public HealingItem(String name, int healingValue) {
        this.name = name;
        this.healingValue = healingValue;
    }

    public String getName() {
        return name;
    }

    public int getHealingValue() {
        return healingValue;
    }

    public String getType() {
        return type;
    }

    @Override
    public String getValue() {
        return "Bonus case";
    }

    /**
     * When the player encounters a healing object, the object's healing method is activated. If the player chooses to accept the heal, their health is restored.
     * @param personnage The character whose life values are being used to determine the healing amount.
     */
    @Override
    public CaseInteractionEnding doAction(Personnage personnage) {
        ChestMenu.encounterMessage();
        int getHealed = chestMenu.applyChoice(ChestMenu.showChoicesUnopened(), this.name, this.type, this.healingValue);
        if (getHealed == 1) {
            healing(personnage);
        }
        return CaseInteractionEnding.NONE;
    }

    /**
     * Gets max healing value depending on healingValue of the object, counting maxLife value of the player. Call's method to show to player, how much he has healed.
     * @param personnage The character whose life values are being used to determine the healing amount.
     */
    public void healing(Personnage personnage) {
        int playerLife = personnage.getLife();
        int healedPlayerLife = Math.min(playerLife + healingValue, personnage.getMaxLife());
        int healedValue = healedPlayerLife - personnage.getLife();
        personnage.setLife(healedPlayerLife);
        chestMenu.getHealedSuccess(this.name, healedValue);
    }
}
