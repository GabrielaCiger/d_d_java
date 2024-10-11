package menu;
import displayutils.StringUtils;
import personnages.heroes.Warrior;
import personnages.heroes.Wizard;
import java.util.Scanner;
import static displayutils.Colors.*;

public class Menu {
    public Menu() {}

    public int displayMenu() {
        Scanner in = new Scanner(System.in);
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
        return in.nextInt();
    }

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

    public void showPlayerCreation(String name, String type) {
        if (type.equals("wizard")) {
            Wizard wizard = new Wizard(name);
            System.out.println(wizard.showPlayerStats());
        } else {
            Warrior warrior = new Warrior(name);
            System.out.println(warrior.showPlayerStats());
        }
    }

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

    public int newRound() {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            roundChoices();
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                return 1;
            }
            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 3) {
                    break;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println(ANSI_ORANGE + "[Choose from the options above.]" + ANSI_RESET);
        }
        return choice;
    }

    public void roundChoices() {
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
        System.out.println("        What do you want to do?");
        System.out.println("        -----------------------");
        System.out.println(" [enter] / 1 < Throw dice.");
        System.out.println("           2 < Show stats.");
        System.out.println("           3 < Quit adventure.");
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
    }

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

    public boolean validateChoices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[Do you confirm? (y/n)]");
        String answer = sc.nextLine().trim().toLowerCase();
        if (answer.equals("y") || answer.equals("ye") || answer.equals("yes") || answer.isEmpty()) {
            return true;
        }
        return false;
    }

    public void showPlayerMovement(int initPos, int finalPos) {
        System.out.print("\n"+ ANSI_BLUE+ "      ______       ______\n" +
                "     |      |     |      |\n" +
                String.format("     |  %2d  |---->|  %2d  |\n", initPos, finalPos) +
                "     |______|     |______|\n\n\n" + ANSI_RESET);
    }
}

