package personnages.enemies;
import board.Case;
import equipement.defensif.Shield;
import menu.EnemyMenu;
import equipement.offensif.Spell;
import personnages.Personnage;

public class Dragon extends Enemy implements Case {

    public Dragon() {
        super("dragon", "enemy", new Spell("Fire", 5), new Shield("Dragon skin", 4), 18, 8);
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
