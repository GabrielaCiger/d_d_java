package personnages.enemies;
import board.Case;
import menu.EnemyMenu;
import menu.Menu;
import equipement.defensif.Potion;
import equipement.offensif.Spell;
import personnages.Personnage;

public class Dragon extends Enemy implements Case {

    public Dragon(Menu menu) {
        super("dragon", "enemy", new Spell("Fire", 5), new Potion("Dragon skin", 4), 18, 8);
        this.menu = menu;
    }
    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public void doAction(Personnage personnage) {
        EnemyMenu.dragon(this);
        EnemyMenu.encounterMessage(this);
        applyEncounterChoice(EnemyMenu.showChoices(this), personnage);
    }

}
