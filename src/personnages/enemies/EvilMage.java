package personnages.enemies;
import board.Case;
import equipement.defensif.Potion;
import equipement.offensif.Spell;
import menu.EnemyMenu;
import menu.Menu;
import personnages.Personnage;

public class EvilMage extends Enemy implements Case {

    public EvilMage(Menu menu) {
        super("mage", "enemy", new Spell("Cursed amulet", 3), new Potion("Satin cloak", 2), 14, 5);
        this.menu = menu;
    }
    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public void doAction(Personnage personnage) {
        EnemyMenu.mage(this);
        EnemyMenu.encounterMessage(this);
        applyEncounterChoice(EnemyMenu.showChoices(this), personnage);
    }
}
