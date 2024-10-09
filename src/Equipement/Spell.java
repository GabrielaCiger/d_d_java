package Equipement;
import Board.Case;
import Personnages.Personnage;

import java.util.Scanner;

public class Spell extends EquipementOffensif implements Case {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public Spell() {
        this.name = "Simple spell";
        this.attackLevel = 3;
    }

    public Spell(String newName, int newAttackLevel) {
        this.name = newName;
        this.attackLevel = newAttackLevel;
    }

    @Override
    public String getValue() {
        return "Bonus case";
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

    public Integer showChoices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[What do you want to do?]");
        System.out.println("1 < Open the chest.");
        System.out.println("2 < Leave it.");
        return sc.nextInt();
    }

    public void applyChoice(int choice, Personnage personnage) {
        Scanner sc = new Scanner(System.in);
        if (choice == 1) {
            System.out.println("[You approach the chest. With a squeeky noice, the chest opens.]");
            System.out.print(
                    " =##-......................................++@  \n" +
                            " =+ *@#+++++++++++++++++++++++++++++++++*%@. @  \n" +
                            " =+ +=@---------------------------------#-%. @  \n" +
                            " =+ +=@                                 *-+  @  \n" +
                            " =+ +=@   " + this.name +              "\n" +
                            " =+ +=@   " + this.attackLevel +      "\n" +
                            " =+ +=@                                 *-%. @  \n" +
                            " =+ +=@                                 *-%. @  \n" +
                            " =+ +=@=================================%-%. @  \n" +
                            " =+ *@%##################################@@: @  \n" +
                            " =#*:                                     .+*@   \n"
            );
            System.out.println("[What do you want to do?]");
            System.out.println("1 < Take the spell.");
            System.out.println("2 < Leave it.");
            int open = sc.nextInt();
            if (open == 1 ) {
                System.out.println(ANSI_RED + "[You took the spell (see your stats).]" + ANSI_RESET);
                getNewEquipement(personnage);
            } else {
                System.out.println("[You left the spell in the chest.]");
            }
        }
        else {
            System.out.println("[You left the chest untouched.]");
        }
    }


    public void getNewEquipement(Personnage personnage) {
        if (personnage.getType().contains("wizard")) {
            Spell newSpell = new Spell(this.name, this.attackLevel);
            personnage.newEquipementOffensive(newSpell);
        } else {
            System.out.println(ANSI_RED + "[You can't cast magical spells.]" + ANSI_RESET);
        }
    }
}
