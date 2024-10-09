package Equipement;
import Board.Case;
import Personnages.Personnage;

import java.util.Scanner;

public class Shield extends EquipementDefensif implements Case {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public Shield() {
        this.name = "Shield";
        this.defenseLevel = 2;
    }
    public Shield(String newName, int newDefenseLevel) {
        super(newName, newDefenseLevel);
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
                            " =+ +=@   " + this.defenseLevel +      "\n" +
                            " =+ +=@                                 *-%. @  \n" +
                            " =+ +=@                                 *-%. @  \n" +
                            " =+ +=@=================================%-%. @  \n" +
                            " =+ *@%##################################@@: @  \n" +
                            " =#*:                                     .+*@   \n"
            );
            System.out.println("[What do you want to do?]");
            System.out.println("1 < Take the shield.");
            System.out.println("2 < Leave it.");
            int open = sc.nextInt();
            if (open == 1 ) {
                System.out.println(ANSI_RED + "[You took the shield (see your stats).]" + ANSI_RESET);
                getNewEquipement(personnage);
            } else {
                System.out.println("[You left the shield in the chest.]");
            }
        }
        else {
            System.out.println("[You left the chest untouched.]");
        }
    }


    public void getNewEquipement(Personnage personnage) {
        if (personnage.getType().contains("warrior")) {
            Shield newShield = new Shield(this.name, this.defenseLevel);
            personnage.newEquipementDefensif(newShield);
        } else {
            System.out.println(ANSI_RED +"[You don't know how to hold shields.]" + ANSI_RESET);
        }
    }

}
