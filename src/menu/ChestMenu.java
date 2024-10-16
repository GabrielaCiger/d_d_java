package menu;
import displayutils.StringUtils;
import java.util.Scanner;
import static displayutils.Colors.*;

/**
 * Class handling displaying messages, choices and images in the console related to the bonus chest and items.
 */
public class ChestMenu {
    public ChestMenu() {}

    /**
     * Displays an image of a chest along with a message indicating that the player has found a chest.
     * The contents of the chest remain unknown until revealed.
     */
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

    /**
     * Displays choices to open or to leave a chest.
     * @return Int : Choice (either 1 = open, or 2 = leave);
     */
    public static int showChoicesUnopened(){
        Scanner sc = new Scanner(System.in);
        System.out.println("[What do you want to do?]");
        System.out.println("1 < Open the chest.");
        System.out.println("2 < Leave it.");
        return sc.nextInt();
    }

    /**
     * Displays choices after opening the chest.
     * @return Int : Choice (either 1 = take, or 2 = leave);
     */
    private static int showChoicesOpened(String type){
        Scanner sc = new Scanner(System.in);
        System.out.println("[What do you want to do?]");
        System.out.println("1 < Take the "+type+".");
        System.out.println("2 < Leave it.");
        return sc.nextInt();
    }

    /**
     * Displays message, that the player chose to leave the item in the chest.
     * */
    private void leftItem(String type){
        System.out.println("[You left the "+type+" in the chest.]");
    }

    /**
     * Displays message, that the player chose to leave the chest without opening it.
     * */
    private void leftChest(){
        System.out.println("[You left the chest unopened.]");
    }

    /**
     * Displays message, that the player successfully equipped an item from the bonus chest.
     * @param type A type of the item (damage, defense, heal...);
     * */
    public static void getNewEquipmentSuccess(String type){
        type = StringUtils.capitalizeFirstLetter(type);
        System.out.println(ANSI_GREEN + "[ "+ type+" successfully equipped (see your stats).]" + ANSI_RESET);
    }

    /**
     * Displays message, that player was successfully healed.
     * @param name Name of the healing item.
     * @param healValue Value of the heal given to the player.
     * @see equipement.HealingItem;
     * */
    public void getHealedSuccess(String name, int healValue){
        System.out.println(ANSI_GREEN + "[You used "+ name +". Your HP increased : + "+ healValue +".]" + ANSI_RESET);
    }

    /**
     * Applies the player's choice when interacting with an opened chest.
     * @param choice The player's choice indicating whether to take an item from the chest (1 for taking, otherwise for leaving).
     * @param name The name of the item found in the chest.
     * @param type The type of the item (e.g., weapon, armor).
     * @param power The power level of the item found in the chest.
     * @return Returns 1 if the item was successfully taken from the chest, or 2 if the item was not taken or the chest was left.
     * @see #showChoicesOpened(String) 
     */
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

    /**
     * Displays a message and the contents of an opened chest.
     * The output includes the name, type, and power of the item found inside the chest,
     * along with an ASCII art representation of the chest.
     *
     * @param name The name of the item contained in the chest.
     * @param type The type of the item (e.g., weapon, potion).
     * @param power The power level of the item.
     */
    private void openedChest(String name, String type, int power) {
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

    /**
     * Displays an ASCII art representation of a key and a message indicating
     * that the player has obtained it.
     */
    public void foundKey(){
        String key =
                "     8 8 8 8                     ,ooo.\n" +
                "     8a8 8a8                    oP   ?b\n" +
                "    d888a888zzzzzzzzzzzzzzzzzzzz8     8b\n" +
                "     `\"\"^\"\"'                    ?o___oP'";
        System.out.println(ANSI_MAGENTA + key + ANSI_RESET + "\n");
        System.out.println("You obtained a " + ANSI_MAGENTA + "crystal key" + ANSI_RESET + ". You're not sure, if you'll ever need it.");
    }

}
