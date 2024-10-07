package Board;
import Equipement.Spell;
import Personnages.Personnage;
import java.util.Objects;

public class BonusCase implements Case {
    protected String value;

    public BonusCase(Personnage personnage) {
        this.value = "Bonus Case";
    }

    @Override
    public void doAction() {
        System.out.println("I am bonus case.");
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public void getNewWeapon(Personnage personnage) {
        if (Objects.equals(personnage.getType(), "wizard")) {
            personnage.newEquipementOffensive(new Spell("Better spell", 10));
        } else {
            personnage.newEquipementOffensive(new Spell("Better weapon", 10));
        }
    }
}
