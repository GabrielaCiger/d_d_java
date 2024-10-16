package equipement.offensif;
import equipement.EquipementOffensif;
import menu.ChestMenu;
import personnages.Personnage;
import personnages.heroes.Wizard;

import static displayutils.Colors.*;

public class Spell extends EquipementOffensif {

    public Spell() {
        this.name = "Simple spell";
        this.attackLevel = 3;
    }

    public Spell(String newName, int newAttackLevel) {
        super(newName, newAttackLevel);
        this.type = "attack";
    }

    public void getNewEquipement(Personnage personnage) {
        if (personnage instanceof Wizard) {
            if (betterAttackLogic(personnage)){
                Spell newSpell = new Spell(this.name, this.attackLevel);
                personnage.newEquipementOffensive(newSpell);
                ChestMenu.getNewEquipmentSuccess(newSpell.getWeaponName());
            } else {
                System.out.println(ANSI_RED + "[Your current attack is stronger.]" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "[You can't cast magical spells.]" + ANSI_RESET);
        }
    }

}
