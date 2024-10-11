package menu;
import displayutils.StringUtils;
import equipement.defensif.Shield;
import equipement.offensif.Spell;
import personnages.Personnage;
import personnages.enemies.*;
import java.util.Objects;
import java.util.Scanner;
import static displayutils.Colors.*;

public class EnemyMenu {

    public EnemyMenu() {}

    public static void encounterMessage(Enemy caseEnemy) {
        System.out.println(caseEnemy.getImage());
        System.out.println("[You encountered a "+ caseEnemy.getName() +"!]");
        System.out.println("["+caseEnemy.getMessage()+"]");
    }
    public static void isDeadMessage(Enemy enemy){
        System.out.println("["+ StringUtils.capitalizeFirstLetter(enemy.getName())+"'s body turned to ashes after its death.]");
    }

    public void playerAttackMessage(Personnage personnage, Personnage opponent){
        System.out.println(ANSI_GREEN + "[You've attacked "+opponent.getName()+" ("+ personnage.countAttackPower() +" damage)]" + ANSI_RESET);
    }
    public void leaveEnemyMessage(Personnage enemy) {
        System.out.println("[You turned away from the "+enemy.getName()+".]");
    }
    public void blessedByDragon(Personnage personnage) {
        System.out.println("[The dragon's fierce gaze softens as you kneel before her, recognizing your submission with a low, rumbling purr of approval.]");
        System.out.println("[As the mother of young hatchlings, she bestows upon you a rare blessing, imbuing you with the ancient Dragon Force in gratitude for sparing her life.]");
        personnage.setAttackStrength(personnage.getAttackStrength() + 7);
        System.out.println(ANSI_GREEN + "[Your attack power has increased! (See your stats.)]" + ANSI_RESET);
    }
    public void addStrengthFromDragon(Personnage personnage) {
        System.out.println(ANSI_GREEN + "[You have slayed the flying lizard!]" + ANSI_RESET);
        if (Objects.equals(personnage.getType(), "wizard")) {
            personnage.newEquipementOffensive(new Spell("Fireball", 8));
            System.out.println(ANSI_GREEN + "[As a wizard, you obtained legendary spell: "+ ANSI_MAGENTA + personnage.getEquipmentOffensive().getWeaponName() + ANSI_GREEN +" (see your stats).]" + ANSI_RESET);
        } else {
            personnage.newEquipementDefensif(new Shield("Dragonhide armor", 7));
            System.out.println(ANSI_GREEN + "[As a warrior, you obtained legendary defense: "+ ANSI_MAGENTA + personnage.getEquipmentDefensif().getDefenseWeaponName() + ANSI_GREEN +" (see your stats).]" + ANSI_RESET);
        }
    }
    public void addStrengthWarrior(Personnage personnage, Personnage enemy){
        if (Objects.equals(personnage.getType(), "warrior")) {
            System.out.println(ANSI_GREEN + "[You have slain the "+enemy.getName()+"! As a warrior, your strength rises by 1.]" + ANSI_RESET);
            personnage.setAttackStrength(personnage.getAttackStrength()+2);
        }
    }
    public void addStrengthWizard(Personnage personnage, Personnage enemy){
        if (Objects.equals(personnage.getType(), "wizard")) {
            System.out.println(ANSI_GREEN + "[You have killed the "+enemy.getName()+"! As a wizard, your strength rises by 1.]" + ANSI_RESET);
            personnage.setAttackStrength(personnage.getAttackStrength()+2);
        }
    }

