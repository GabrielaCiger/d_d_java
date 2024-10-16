package menu;
import displayutils.StringUtils;
import personnages.heroes.Warrior;
import personnages.heroes.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static displayutils.Colors.*;

public class Menu {
    public Menu() {}

    public int getValidChoice( List validOptions ) {
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine();
        while ( !userChoice.matches("\\d+") && !validOptions.contains(userChoice) ) {
            displayInvalidChoiceMessage();
            userChoice = sc.nextLine();
        }
        return Integer.parseInt(userChoice);
    }
    /**
     * Displays a menu to the user and prompts for a choice until a valid selection is made.
     * The menu consists of three options. The method continues to prompt the user
     * for input until they provide a choice within the range of valid options (1 to 3).
     * @return The user's choice as an integer, which will be one of the valid menu options (1, 2, or 3).
     */
    public int displayMenu() {
        displayStartMenu();
        List<Integer> possibleChoices = List.of(1, 2, 3);
        return getValidChoice(possibleChoices);
    }

    /**
     * Displays a message when the user's choice is invalid, prompting them to select a valid option.
     */
    public static void displayInvalidChoiceMessage(){
        System.out.println(ANSI_ORANGE + "[Please, select from options above.]" + ANSI_RESET);
    }

    /**
     * Displays the main menu for the D&D game with options to start a new game, skip the intro, or exit.
     * The menu features stylized ASCII art and colorful text.
     * @see #displayMenu()
     */
    public void displayStartMenu() {
        System.out.println(ANSI_RED + "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣤⡼⠀⢀⡀⣀⢱⡄⡀⠀⠀⠀⢲⣤⣤⣤⣤⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀      ⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⡿⠛⠋⠁⣤⣿⣿⣿⣧⣷⠀⠀⠘⠉⠛⢻⣷⣿⣽⣿⣿⣷⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀      ⠀⢀⣴⣞⣽⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠠⣿⣿⡟⢻⣿⣿⣇⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣟⢦⡀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀     ⣠⣿⡾⣿⣿⣿⣿⣿⠿⣻⣿⣿⡀⠀⠀⠀⢻⣿⣷⡀⠻⣧⣿⠆⠀⠀⠀⠀⣿⣿⣿⡻⣿⣿⣿⣿⣿⠿⣽⣦⡀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀      ⣼⠟⣩⣾⣿⣿⣿⢟⣵⣾⣿⣿⣿⣧⠀⠀⠀⠈⠿⣿⣿⣷⣈⠁⠀⠀⠀⠀⣰⣿⣿⣿⣿⣮⣟⢯⣿⣿⣷⣬⡻⣷⡄⠀⠀⠀");
        System.out.println("       ⠀⢀⡜⣡⣾⣿⢿⣿⣿⣿" + ANSI_RESET + "  ============================" + ANSI_RED + "  ⢯⣿⣿⣷⣬⡻⣷⡄      ");
        System.out.println("       ⡜⣡⣾⣿⢿⣿⣿⣿⣿" + ANSI_RESET + "   |     D&D (Java edition)   |" + ANSI_RED + "  ⠈⠻⣆⠙⣿⣜⠆⠀");
        System.out.println("      ⡜⣡⣾⣿⢿⣿⣿⣿⣿" + ANSI_RESET + "    ============================" + ANSI_RED + "    ⠈⠙⢾⣆⠈⣷");
        System.out.println("      ⢯⣿⠏⣠⠞⠋⣠⡿⠋" + ANSI_RESET + "    Type the number: " + ANSI_RED + "                   ⠃⢸");
        System.out.println("       ⣸⠇⢠⣷⠞" + ANSI_RESET + "             1 < New game (story)        " + ANSI_RED);
        System.out.println("       ⣸⠇⢠⣷" + ANSI_RESET + "                2 < Skip intro        " + ANSI_RED);
        System.out.println("       ⡟⠀⡿⠁" + ANSI_RESET + "                  3 < Exit  ");
        System.out.println("                     ============================");
        System.out.println(ANSI_RED + "                              ⠙⠻⠿⠿⠋⠀⢻⣿⡄");
        System.out.println("                          ⠈⠻⣿  ⣴⣶⣤⡀ ⢸⣿⠇⠀");
        System.out.println("                            ⢸⡇⠀⠈⣿⣼⡟");
        System.out.println("                            ⠈⠻⠶⣶⡟⠋" + ANSI_RESET);
    }

