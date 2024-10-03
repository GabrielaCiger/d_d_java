import java.util.Scanner;
import java.io.*;
public class Game {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    Menu menu = new Menu();
    Personnage personnage = new Personnage();
    Board board = new Board(personnage);
    /* ? This is a function to create delays in intro (so far). */
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /* ? This is a little story to create a player. There's a lot of system.out.prints :-) */
    public void intro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
        System.out.println("You walk into an old tavern. You look around.");
        wait(2500);
        System.out.println("It's quiet, dark and filthy.");
        wait(2500);
        System.out.println("You decide to sit next to an old grey man, sitting in a very corner of the tavern.");
        wait(2500);
        System.out.println("He seems sad, maybe hopeless? As you sit, he looks at you with an uninterested glaze.");
        wait(1500);
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": Hello there, foreign traveler. What's your name?");
        String name = sc.nextLine();
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": Hello, my name is " + name + ". ");
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": Nice to meet you, " + name + ". What are you doing here ?");
        System.out.println("[Choose your class. Type " + ANSI_GREEN + "wizard" + ANSI_RESET + " or " + ANSI_GREEN + "warrior" + ANSI_RESET+ ".]");
        String type = sc.nextLine().trim().toLowerCase();
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": I'm a " + type + ".");

        personnage = new Personnage(name, type);
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
        System.out.println("| Attack: " + personnage.attackStrength);
        System.out.println("| Attack weapon : " + personnage.equipmentOffensive.name);
        System.out.println("| Defense weapon : " + personnage.equipmentDefensif.name);
        System.out.println("============================");

        wait(2800);
        System.out.println();
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Not bad. But you'll need to get better to face the dangers of this world.");
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Look, maybe I can do something to help you. It's time the things change around here...");
        System.out.println("[He sips from his stinky old ale. His face gets even more sad glaze.]");

        System.out.println("Options (type the number):");
        System.out.println("1 < 'What do you mean by that?'");
        System.out.println("2 < Stay silent.");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println(ANSI_GREEN + name + ANSI_RESET + ": What do you mean by that?");
            wait(1000);
            System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": When were you born, yesterday? Whole kingdom is suffering... Goblins stealing and murdering,");
            System.out.println("evil mages fighting for power, dragons for God's sake, those are the worst.");
            wait(5000);
            System.out.println("Horrifying flying lizards. You might be our last chance. Fulfill the prophecy and reach the Temple.");
            System.out.println(ANSI_GREEN + name + ANSI_RESET + ": What temple? Why is it so important?");
            wait(2000);
            System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": The Temple protects the meaning of life. You must find it.");
            System.out.println("[His hands start to shake. He looks nervous and scared.]");
        }
        wait(4000);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Go and find... the Temple. You have to...");
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": I'll do my best. But how can I find it?");
        System.out.println("[Duncan thinks. After a while he reaches deep down in his pocket and takes something out of it.]");
        wait(4000);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Take this. It will lead you to the temple... or to your death.");
        wait(4000);
        System.out.println("[You take a small object out of Duncan's hand.]");
        System.out.println("   +-------+");
        System.out.println("  /       /|");
        System.out.println(" +-------+ |");
        System.out.println(" |       | +");
        System.out.println(" |       |/");
        System.out.println(" +-------+");
        wait(3000);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": It's all I can do. Now go. GET OUT OF HERE!");
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": Thank you, Duncan.");
        System.out.println();
        System.out.println("[You left the tavern.]");
        System.out.println();
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
        menu.quitGame(personnage.name);
    }

    public boolean gameRound() {
        int diceThrow = board.throwDice();
        System.out.println("You throw the magic dice. You see the dice rolling, when suddenly... it stops...");
        wait(4000);
        System.out.println("   +-------+");
        System.out.println("  /       /|");
        System.out.println(" +-------+ |");
        System.out.println(" |       | +");
        System.out.println(" |    "+diceThrow+"  |/");
        System.out.println(" +-------+");
        wait(2000);
        System.out.println("pos before : " + board.playerPosition );
        board.movePlayer(diceThrow);
        System.out.println("pos after : " + board.playerPosition );
        if (board.playerPosition > board.boardSize) {
            return true;
        }
        return false;
    }

}
