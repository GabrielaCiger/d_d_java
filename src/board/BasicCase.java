package board;

import menu.EnemyMenu;
import menu.Menu;
import personnages.Personnage;

public class BasicCase implements Case {
protected String value;
protected Menu menu;

    public BasicCase(Menu menu) {
        this.value = "Basic Case";
        this.menu = menu;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void doAction(Personnage personnage) {
        EnemyMenu.emptyCase(personnage);
    }

}
