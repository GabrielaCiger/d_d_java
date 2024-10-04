import java.util.Scanner;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";


    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public Integer displayMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣤⡼⠀⢀⡀⣀⢱⡄⡀⠀⠀⠀⢲⣤⣤⣤⣤⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀      ⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⡿⠛⠋⠁⣤⣿⣿⣿⣧⣷⠀⠀⠘⠉⠛⢻⣷⣿⣽⣿⣿⣷⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀      ⠀⢀⣴⣞⣽⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠠⣿⣿⡟⢻⣿⣿⣇⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣟⢦⡀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀     ⣠⣿⡾⣿⣿⣿⣿⣿⠿⣻⣿⣿⡀⠀⠀⠀⢻⣿⣷⡀⠻⣧⣿⠆⠀⠀⠀⠀⣿⣿⣿⡻⣿⣿⣿⣿⣿⠿⣽⣦⡀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀      ⣼⠟⣩⣾⣿⣿⣿⢟⣵⣾⣿⣿⣿⣧⠀⠀⠀⠈⠿⣿⣿⣷⣈⠁⠀⠀⠀⠀⣰⣿⣿⣿⣿⣮⣟⢯⣿⣿⣷⣬⡻⣷⡄⠀⠀⠀");
        System.out.println("       ⠀⢀⡜⣡⣾⣿⢿⣿⣿⣿ ============================ ⢯⣿⣿⣷⣬⡻⣷⡄      ");
        System.out.println("       ⡜⣡⣾⣿⢿⣿⣿⣿⣿  |     D&D (Java edition)   |  ⠈⠻⣆⠙⣿⣜⠆⠀");
        System.out.println("      ⡜⣡⣾⣿⢿⣿⣿⣿⣿   ============================    ⠈⠙⢾⣆⠈⣷");
        System.out.println("      ⢯⣿⠏⣠⠞⠋⣠⡿⠋    Type the number:                    ⠃⢸");
        System.out.println("       ⣸⠇⢠⣷⠞             1 < New game (story)        ");
        System.out.println("       ⣸⠇⢠⣷                2 < Skip intro        ");
        System.out.println("       ⡟⠀⡿⠁                  3 < Exit  ");
        System.out.println("                    ============================");
        System.out.println("                              ⠙⠻⠿⠿⠋⠀⢻⣿⡄");
        System.out.println("                            ⣿⣿  ⣴⣶⣤⡀⢸⣿⠇⠀");
        System.out.println("                            ⢸⡇⠀⠈⣿⣼⡟");
        System.out.println("                            ⠈⠻⠶⣶⡟⠋");
        return in.nextInt();
    }

    public void intro() {
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
        System.out.println("⠀⢀⣀⣀⣀⠀⣶⣶⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⣶⣶⠀⣀⣀⣀⡀⠀");
        System.out.println("⠀⠘⠛⠛⠛⠀⣿⣿⠀⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠀⣿⣿⠀⠛⠛⠛⠃⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⣿⣤⣤⣤⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣀⣀⣀⣀⣀⣀⣿⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡿⠛⣛⠋⣠⣄⣉⣉⠙⣿⣿⣿⣿⣿⣿⠿⠿⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡇⢸⣿⡿⣿⡿⠹⣿⠇⠛⠻⣿⣿⣿⣿⣶⣦⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⣀⣤⣭⣿⣿⣿⣿⠄⢠⣤⣈⣁⣤⡄⠠⣶⡀⢹⣿⣿⣿⣿⣿⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⠀⣿⡇⢸⣿⣿⣿⣿⣿⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⠀⣿⠀⣼⣿⣿⣿⣿⣉⠉⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⠐⠛⠛⠛⠛⠛⠛⠂⣠⣴⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠛⠛⠻⢿⣿⣿⣿⠘⠛⠛⠛⠛⠛⠛⠃⣿⣿⣿⣿⡿⠟⠛⠛⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀ ⠈⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠁⠀⠀⠀⠀⠀⠀⠀");
        System.out.println();
        System.out.println("You walk into an old tavern. You look around.");
        wait(2500);
        System.out.println("It's quiet, dark and filthy.");
        wait(2500);
        System.out.println("You decide to sit next to an old grey man, sitting in a very corner of the tavern.");
        wait(2500);
        System.out.println("He seems sad, maybe hopeless? As you sit, he looks at you with an uninterested glaze.");
        wait(1500);
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

    public void outro(Personnage personnage) {
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_GREEN + personnage.name + ANSI_RESET + ": I'm a " + personnage.type + ".");
        wait(1500);
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": So you are " + personnage.name + ", another damned " + personnage.type + " from the prophecy! It's an honour, by the way.");
        System.out.println("But there were many before you, and there will be many after you. Or maybe you are the chosen one. What do I know, I'm just a silly old man.");
        wait(2000);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": I'm Duncan, not that you will need to remember my name. Let me see, how strong you are. ");

        wait(1100);
        System.out.println();
        System.out.println("============================");
        System.out.println("  " + ANSI_GREEN + personnage.name + ANSI_RESET + "  ");
        System.out.println("============================");
        System.out.println("| HP: " + personnage.life);
        System.out.println("| Attack level : " + personnage.attackStrength);
        System.out.println("| Damage : " + personnage.equipmentOffensive.name + "(+" + personnage.equipmentOffensive.attackLevel + ")");
        System.out.println("| Defense : " + personnage.equipmentDefensif.name + "(+" + personnage.equipmentDefensif.defenseLevel + ")");
        System.out.println("============================");

        wait(2800);
        System.out.println();
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Not bad. But you'll need to get better to face the dangers of this world.");
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Look, maybe I can do something to help you. It's time the things change around here...");
        System.out.println("[He sips from his stinky old ale. His face gets even more sad glaze.]");

        System.out.println("Options (type the number):");
        System.out.println("1 < 'What do you mean by that?'");
        System.out.println("2 < Stay silent.");
        String answer = sc.nextLine();
        if (answer.equals("1")) {
            System.out.println(ANSI_GREEN + personnage.name + ANSI_RESET + ": What do you mean by that?");
            wait(1000);
            System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": When were you born, yesterday? Whole kingdom is suffering... Goblins stealing and murdering,");
            System.out.println("evil mages fighting for power, dragons for God's sake, those are the worst.");
            wait(5000);
            System.out.println("Horrifying flying lizards. You might be our last chance. Fulfill the prophecy and reach the Temple.");
            System.out.println(ANSI_GREEN + personnage.name + ANSI_RESET + ": What temple? Why is it so important?");
            wait(4000);
            System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": The Temple protects the meaning of life. You must find it.");
            System.out.println("[His hands start to shake. He looks nervous and scared.]");
        }
        wait(2500);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Go and find... the Temple. You have to...");
        System.out.println(ANSI_GREEN + personnage.name + ANSI_RESET + ": I'll do my best. But how can I find it?");
        System.out.println("[Duncan thinks. After a while he reaches deep down in his pocket and takes something out of it.]");
        wait(4000);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Take this. It will lead you to the temple... or to your death.");
        wait(4000);
        System.out.println("[You take a small object out of Duncan's hand.]");
        System.out.println("    _______            ");
        System.out.println("  /\\       \\           ");
        System.out.println(" /()\\   ()  \\          ");
        System.out.println("/    \\_______\\         ");
        System.out.println("\\    /()     /         ");
        System.out.println(" \\()/   ()  /          ");
        System.out.println("  \\/_____()/           ");
        System.out.println();
        System.out.println("   [ You obtained : " + ANSI_PURPLE + "Magic dice" + ANSI_RESET + ". ]   ");
        wait(3000);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": It's all I can do. Now go. GET OUT OF HERE!");
        System.out.println(ANSI_GREEN + personnage.name + ANSI_RESET + ": Thank you, Duncan.");
        System.out.println();
        System.out.println("[You left the tavern.]");
        System.out.println();
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
    }

    public void quitGame(String name) {
        String goodbyeMessage = "Goodbye";
        if (!name.isEmpty()) {
            goodbyeMessage += " " + name;
        }
        goodbyeMessage += " !";
        System.out.println(goodbyeMessage);
        System.exit(0);
    }



    public String getPlayerName() {
        /* ! SET NAME*/
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": Hello there, foreign traveler. What's your name?");
        String name = sc.nextLine();
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": Hello, my name is " + name + ". ");
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": Nice to meet you, " + name + ". What are you doing here ?");
        return name;
    }

    public String getPlayerType(String name) {
        Scanner sc = new Scanner(System.in);
        String type;

        while (true) {
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

    public boolean startGame(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you sure, " + name + ", that you want to continue? (y/n)");
        String response = sc.nextLine().toLowerCase().trim();
        if (response.contains("n")) {
            quitGame(name);
        }
        return true;
    }

    public void showThrow(int diceThrow) {
        System.out.println("You throw the magic dice. You see the dice rolling, when suddenly... it stops...");
        Menu.wait(4000);
        switch (diceThrow) {
            case 1:
                System.out.println(" +-------+ ");
                System.out.println(" |       | ");
                System.out.println(" |   O   | ");
                System.out.println(" |       | ");
                System.out.println(" +-------+ ");
                break;
            case 2:
                System.out.println(" +-------+ ");
                System.out.println(" | O     | ");
                System.out.println(" |       | ");
                System.out.println(" |     O | ");
                System.out.println(" +-------+ ");
                break;
            case 3:
                System.out.println(" +-------+ ");
                System.out.println(" | O     | ");
                System.out.println(" |   O   | ");
                System.out.println(" |     O | ");
                System.out.println(" +-------+ ");
                break;
            case 4:
                System.out.println(" +-------+ ");
                System.out.println(" | O   O | ");
                System.out.println(" |       | ");
                System.out.println(" | O   O | ");
                System.out.println(" +-------+ ");
                break;
            case 5:
                System.out.println(" +-------+ ");
                System.out.println(" | O   O | ");
                System.out.println(" |   O   | ");
                System.out.println(" | O   O | ");
                System.out.println(" +-------+ ");
                break;
            case 6:
                System.out.println(" +-------+ ");
                System.out.println(" | O   O | ");
                System.out.println(" | 0   0 | ");
                System.out.println(" | O   O | ");
                System.out.println(" +-------+ ");
                break;
        }
        Menu.wait(1500);
    }

    public boolean validateChoices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[Do you confirm the changes? (y/n)]");
        String answer = sc.nextLine().trim().toLowerCase();
        if (answer.equals("y") || answer.equals("ye") || answer.equals("yes")) {
            return true;
        }
        return false;
    }
}
