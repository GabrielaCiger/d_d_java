package equipement.defensif;
import equipement.EquipementDefensif;
import menu.ChestMenu;
import personnages.Personnage;
import personnages.heroes.Warrior;

import static displayutils.Colors.*;

public class Shield extends EquipementDefensif {

    public Shield() {
        this.name = "Shield";
        this.defenseLevel = 2;
    }
    public Shield(String newName, int newDefenseLevel) {
        super(newName, newDefenseLevel);
        this.type = "defense";
    }

    public void getNewEquipement(Personnage personnage) {
        if (personnage instanceof Warrior) {
            if (betterDefenseLogic(personnage)){
                Shield newShield = new Shield(this.name, this.defenseLevel);
                personnage.newEquipementDefensif(newShield);
                ChestMenu.getNewEquipmentSuccess(newShield.getDefenseWeaponName());

            } else {
                System.out.println(ANSI_RED + "[Your current defense is stronger.]" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED +"[You don't know how to hold shields.]" + ANSI_RESET);
        }
    }

}
