package personnages.enemies;
import board.Case;
import board.CaseInteractionEnding;
import equipement.defensif.Shield;
import equipement.offensif.Weapon;
import menu.EnemyMenu;
import personnages.Personnage;


public class Goblin extends Enemy implements Case {

    public Goblin() {
        super("goblin", "enemy", new Weapon("Wooden sword", 1), new Shield("Leather armor", 0), 12, 3);
    }
    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public CaseInteractionEnding doAction(Personnage personnage) {
        EnemyMenu.goblin(this);
        EnemyMenu.encounterMessage(this);
        return applyEncounterChoice(EnemyMenu.showChoices(this), personnage);
    }

}
