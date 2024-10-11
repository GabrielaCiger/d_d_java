package menu;
import personnages.Personnage;

import java.util.Scanner;

import static displayutils.Colors.*;

public class ChestMenu {
    public ChestMenu() {}
    public static void encounterMessage(){
        System.out.println("[You walk towards a house, making your way through the ruins and ashes around you.]");
        System.out.println("[You see a chest, barely touched by a fire. Do you want to open it?]");
        System.out.println("\n   :%@@%%@@@@@@@@@@@@@@@%%#%@%:   ");
        System.out.println("  .#.-=@++++++++++++++++++@=:.#.  ");
        System.out.println("  .#-+                      *-#.  ");
        System.out.println("  .%.-======================-:%.  ");
        System.out.println("  .#         % ^^^^.#         #.  ");
        System.out.println("  .#-#+++++++% +#%=.%*++++++#-#.  ");
        System.out.println("  .#-+       %______#       *-#.  ");
        System.out.println("  .#-+        ......        *-#.  ");
        System.out.println("  .#:%%:::.....____...:::..@#:#.  ");
        System.out.println("  .@=========================+%.  \n");

    }

    public static int showChoicesUnopened(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[What do you want to do?]");
        System.out.println("1 < Open the chest.");
        System.out.println("2 < Leave it.");
        return sc.nextInt();
    }

    public static int showChoicesOpened(String type){
        Scanner sc = new Scanner(System.in);
        System.out.println("[What do you want to do?]");
        System.out.println("1 < Take the "+type+".");
        System.out.println("2 < Leave it.");
        return sc.nextInt();
    }

    public void leftItem(String type){
        System.out.println("[You left the "+type+" in the chest.]");
    }

    public void leftChest(){
        System.out.println("[You left the chest unopened.]");
    }

    public int applyChoice(int choice, String name, String type, int power) {
        if (choice == 1) {
            openedChest(name, type, power);
            int take = showChoicesOpened(type);
            if (take == 1) {
                return 1;
            }
            leftItem(type);
            return 2;
        }
        leftChest();
        return 2;
    }

    public void openedChest(String name, String type, int power) {
        System.out.println("[You approach the chest. With a squeeky noice, the chest opens.]");
        System.out.print(
                " =##-......................................++@  \n" +
                        " =+ *@#+++++++++++++++++++++++++++++++++*%@. @  \n" +
                        " =+ +=@---------------------------------#-%. @  \n" +
                        " =+ +=@                                 *-+  @  \n" +
                        " =+ +=@   " +ANSI_MAGENTA + name + ANSI_RESET + " (Type: " + type + ")             \n" +
                        " =+ +=@   Power: " + ANSI_MAGENTA + power + ANSI_RESET +      "\n" +
                        " =+ +=@                                 *-%. @  \n" +
                        " =+ +=@                                 *-%. @  \n" +
                        " =+ +=@=================================%-%. @  \n" +
                        " =+ *@%##################################@@: @  \n" +
                        " =#*:                                     .+*@   \n"
        );
    }
}
