package personnages.enemies;
import board.Case;
import board.CaseInteractionEnding;
import equipement.defensif.Shield;
import equipement.offensif.Spell;
import equipement.offensif.Weapon;
import menu.EnemyMenu;
import menu.Menu;
import personnages.Personnage;
import personnages.heroes.Warrior;

import java.awt.*;

/**
 * The NYMPH is a non-fightable enemy that influences the player's stats based on a randomly determined "mood," which can have either positive or negative effects.
 */
public class Nymph extends Enemy implements Case {

    public Nymph() {
        super("nymph", "enemy");
    }

    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public CaseInteractionEnding doAction(Personnage personnage) {
        EnemyMenu.nymph(this);
        EnemyMenu.encounterMessage(this);
        return applyEncounterChoice(EnemyMenu.showChoicesNymph(this), personnage);
    }
    /**
     * Applies the encounter choice made by the player when interacting with a nymph.
     *
     * @param choice     The player's choice during the encounter (1 to engage,
     *                   other values to leave).
     * @param personnage The player character whose attributes may be modified.
     *
     * <p>If the choice is 1:</p>
     * <ul>
     *     <li>If the nymph is in a good mood, the player's maximum life is increased
     *     by 3, and current life is set to this new maximum.</li>
     *     <li>If in a bad mood, the player receives basic offensive and defensive
     *     equipment.</li>
     * </ul>
     * <p>Choosing any other value results in a message indicating the player leaves
     * the encounter.</p>
     */
    public CaseInteractionEnding applyEncounterChoice(int choice, Personnage personnage) {
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
            return CaseInteractionEnding.FLEE;
        }
        return CaseInteractionEnding.NONE;
    }

    /**
     * Generates a random integer representing a choice between "bad" and "good".
     * @return Integer 1 or 2 (good or bad), randomly determined.
     * */
    public int badOrGood(){
        return (int)(Math.random() * 2);
    }

}