    /**
     * Displays the available character classes and their attributes.
     * This includes information on the WARRIOR and WIZARD classes,
     * such as HP, attack power, and the type of weapons they can wield.
     */
    public void showClasses() {
        System.out.println("============================ ============================");
        System.out.println("|    Class 1: WARRIOR ➶   | |     Class 2: WIZARD ✧˖°  |");
        System.out.println("============================ ============================");
        System.out.println("| HP: 10                   | | HP: 6                    |");
        System.out.println("| Attack: 10               | | Attack: 15               |");
        System.out.println("|                          | |                          |");
        System.out.println("| Can hold only battle     | | Can hold only magical    |");
        System.out.println("| weapons.                 | | weapons.                 |");
        System.out.println("============================ ============================");
        System.out.println();
    }

    /**
     * Creates and displays the stats of a new player based on the selected class type.
     * @param name the name of the player
     * @param type the class type of the player ("wizard" or "warrior")
     */
    public void showPlayerCreation(String name, String type) {
        if (type.equals("wizard")) {
            Wizard wizard = new Wizard(name);
            System.out.println(wizard.showPlayerStats());
        } else {
            Warrior warrior = new Warrior(name);
            System.out.println(warrior.showPlayerStats());
        }
    }

    /**
     * Prompts the user to confirm quitting the game and displays a goodbye message if confirmed.
     * @param name the name of the player to personalize the goodbye message
     * @return true if the game is quit, false otherwise
     */
    public boolean quitGame(String name) {
        String goodbyeMessage = "Goodbye";
        if (!name.isEmpty()) {
            goodbyeMessage += " " + name;
        }
        goodbyeMessage += " !";
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you sure, that you want to quit? (y/n)");
        String response = sc.nextLine().toLowerCase().trim();
        if (response.contains("y")) {
            System.out.println(goodbyeMessage);
            System.exit(0);
        } else {
            return false;
        }
        return false;
    }

