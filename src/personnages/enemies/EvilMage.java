package personnages.enemies;
import board.Case;
import board.CaseInteractionEnding;
import equipement.defensif.Potion;
import equipement.offensif.Spell;
import menu.EnemyMenu;
import personnages.Personnage;

public class EvilMage extends Enemy implements Case {

    public EvilMage() {
        super("mage", "enemy", new Spell("Cursed amulet", 3), new Potion("Satin cloak", 2), 14, 5);
    }
    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public CaseInteractionEnding doAction(Personnage personnage) {
        EnemyMenu.mage(this);
        EnemyMenu.encounterMessage(this);
        return applyEncounterChoice(EnemyMenu.showChoices(this), personnage);
    }

}
