package menu;
import displayutils.StringUtils;
import equipement.defensif.Shield;
import equipement.offensif.Spell;
import personnages.Personnage;
import personnages.enemies.*;
import personnages.heroes.Warrior;
import personnages.heroes.Wizard;

import java.util.Objects;
import java.util.Scanner;

import static displayutils.Colors.*;

public class EnemyMenu extends Story {

    public EnemyMenu() {
    }

    /**
     * Displays a message when the player encounters an enemy.
     * The output includes the enemy's image, name, and a specific message associated with the enemy.
     * @param caseEnemy The enemy being encountered, which contains details such as the image, name, and message.
     */
    public static void encounterMessage(Enemy caseEnemy) {
        System.out.println(caseEnemy.getImage());
        System.out.println("[You encountered a " + caseEnemy.getName() + "!]");
        System.out.println("[" + caseEnemy.getMessage() + "]");
    }

    /**
     * Displays a message indicating that an enemy has died.
     * The output includes the enemy's name capitalized, followed by a message.
     * @param enemy The enemy that has died, used to retrieve the name for the message.
     */
    public static void isDeadMessage(Enemy enemy) {
        System.out.println("[" + StringUtils.capitalizeFirstLetter(enemy.getName()) + "'s body turned to ashes after its death.]");
    }

    /**
     * Displays a message indicating that the player has attacked an opponent.
     * The output includes the opponent's name and the damage dealt by the player's attack.
     * @param personnage The character performing the attack, used to calculate the attack power.
     * @param opponent The character receiving the attack, whose name is displayed in the message.
     */
    public void playerAttackMessage(Personnage personnage, Personnage opponent) {
        System.out.println(ANSI_GREEN + "[You've attacked " + opponent.getName() + " (" + personnage.countAttackPower() + " damage)]" + ANSI_RESET);
    }

    /**
     * Displays a message indicating that the player has decided to leave the enemy without attacking.
     * @param enemy The enemy that the player has chosen to leave.
     */
    public void leaveEnemyMessage(Personnage enemy) {
        System.out.println("[You turned away from the " + enemy.getName() + ".]");
    }

    /**
     * Grants a blessing from the dragon to the specified character, enhancing their attack strength.
     * The method displays a narrative message.
     * @param personnage The character receiving the dragon's blessing, whose attack strength is increased.
     */
    public void blessedByDragon(Personnage personnage) {
        System.out.println("[The dragon's fierce gaze softens as you kneel before her, recognizing your submission with a low, rumbling purr of approval.]");
        System.out.println("[As the mother of young hatchlings, she bestows upon you a rare blessing, imbuing you with the ancient Dragon Force in gratitude for sparing her life.]");
        personnage.setAttackStrength(personnage.getAttackStrength() + 2);
        System.out.println(ANSI_GREEN + "[Your attack power has increased! (See your stats.)]" + ANSI_RESET);
    }

    /**
     * Grants equipment to the character based on their class after defeating a dragon.
     * Wizards receive a legendary spell, while warriors receive legendary armor.
     * @param personnage The character who defeated the dragon, determining the type of reward.
     */
    public void addStrengthFromDragon(Personnage personnage) {
        System.out.println(ANSI_GREEN + "[You have slayed the flying lizard!]" + ANSI_RESET);
        if (personnage instanceof Wizard) {
            personnage.newEquipementOffensive(new Spell("Fireball", 8));
            System.out.println(ANSI_MAGENTA + "[As a wizard, you obtained legendary spell: " + ANSI_MAGENTA + personnage.getEquipmentOffensive().getWeaponName() + ANSI_GREEN + " (see your stats).]" + ANSI_RESET);
        } else {
            personnage.newEquipementDefensif(new Shield("Dragonhide armor", 7));
            System.out.println(ANSI_MAGENTA + "[As a warrior, you obtained legendary defense: " + ANSI_MAGENTA + personnage.getEquipmentDefensif().getDefenseWeaponName() + ANSI_GREEN + " (see your stats).]" + ANSI_RESET);
        }
    }
    /**
     * Increases the attack strength of a warrior after defeating an enemy.
     * @param personnage The warrior character who has slain the enemy.
     * @param enemy The enemy that has been defeated.
     */
    public void addStrengthWarrior(Personnage personnage, Personnage enemy) {
        if (personnage instanceof Warrior) {
            System.out.println(ANSI_GREEN + "[You have slain the " + enemy.getName() + "! As a warrior, your strength rises by 1.]" + ANSI_RESET);
            personnage.setAttackStrength(personnage.getAttackStrength() + 2);
        }
    }
    /**
     * Increases the attack strength of a wizard after defeating an enemy.
     * @param personnage The wizard character who has slain the enemy.
     * @param enemy The enemy that has been defeated.
     */
    public void addStrengthWizard(Personnage personnage, Personnage enemy) {
        if (personnage instanceof Wizard) {
            System.out.println(ANSI_GREEN + "[You have killed the " + enemy.getName() + "! As a wizard, your strength rises by 1.]" + ANSI_RESET);
            personnage.setAttackStrength(personnage.getAttackStrength() + 2);
        }
    }

