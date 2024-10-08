package Board;

import Equipement.EquipementOffensif;
import Equipement.Spell;
import Equipement.Weapon;
import Personnages.Personnage;

import java.util.Objects;
import java.util.Scanner;

public class BonusCase implements Case {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    protected String value;
    protected EquipementOffensif spell;
    protected EquipementOffensif weapon;


    public BonusCase() {
        this.value = "Bonus Case";
        this.spell = new Spell("Lightning", 5);
        this.weapon = new Weapon("Iron sword", 8);
    }

    public BonusCase(String value) {
    this.value = value;
    }

    @Override
    public void doAction(Personnage personnage) {
        System.out.println("[You walk towards a house, making your way through the ruins and ashes around you.]");
        System.out.println("[You see a chest, barely touched by a fire. Do you want to open it?]");

        System.out.println("   :%@@%%@@@@@@@@@@@@@@@%%#%@%:   ");
        System.out.println("  .#.-=@++++++++++++++++++@=:.#.  ");
        System.out.println("  .#-+                      *-#.  ");
        System.out.println("  .%.-======================-:%.  ");
        System.out.println("  .#         % ^^^^.#         #.  ");
        System.out.println("  .#-#+++++++% +#%=.%*++++++#-#.  ");
        System.out.println("  .#-+       %______#       *-#.  ");
        System.out.println("  .#-+        ......        *-#.  ");
        System.out.println("  .#:%%:::.....____...:::..@#:#.  ");
        System.out.println("  .@=========================+%.  ");
        System.out.println("                                   ");
        applyChoice(showChoices(), personnage);
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public Integer showChoices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[What do you want to do?]");
        System.out.println("1 < Open the chest.");
        System.out.println("2 < Leave it.");
        return sc.nextInt();
    }

    public void applyChoice(int choice, Personnage personnage) {
        if (choice == 1) {
            System.out.println("[You approach the chest. With a squeeky noice, the chest opens.]");
            getNewEquipement(personnage);
        } else {
            System.out.println("[Nothing happens, the chest remains closed.]");
        }
    }

    public void getNewEquipement(Personnage personnage) {
        if (Objects.equals(personnage.getType(), "wizard")) {
            personnage.newEquipementOffensive(spell);
        } else {
            personnage.newEquipementOffensive(weapon);
        }
        System.out.println("   [ You obtained new weapon: " + ANSI_PURPLE + personnage.getEquipmentOffensive().getWeaponName() + ANSI_RESET + ". ]   ");
    }
}
