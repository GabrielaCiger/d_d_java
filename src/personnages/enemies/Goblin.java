package personnages.enemies;
import board.Case;
import equipement.defensif.Shield;
import equipement.offensif.Weapon;
import menu.EnemyMenu;
import menu.Menu;
import personnages.Personnage;


public class Goblin extends Enemy implements Case {

    public Goblin(Menu menu) {
        super("goblin", "enemy", new Weapon("Wooden sword", 1), new Shield("Leather armor", 0), 12, 3);
        this.menu = menu;
    }

    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public void doAction(Personnage personnage) {
        EnemyMenu.goblin(this);
        EnemyMenu.encounterMessage(this);
        applyEncounterChoice(EnemyMenu.showChoices(this), personnage);
    }


}