    /**
     * Displays an artistic representation of a scene and a message for the character.
     * @param personnage The character for whom the scene is described (name).
     */
    public static void emptyCase(Personnage personnage) {
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

    /**
     * Configures the properties of a Dragon object, including its image, message, and attack message.
     * @param dragon The Dragon object to be configured.
     */
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

    /**
     * Configures the properties of a Goblin object, including its image, message, and attack message.
     * @param goblin The Goblin object to be configured.
     */
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

    /**
     * Configures the properties of a EvilMage object, including its image, message, and attack message.
     * @param mage The EvilMage object to be configured.
     */
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

    /**
     * Configures the properties of a Nymph object, including its image, message, and attack message.
     * @param nymph The Nymph object to be configured.
     */
    public static void nymph(Nymph nymph) {
        String image = ANSI_BLUE + ".    .       . . ..   . .    .\n" +
                " .  .      .. ..   -    .. .      \n" +
                "     .  ..       @@@@@ ...   .    \n" +
                ".         . .   C@@@@@@:    .   . \n" +
                "..    .  .      . @@@@@@@@ ..  .  \n" +
                "        .    . @@@@@: @@@@@=     .\n" +
                "      .  .    @@@@@@@. @@@@.   .. \n" +
                ". .  .@@   . @@@@@@@@@ .@@@    .  \n" +
                " .     V@@@@@V %@@@@.   V       .\n" +
                "..            . #@@@  .   . ..    \n" +
                "    ..  .      @@@@@.    .. .   . \n" +
                " . .          %@@@@@@ .      .... \n" +
                "    .      . ..@@@@@@@@%    .     \n" +
                " .         .  . #@@@@@@@@*@ . ..  \n" +
                "    . . . . .. .    - -@@@@.   .  \n" +
                "  ..             .     .@@@@@ .   \n" +
                "   . .    .   @@  .  ..  @@@@ .  .\n" +
                " .....  .    @@.       .@@@@=  .  \n" +
                "  .   .. +@@@@@@ ..  ..-@@@- ..   \n" +
                "       .:@T. . #@@@@@@@@@@        \n" +
                "    ..  ..     . ..#%#-.     ..   \n" +
                ".  ..  .     .   .      ..     ..  " + ANSI_RESET;
        nymph.setImage(image);
        nymph.setMessage("You sense an alluring presence ahead; a nymph stands gracefully, her smile hinting at both mischief and mercy.");
    }

    /**
     * Displays a message based on the type of nymph encountered and affects the specified character.
     * @param nymphType An integer representing the type of nymph (1 for mermaid (positive effect), other for siren (negative effect)).
     * @param personnage The character affected by the nymph's actions.
     */
    public static void nymphMessage(int nymphType, Personnage personnage) {
        System.out.println(ANSI_BLUE + "Voice" + ANSI_RESET + ": Come closer, " + personnage.getName() + "... Lay your head near my waters...");
        System.out.println("[You followed the sweet voice to the shore. You laid down and felt asleep...]");
        wait(2500);
        if (nymphType == 1) {
            System.out.println(ANSI_GREEN + "[ While you were asleep, a mermaid healed your wounds. Your maxHP increased by 3. ]" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "[ While you were asleep, a siren took your equipment. Your equipment is lost. ]" + ANSI_RESET);
        }
    }
    /**
     * Displays the available actions the player can take in response to an encounter with an enemy.
     * @param enemy The enemy encountered by the player, which may influence the available choices.
     * @return An integer representing the player's choice:
     *         1 for attacking or approaching the corpse,
     *         2 for turning away,
     *         3 for kneeling before the dragon if the enemy is a dragon.
     */
    public static int showChoices(Enemy enemy) {
        Scanner sc = new Scanner(System.in);
        System.out.println("`\n[What do you want to do?]\n");
        if (!enemy.isDead()) {
            System.out.println("1 < Attack the " + enemy.getName() + ".");
        } else {
            System.out.println("1 < Approach the " + enemy.getName() + "'s corpse. ");
        }
        System.out.println("2 < Turn away.");
        if (enemy instanceof Dragon) {
            System.out.println("3 < Kneel before the beast.");
        }
        return sc.nextInt();
    }

    /**
     * Displays the available actions the player can take in response to encountering a nymph.
     * @param nymph The nymph encountered by the player, influencing the choices available.
     * @return An integer representing the player's choice:
     *         1 for approaching the nymph,
     *         2 for turning away.
     */
    public static int showChoicesNymph(Nymph nymph) {
        Scanner sc = new Scanner(System.in);
        System.out.println("`\n[What do you want to do?]\n");
        System.out.println("1 < Approach the " + nymph.getName() + ".");
        System.out.println("2 < Turn away.");
        return sc.nextInt();
    }

    /**
     * Displays a message indicating that a character has died and identifies the killer.
     * @param died  The character that died, whose name will be capitalized in the message.
     * @param killer The name of the character or entity that caused the death.
     */
    public void deathMessage(Personnage died, String killer) {
        System.out.println(ANSI_GREEN + "[ " + StringUtils.capitalizeFirstLetter(died.getName()) + " died at the hands of " + killer + ".]" + ANSI_RESET);
    }

    /**
     * Displays a message indicating the amount of damage blocked by a character's defensive equipment.
     * @param personnage The character whose defense action is being reported.
     *                   The message will include the character's name, the amount of damage blocked,
     *                   and the name of the defensive weapon used.
     */
    public void defenseValueMessage(Personnage personnage) {
        String name = StringUtils.capitalizeFirstLetter(personnage.getName());
        System.out.println(ANSI_BLUE + "[ " + name + " blocked "
                + personnage.getEquipmentDefensif().getDefenseLevel() + " damage with his "
                + personnage.getEquipmentDefensif().getDefenseWeaponName() + " !]" + ANSI_RESET);
    }
}
