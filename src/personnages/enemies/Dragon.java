package personnages.enemies;
import board.Case;
import board.CaseInteractionEnding;
import equipement.defensif.Shield;
import menu.EnemyMenu;
import equipement.offensif.Spell;
import personnages.Personnage;

public class Dragon extends Enemy implements Case {

    public Dragon() {
        super("dragon", "enemy", new Spell("Fire", 5), new Shield("Dragon skin", 4), 18, 8);
    }
    @Override
    public String getValue() {
        return "Enemy case";
    }

    /**
     * Executes an action for the given character during an encounter with an enemy.
     * Displays the enemy menu and encounter message, and applies the player's choice.
     * @param personnage the character performing the action during the encounter.
     */
    @Override
    public CaseInteractionEnding doAction(Personnage personnage) {
        EnemyMenu.dragon(this);
        EnemyMenu.encounterMessage(this);
        return applyEncounterChoice(EnemyMenu.showChoices(this), personnage);
    }

}
