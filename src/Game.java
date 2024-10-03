import java.util.Scanner;
import java.io.*;
public class Game {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    Menu menu = new Menu();
    Personnage personnage = new Personnage();
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
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": I'm " + type + ".");

        personnage = new Personnage(name, type);
        wait(1500);
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": So you are " + personnage.name + ", another damned " + personnage.type + " from the prophecy! It's an honour, by the way.");
        System.out.println("But there were many before you, and there will be many after you. Or maybe you are the chosen one. What do I know, I'm just a silly old man.");
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
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Not bad. But you'll need to get better to face the dangers of this world. Now get out of here !");
        System.out.println("[He sips from his stinky old ale and doesn't pay any more attention to you.]");
        System.out.println();
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
        menu.quitGame(personnage.name);
    }

    public boolean gameRound() {
        int dice = throwDice();
        int end = 64;
        System.out.println("You were here: " + personnage.position);

        System.out.println("This is your position now.");
        System.out.println("============================");
        System.out.println("|          "+ personnage.position +"              |");
        System.out.println("============================");
        System.out.println("             | | ");
        System.out.println("             | | ");
        System.out.println("             | | ");
        System.out.println("             | | ");

        System.out.println("You throw the dice.");
        wait(2000);
        System.out.println("Dice shows number " + dice + ".");
        personnage.position += dice;
        System.out.println("You're traveling to the position n.: " + personnage.position);
        if (personnage.position >= end) {
            System.out.println("You reached the end.");
            return true;
        }
        return false;
    }

    public int throwDice() {
        return (int)(Math.random() * 6 + 1);
    }

}
