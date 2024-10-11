package equipement;
import board.Case;
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

    @Override
    public void doAction(Personnage personnage) {
        ChestMenu.encounterMessage();
        int getHealed = chestMenu.applyChoice(ChestMenu.showChoicesUnopened(), this.name, this.type, this.healingValue);
        if (getHealed == 1) {
            healing(personnage);
            chestMenu.getHealedSuccess(this.name, personnage);
        }
    }

    public void healing(Personnage personnage) {
        int playerLife = personnage.getLife();
        personnage.setLife(Math.min(playerLife + healingValue, personnage.getMaxLife()));
    }
}
