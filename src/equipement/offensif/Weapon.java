package equipement.offensif;
import equipement.EquipementOffensif;
import menu.ChestMenu;
import personnages.Personnage;
import personnages.heroes.Warrior;

import static displayutils.Colors.*;

public class Weapon extends EquipementOffensif {


    public Weapon() {
        this.name = "Rusty sword";
        this.attackLevel = 3;
    }

    public Weapon(String newName, int newAttackLevel) {
        super(newName, newAttackLevel);
        this.type = "attack";
    }
    public void getNewEquipement(Personnage personnage) {
        if (personnage instanceof Warrior) {
            if (betterAttackLogic(personnage)){
                Weapon newWeapon = new Weapon(this.name, this.attackLevel);
                personnage.newEquipementOffensive(newWeapon);
                ChestMenu.getNewEquipmentSuccess(newWeapon.getWeaponName());
            } else {
                System.out.println(ANSI_RED + "[Your current attack is stronger.]" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED +"[You can't possess basic weapons.]" + ANSI_RESET);
        }
    }
}

