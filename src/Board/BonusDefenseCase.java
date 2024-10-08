package Board;
import Equipement.EquipementDefensif;
import Equipement.Potion;
import Equipement.Shield;
import Personnages.Personnage;

import java.util.Objects;

public class BonusDefenseCase extends BonusCase {
    protected EquipementDefensif potion;
    protected EquipementDefensif shield;

    public BonusDefenseCase() {
        super("Bonus case");
        this.potion = new Potion("Potion of invisibility", 8);
        this.shield = new Shield("Iron shield", 6);
    }

    @Override
    public void getNewEquipement(Personnage personnage) {
        if (Objects.equals(personnage.getType(), "wizard")) {
            personnage.newEquipementDefensif(potion);
        } else {
            personnage.newEquipementDefensif(shield);
        }
        System.out.println("   [ You obtained new defence object: " + ANSI_PURPLE + personnage.getEquipmentDefensif().getDefenseWeaponName() + ANSI_RESET + ". ]   ");
    }
}
