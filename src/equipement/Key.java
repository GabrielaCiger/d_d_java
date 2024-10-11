package equipement;

import board.Case;
import menu.ChestMenu;
import personnages.Personnage;

import java.security.PublicKey;

public class Key implements Case {
    protected ChestMenu chestMenu = new ChestMenu();
    protected String name;
    protected String type;
    protected int value;

    public Key(){
        name = "Crystal key";
        type = "key";
        value = 0;
    };

    @Override
    public String getValue() {
        return "Bonus case";
    }

    @Override
    public void doAction(Personnage personnage) {
        ChestMenu.encounterMessage();
        int openChest = chestMenu.applyChoice(ChestMenu.showChoicesUnopened(), this.name, this.type, this.value);
        if (openChest == 1) {
            personnage.setFoundKey(true);
            chestMenu.foundKey();
        }
    }
}