    public static void emptyCase(Personnage personnage){
        System.out.print("    .                  .-.    .  _   *     _   .\n" +
                "           *          /   \\     ((       _/ \\       *    .\n" +
                "         _    .   .--'\\/\\_ \\     `      /    \\  *    ___\n" +
                "     *  / \\_    _/ ^      \\/\\'__        /\\/\\  /\\  __/   \\ *\n" +
                "       /    \\  /    .'   _/  /  \\  *' /    \\/  \\/ .`'\\_/\\   .\n" +
                "  .   /\\/\\  /\\/ :' __  ^/  ^/    `--./.'  ^  `-\\. _    _:\\ _\n" +
                "     /    \\/  \\  _/  \\-' __/.' ^ _   \\_   .'\\   _/ \\ .  __/ \\\n" +
                "   /\\  .-   `. \\/     \\ / -.   _/ \\ -. `_/   \\ /    `._/  ^  \\\n" +
                "  /  `-.__ ^   / .-'.--'    . /    `--./ .-'  `-.  `-. `.  -  `.\n" +
                "@/        `.  / /      `-.   /  .-'   / .   .'   \\    \\  \\  .-  \\%\n\n");
        System.out.println("[You walk through calm plains. You see the snowy mountains and a moon, lighting up the way upfront.] \n" +
                "[What's going to be your next step, " + personnage.getName() + "?]");
    }
    public static void dragon(Dragon dragon) {
        String image = ANSI_GREEN +
                "                 ___====-_  _-====___\n" +
                "           _--^^^#####//      \\\\#####^^^--_\n" +
                "        _-^##########// (    ) \\\\##########^-_\n" +
                "       -############//  |\\^^/|  \\\\############-\n" +
                "     _/############//   (@::@)   \\\\############\\_\n" +
                "    /#############((     \\\\//     ))#############\\\n" +
                "   -###############\\\\    (oo)    //###############-\n" +
                "  -#################\\\\  / VV \\  //#################-\n" +
                " -###################\\\\/      \\//###################-\n" +
                "_#/|##########/\\######(   /\\   )######/\\##########|\\#_\n" +
                "|/ |#/\\#/\\#/\\/  \\#/\\##\\  |  |  /##/\\#/  \\/\\#/\\#/\\#| \\|\n" +
                "`  |/  V  V  `   V  \\#\\| |  | |/#/  V   '  V  V  \\|  '\n" +
                "   `   `  `      `   / | |  | | \\   '      '  '   ',--. \n" +
                "                    (  | |  | |  )                /    \\ \n" +
                "                   __\\ | |  | | /__               |    | \n" +
                "                  (vvv(VVV)(VVV)vvv)              \\\\__/\n" + ANSI_RESET;
        dragon.setImage(image);
        dragon.setMessage("He sits quietly on a rugged stone, watching with sharp eyes. He doesn't attack, but there's an uneasy feeling, as if he's neither friend nor foe.");
        dragon.setAttackMessage("[The dragon roars, unleashing a blazing fireball in your direction! (-" + dragon.countAttackPower() + " HP) ]");
    }
    public static void goblin(Goblin goblin) {
        String image = ANSI_GREEN +
                "                #@@@@@@@@@@@@=             \n" +
                "         =##=  @@%           :@@:  =##=     \n" +
                "        @@--#@@@-       @ .@=  @@@@#--@@    \n" +
                "        *@=   @@               -@*   +@+    \n" +
                "         @@   @@          ==   -@+ .@@*     \n" +
                "         +@+  @@  \\         /  =@+ *@+      \n" +
                "          @@  @@  *@@@: .@@@  =@+ @@        \n" +
                "          :@@-@@     -@+       +@#-@@       \n" +
                "            +@@@     -@+       @@@@+        \n" +
                "               @@    -@**@    +@*           \n" +
                "                @@.   #@@-   @@#            \n" +
                "                 +@@       #@@              \n" +
                "                   @@@:  +@@:               \n" +
                "                     +@@@#:                 \n" + ANSI_RESET;
        goblin.setImage(image);
        goblin.setMessage("He's even more hideous than the folks in the tavern described him to be.");
        goblin.setAttackMessage("[Goblin cuts you with his sword. (-" + goblin.countAttackPower() + " HP) ]");
    }
    public static void mage(EvilMage mage) {
        String image = ANSI_CYAN + "                 =++++-              \n" +
                "              :%        @           \n" +
                "             .#      =@  *-         \n" +
                "             %        @ @#+         \n" +
                "            -=        :#            \n" +
                "            @          %            \n" +
                "          *@@%%%@**#@%%@@%          \n" +
                "        :+@::  @=::-@-:::*#:.       \n" +
                "      @    %            @    #:     \n" +
                "      @ **=.             =+@ %.     \n" +
                "        *##:#:         % @*%        \n" +
                "          @ =%***%@***%# @           \n" +
                "          %  +#=*#=%=*%  @           \n" +
                "           %             #           \n" +
                "           =+                        \n" +
                "            :#        -#            \n" +
                "       -%%+.  %      *-  =#@+.      \n" +
                "    -#         @    @.        -*    \n" +
                "    @           @: @           *    \n" + ANSI_RESET;
        mage.setImage(image);
        mage.setMessage("He gazes at you with an unsettling intensity, his eyes gleaming like cold steel in the dim light.");
        mage.setAttackMessage(ANSI_RED + "[Mage cast a spell. (-" + mage.countAttackPower() + " HP) ]" + ANSI_RESET);
    }
    public static int showChoices(Enemy enemy) {
        Scanner sc = new Scanner(System.in);
        System.out.println("`\n[What do you want to do?]\n");
        if (!enemy.isDead()) {
            System.out.println("1 < Attack the "+enemy.getName()+".");
        } else {
            System.out.println("1 < Approach the "+enemy.getName()+"'s corpse. ");
        }
        System.out.println("2 < Turn away.");
        if (Objects.equals(enemy.getName(), "dragon")){
            System.out.println("3 < Kneel before the beast.");
        }
        return sc.nextInt();
    }

    public void deathMessage(Personnage died, String killer) {
        System.out.println(ANSI_GREEN + "[ " + StringUtils.capitalizeFirstLetter(died.getName()) + " died at the hands of " + killer + ".]" + ANSI_RESET);
    }

}
