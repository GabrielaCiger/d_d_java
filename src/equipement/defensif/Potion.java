package equipement.defensif;
import board.Case;
import equipement.EquipementDefensif;
import menu.ChestMenu;
import personnages.Personnage;
import personnages.heroes.Wizard;

import static displayutils.Colors.*;

public class Potion extends EquipementDefensif implements Case {

    public Potion() {
        this.name = "Potion";
        this.defenseLevel = 2;
    }
    public Potion(String newName, int newDefenseLevel) {
        super(newName, newDefenseLevel);
        this.type = "defense";
    }
    public void getNewEquipement(Personnage personnage) {
        if (personnage instanceof Wizard) {
            if (betterDefenseLogic(personnage)){
                Potion newPotion = new Potion(this.name, this.defenseLevel);
                personnage.newEquipementDefensif(newPotion);
                ChestMenu.getNewEquipmentSuccess(newPotion.getDefenseWeaponName());
            } else {
                System.out.println(ANSI_RED + "[Your current defense is stronger.]" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "[You don't know how to use potions.]" + ANSI_RESET);
        }
    }

}