    /**
     * Prompts the player to enter their name and ensures it is not empty.
     * Displays greeting messages upon receiving the name.
     * @return the player's name, capitalized
     */
    public String getPlayerName() {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": Hello there, foreign traveler. What's your name?");
        do {
            name = sc.nextLine().trim();
            name = StringUtils.capitalizeFirstLetter(name);
            if (name.isEmpty()) {
                System.out.println("[Input can't be empty. Choose a name.]");
            }
        } while (name.isEmpty());
        name = StringUtils.capitalizeFirstLetter(name);
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": Hello, my name is " + name + ". ");
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": Nice to meet you, " + name + ".");
        return name;
    }

    /**
     * Prompts the player to choose a character class (wizard or warrior).
     * Provides an option to view class information. If the input is invalid,
     * it defaults to "warrior".
     * @return the player's chosen class type as a lowercase string
     */
    public String getPlayerType() {
        Scanner sc = new Scanner(System.in);
        String type;

        while (true) {
            System.out.println();
            System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": What are you doing here?");
            System.out.println("[Choose your class. Type " + ANSI_GREEN + "wizard" + ANSI_RESET + " or " + ANSI_GREEN + "warrior" + ANSI_RESET + ". Type " + ANSI_BLUE + "help" + ANSI_RESET + " to see classes info.]");
            String answer = sc.nextLine().trim().toLowerCase();

            if (answer.equals("help")) {
                showClasses();
            } else if (answer.equals("wizard") || answer.equals("warrior")) {
                type = answer;
                break;
            } else {
                System.out.println("Invalid choice. Defaulting to " + ANSI_GREEN + "warrior" + ANSI_RESET + ".");
                type = "warrior";
                break;
            }
        }
        return type;
    }

    /**
     * Displays options for the player to validate their choices regarding
     * their character's name and type. Allows the player to change the name,
     * change the type, continue without changes, or quit the game.
     * @return an integer representing the player's choice
     */
    public int changePlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n[Do you want to validate your choices?]" +
                "-------------------------" +
                "1 < No, change the name. \n" +
                "2 < No, change the type. \n" +
                "3 < Yes, continue without changing. \n" +
                ANSI_RED + "4 < Quit game." + ANSI_RESET);
        return sc.nextInt();
    }

    /**
     * Updates the player's settings based on the given choice.
     * The player can change their name, change their character type,
     * or quit the game. If an invalid choice is made, it returns the
     * current name and type without changes.
     * @param choice the player's selection indicating the action to perform
     * @param name the current name of the player
     * @param type the current character type of the player
     * @return an array containing the updated name and type
     */
    public String[] changePlayerSettings(int choice, String name, String type) {
        switch (choice) {
            case 1:
                name = getPlayerName();
                break;
            case 2:
                type = getPlayerType();
                break;
            case 4:
                quitGame(name);
                break;
            default:
                return new String[]{name, type};
        }
        return new String[]{name, type};
    }

    /**
     * Prompts the user for input to select an action for the new round.
     * Valid choices are 1 to 3. If the input is empty, it defaults to choice 1.
     * Invalid inputs prompt the user to select from the available options.
     * @return the user's choice for the action in the new round (1 to 3)
     */
    public int newRound() {
        roundChoices();
        List<Integer> gameRoundOptions = List.of(1, 2, 3);
        int choice = getValidChoice(gameRoundOptions);
        return choice;
    }

    /**
     * Displays the available choices for the player during a round.
     * Prompts the player with options to throw dice, show stats, or quit the adventure.
     */
    public void roundChoices() {
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
        System.out.println("        What do you want to do?");
        System.out.println("        -----------------------");
        System.out.println("           1 < Throw dice.");
        System.out.println("           2 < Show stats.");
        System.out.println("           3 < Quit adventure.");
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
    }

    /**
     * Displays the result of a dice throw, including a visual representation of the dice face.
     * @param diceThrow The result of the dice throw (1-6).
     */
    public void showThrow(int diceThrow) {
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑\n");
        System.out.println("You throw the magic dice. You see the dice rolling, when suddenly... it stops...");
        switch (diceThrow) {
            case 1:
                System.out.println("    +-------+ ");
                System.out.println("    |       | ");
                System.out.println("    |   O   | ");
                System.out.println("    |       | ");
                System.out.println("    +-------+ ");
                break;
            case 2:
                System.out.println("    +-------+ ");
                System.out.println("    | O     | ");
                System.out.println("    |       | ");
                System.out.println("    |     O | ");
                System.out.println("    +-------+ ");
                break;
            case 3:
                System.out.println("    +-------+ ");
                System.out.println("    | O     | ");
                System.out.println("    |   O   | ");
                System.out.println("    |     O | ");
                System.out.println("    +-------+ ");
                break;
            case 4:
                System.out.println("    +-------+ ");
                System.out.println("    | O   O | ");
                System.out.println("    |       | ");
                System.out.println("    | O   O | ");
                System.out.println("    +-------+ ");
                break;
            case 5:
                System.out.println("    +-------+ ");
                System.out.println("    | O   O | ");
                System.out.println("    |   O   | ");
                System.out.println("    | O   O | ");
                System.out.println("    +-------+ ");
                break;
            case 6:
                System.out.println("    +-------+ ");
                System.out.println("    | O   O | ");
                System.out.println("    | 0   0 | ");
                System.out.println("    | O   O | ");
                System.out.println("    +-------+ ");
                break;
        }
    }

    /**
     * Prompts the user to confirm their choices.
     * @return true if the user confirms (by entering 'y', 'yes', or leaving the input empty);
     *         false otherwise.
     */
    public boolean validateChoices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[Do you confirm? (y/n)]");
        String answer = sc.nextLine().trim().toLowerCase();
        if (answer.equals("y") || answer.equals("ye") || answer.equals("yes") || answer.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Displays the movement of a player from an initial position to a final position.
     * @param initPos the initial position of the player.
     * @param finalPos the final position of the player.
     */
    public void showPlayerMovement(int initPos, int finalPos) {
        System.out.print("\n"+ ANSI_BLUE+ "      ______       ______\n" +
                "     |      |     |      |\n" +
                String.format("     |  %2d  |---->|  %2d  |\n", initPos, finalPos) +
                "     |______|     |______|\n\n\n" + ANSI_RESET);
    }


}

