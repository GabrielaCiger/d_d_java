package equipement.defensif;
import board.Case;
import equipement.EquipementDefensif;
import personnages.Personnage;
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
        if (personnage.getType().contains("wizard")) {
            if (betterDefenseLogic(personnage)){
                Potion newPotion = new Potion(this.name, this.defenseLevel);
                personnage.newEquipementDefensif(newPotion);
            } else {
                System.out.println(ANSI_RED + "[Your current defense is stronger.]" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "[You don't know how to use potions.]" + ANSI_RESET);
        }
    }

}
