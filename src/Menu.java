import java.util.Scanner;

public class Menu {

    /* * MAIN MENU */
    public void displayMenu() {
        int optionSelected;
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
        System.out.println("       ⣸⠇⢠⣷⠞             1 < New game         ");
        System.out.println("       ⡟⠀⡿⠁                2 < See class types  ");
        System.out.println("                             3 < Exit            ");
        System.out.println("                    ============================");
        System.out.println("                              ⠙⠻⠿⠿⠋⠀⢻⣿⡄");
        System.out.println("                            ⣿⣿  ⣴⣶⣤⡀⢸⣿⠇⠀");
        System.out.println("                            ⢸⡇⠀⠈⣿⣼⡟");
        System.out.println("                            ⠈⠻⠶⣶⡟⠋");
        optionSelected = in.nextInt();
        Game game = new Game();
        switch (optionSelected) {
            case 1:
                game.intro();
                break;
            case 2:
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
                Scanner in2 = new Scanner(System.in);
                System.out.println("Do you want to start a game? (y/n)");
                String answer = in2.nextLine();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                    game.intro();
                } else {
                    displayMenu();
                }
                break;
            case 3:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
        }
    }

    /* *  Menu options : start game starts at the end of the intro */
    public void quitGame(String name) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Are you sure, "+ name + ", that you want to continue? (y/n)");
        String response = sc.nextLine().toLowerCase().trim();
        if (response.contains("n")) {
            System.out.println("Goodbye, " + name + "!");
            System.exit(0);
        } else {
            startGame();
        }
    }

    public void startGame() {
        Game game = new Game();
        /* ! Add condition to add the game -> while loop? add end game boolean? */
        do {
            game.gameRound();
        } while (!game.gameRound());
    }
}
