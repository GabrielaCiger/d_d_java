package personnages.enemies;
import board.Case;
import equipement.defensif.Shield;
import equipement.offensif.Spell;
import equipement.offensif.Weapon;
import menu.EnemyMenu;
import menu.Menu;
import personnages.Personnage;
import personnages.heroes.Warrior;

import java.awt.*;

public class Nymph extends Enemy implements Case {

    public Nymph(Menu menu) {
        super("nymph", "enemy");
    }

    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public void doAction(Personnage personnage) {
        EnemyMenu.nymph(this);
        EnemyMenu.encounterMessage(this);
        applyEncounterChoice(EnemyMenu.showChoicesNymph(this), personnage);
    }

    public void applyEncounterChoice(int choice, Personnage personnage) {
        int nymphMood = badOrGood();
        if (choice == 1) {
            if (nymphMood==1) {
                int beforeBuff = personnage.getMaxLife();
                personnage.setMaxLife(beforeBuff+3);
                personnage.setLife(personnage.getMaxLife());
            } else {
                personnage.newEquipementOffensive(new Weapon("Fist", 0));
                personnage.newEquipementDefensif(new Shield("Underwear", 0));
            }
            EnemyMenu.nymphMessage(nymphMood, personnage);
        } else {
            enemyMenu.leaveEnemyMessage(this);
        }
    }

    public int badOrGood(){
        return (int)(Math.random() * 2);
    }

}
