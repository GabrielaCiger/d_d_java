package menu;

import displayutils.StringUtils;
import personnages.Personnage;

import java.util.Scanner;

import static displayutils.Colors.*;
import static displayutils.ConsoleUtils.clearConsoleCommand;

public class Story extends Menu {
    boolean rememberedDuncan = false;
    boolean visitedBirdcage = false;
    boolean visitedGlassTable = false;
    boolean destroyedBox = false;

    public Story() {
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
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

    public void outro(Personnage personnage) {
        Scanner sc = new Scanner(System.in);
        String name = personnage.getName();
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": I'm a " + personnage.getType() + ".");
        wait(1500);
        System.out.println(ANSI_BLUE + "Unknown man" + ANSI_RESET + ": So you are " + name + ", another damned " + personnage.getType() + " from the prophecy! It's an honour, by the way.");
        System.out.println("But there were many before you, and there will be many after you. Or maybe you are the chosen one. What do I know, I'm just a silly old man.");
        wait(2000);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": I'm Duncan, not that you will need to remember my name. Let me see, how strong you are. ");

        wait(1100);
        System.out.println(personnage.showPlayerStats());

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
            System.out.println(ANSI_GREEN + name + ANSI_RESET + ": What do you mean by that?");
            wait(1000);
            System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": When were you born, yesterday? Whole kingdom is suffering... Goblins stealing and murdering,");
            System.out.println("evil mages fighting for power, dragons for God's sake, those are the worst.");
            wait(5000);
            System.out.println("Horrifying flying lizards. You might be our last chance. Fulfill the prophecy and reach the Temple.");
            System.out.println(ANSI_GREEN + name + ANSI_RESET + ": What temple? Why is it so important?");
            wait(4000);
            System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": The Temple protects the meaning of life. You must find it.");
            System.out.println("[His hands start to shake. He looks nervous and scaANSI_RED.]");
        }
        wait(2500);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": Go and find... the Temple. You have to...");
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": I'll do my best. But how can I find it?");
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
        System.out.println("   [ You obtained : " + ANSI_MAGENTA + "Magic dice" + ANSI_RESET + ". ]   ");
        wait(3000);
        System.out.println(ANSI_BLUE + "Duncan" + ANSI_RESET + ": It's all I can do. Now go. GET OUT OF HERE!");
        System.out.println(ANSI_GREEN + name + ANSI_RESET + ": Thank you, Duncan.");
        System.out.println();
        System.out.println("[You left the tavern.]");
        System.out.println();
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
    }

    public int playerDied(Personnage personnage) {
        System.out.println(ANSI_RED + "[You were killed by your opponent.]");
        clearConsoleCommand();
        wait(1000);
        System.out.println(ANSI_RED + "[As you lie in darkness, a chilling breeze sweeps over you, whispering ancient secrets. \n From the shadows, a sinister and ethereal presence draws near, its form shifting like smoke, invoking dread in the depths of your soul...]" + ANSI_RESET);
        wait(3500);
        System.out.println("                    ___          \n" +
                "                 /   \\        \n" +
                "              /\\ |" + ANSI_RED + " . ." + ANSI_RESET + " \\       \n" +
                "            ////\\|     ||       \n" +
                "          ////   \\ ___//\\       \n" +
                "         ///      \\\\      \\      \n" +
                "        ///       |\\      |     \n" +
                "       //         | \\  \\   \\    \n" +
                "       /          |  \\  \\   \\   \n" +
                "                  |   \\ /   /   \n" +
                "                  |    \\/   /    \n" +
                "                  |     \\/|     \n" +
                "                  |      \\\\|     \n" +
                "                  |       \\\\     \n" +
                "                  |        |     \n" +
                "                  |_________\\     \n");
        System.out.println(ANSI_RED + "Reaper" + ANSI_RESET + ": So we finally meet, " + personnage.getName() + ".");
        wait(1200);
        System.out.println(ANSI_RED + "Reaper" + ANSI_RESET + ": I'm giving you a chance, just because you were so close.");
        System.out.println(ANSI_RED + "Reaper" + ANSI_RESET + ": Choose wisely.");
        wait(2000);
        System.out.println("1 < Be reborn as a " + personnage.getType() + ".");
        System.out.println("2 < Back to main menu.");
        System.out.println("3 < Quit game.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        clearConsoleCommand();
        if (choice == 3) {
            System.out.println(ANSI_RED + "Reaper" + ANSI_RESET + ": Another quitter, goodbye, then.");
            quitGame(personnage.getName());
        } else if (choice == 2) {
            System.out.println(ANSI_RED + "Reaper" + ANSI_RESET + ": See you in another life, then..\n\n\n\n");
            wait(3000);
            return 2;
        }
        System.out.println(ANSI_RED + "Reaper" + ANSI_RESET + ": See you once more later, then..\n\n\n\n");
        return 3;
    }

    public void gameEnd(Personnage personnage) {
        clearConsoleCommand();
        System.out.println("   `,.      .   .        *   .    .      .  _    ..          .\n" +
                "     \\,~-.         *           .    .       ))       *    .\n" +
                "          \\ *          .   .   |    *  . .  ~    .      .  .  ,\n" +
                " ,           `-.  .            :               *           ,-\n" +
                "  -             `-.        *._/_\\_.       .       .   ,-\n" +
                "  -                 `-_.,     |n|     .      .       ;\n" +
                "    -                    \\ ._/_,_\\_.  .          . ,'         ,\n" +
                "     -                    `-.|.n.|      .   ,-.__,'         -\n" +
                "      -                   ._/_,_,_\\_.    ,-'              -\n" +
                "      -                     |..n..|-`'-'                -\n" +
                "       -                 ._/_,_,_,_\\_.                 -\n" +
                "         -               ,-|...n...|                  -\n" +
                "           -         ,-'._/_,_,_,_,_\\_.              -\n" +
                "             -  ,-=-'     |....n....|              -\n" +
                "              -;       ._/_,_,_,_,_,_\\_.         -\n" +
                "             ,-          |.....n.....|          -\n" +
                "           ,;         ._/_,_,_,_,_,_,_\\_.         -\n" +
                "  `,  '.  `.  \".  `,  '.| n   ,-.   n |  \",  `.  `,  '.  `,  ',\n" +
                ",.:;..;;..;;.,:;,.;:,o__|__o !.|.! o__|__o;,.:;.,;;,,:;,.:;,;;:\n" +
                " ][  ][  ][  ][  ][  |_i_i_H_|_|_|_H_i_i_|  ][  ][  ][  ][  ][\n" +
                "                     |     //=====\\\\     |\n" +
                "                     |____//=======\\\\____|\n" +
                "                         //=========\\\\ \n\n");
        System.out.println("[YOU WON! You reached the Temple. What might it be guarding?]\n\n");
        endStoryChoiceFirstSwitch(endStoryChoiceFirst(), personnage);
    }

    public Integer endStoryChoiceFirst() {
        Scanner sc = new Scanner(System.in);
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
        System.out.println("     What do you want to do?");
        System.out.println("     -----------------------");
        System.out.println("     1 < Enter the temple (end story).");
        System.out.println("     2 < Show stats.");
        System.out.println("     3 < Leave, you won anyway.");
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
        return sc.nextInt();
    }

    public void endStoryChoiceFirstSwitch(int choice, Personnage personnage) {
        switch (choice) {
            case 1:
                firstStoryLine(personnage);
                break;
            case 2:
                System.out.println(personnage.showPlayerStats());
                endStoryChoiceFirstSwitch(endStoryChoiceFirst(), personnage);
            default:
                boolean quit = quitGame(personnage.getName());
                if (!quit) {
                    displayMenu();
                }
        }
    }

    public void firstStoryLine(Personnage personnage) {
        clearConsoleCommand();
        System.out.println("You walked the stairs leading you towards an entrance of the temple. \n"
                + "You came so far. You remembered the old guy from the tavern. His name was... his name... was... \n");
        Scanner sc = new Scanner(System.in);
        String response = sc.nextLine().toLowerCase().trim();
        if (response.contains("duncan")) {
            wait(1500);
            System.out.println(ANSI_GREEN + personnage.getName() + ANSI_RESET + ": Duncan...");
            rememberedDuncan = true;
        } else {
            wait(1300);
            StringUtils.capitalizeFirstLetter(response);
            System.out.println(ANSI_GREEN + personnage.getName() + ANSI_RESET + ": Was it " + response + "? If only I could remember his name...");
        }
        System.out.println("You walked various large and spacious halls of the temple, decorated with the statues of the past warriors. \n");
        wait(1200);
        System.out.println("            ______________\n" +
                "           |    __  __    |\n" +
                "           |   |  ||  |   |\n" +
                "           |   |  ||  |   |\n" +
                "           |   |__||__|   |\n" +
                "           |    __  __  ()|\n" +
                "           |   |  ||  |   |\n" +
                "           |   |  ||  |   |\n" +
                "           |   |  ||  |   |\n" +
                "           |   |  ||  |   |\n" +
                "           |   |__||__|   |\n" +
                "           |______________|\n\n");
        System.out.println("You slowly approach a mysterious door. It seems to be made from soul crystal, a precious but fragile material.");
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
        System.out.println("     What do you want to do?");
        System.out.println("     -----------------------");
        System.out.println("     1 < Enter the room behind the door.");
        System.out.println("     2 < Leave temple");
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
        int enterRoom = sc.nextInt();
        clearConsoleCommand();
        if (enterRoom == 2) {
            quitGame(personnage.getName());
        }
        System.out.println("You entered the door.");
        magicalRoomSwitch(magicalRoomChoose(), personnage);
    }

    public int magicalRoomChoose() {
        Scanner sc = new Scanner(System.in);
        System.out.println("┍━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┑");
        System.out.println("   You see a glass table and a bird cage. What do you want to approach?");
        System.out.println("   ---------------------------------------------------------");
        System.out.println("                1 < Glass table");
        System.out.println("                2 < Birdcage");
        System.out.println("                3 < Leave the temple.");
        System.out.println("┕━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┙");
        return sc.nextInt();
    }

    public void magicalRoomSwitch(int choice, Personnage personnage) {
        StoryOptions selectedOption = StoryOptions.fromValue(choice);
        switch (selectedOption) {
            case APPROACH_GLASSTABLE:
                glassTable(personnage);
                break;
            case APPROACH_BIRDCAGE:
                birdCage(personnage);
                break;
            case LEAVE_STORY:
                boolean quit = quitGame(personnage.getName());
                if (!quit) {
                    displayMenu();
                }
        }
    }

    public void birdCage(Personnage personnage) {
        Scanner sc = new Scanner(System.in);
        String player = personnage.getName();
        clearConsoleCommand();
        System.out.println("You approach a golden birdcage.");
        if (!visitedBirdcage) {
            wait(1300);
            System.out.println("But it's not empty — inside sits a golden parrot.");
            System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": You can talk to me.\n" +
                    "[The parrot startled you. But he might know, where to find what you're looking for.]");
            wait(1000);
            System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": I don't bite. I only repeat what I was once taught. \n" +
                    "[What do you want to ask?] \n" +
                    "  1 > I'm looking for the meaning of life.\n" +
                    "  2 > Why is there so much suffering in this world?\n" +
                    "  3 > Leave the parrot.\n");
            int choice = sc.nextInt();
            clearConsoleCommand();
            if (choice == 1) {
                visitedBirdcage = true;
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ":  I'm looking for the meaning of life.");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Interesting quest indeed. If you're asking it means, you haven't found it yet. \n");
                wait(2000);
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ":  That's right...");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Many adventurers have searched, many have asked. Only a few found.\n");
                wait(2000);
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ":  Can you help me? \n");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": I’m not seen, but I’m felt with every beat.");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": I’m the quiet companion that makes life complete.");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": I’m spoken in silence, I shine in the dark.");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": I live in the space between two hearts.\n");
                wait(1000);
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ":  What does it mean?");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Some nourish it, while others take it for granted. But only at the end of our journey do we truly realize its value. \n");
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Might you find the answer soon before that, " + player + "...\n");
                wait(1000);
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ":  How do you know my name? \n");
                wait(1000);
                System.out.println("[The parrot turned away and closed its eyes. He won't speak to you anymore.]");
            } else if (choice == 2) {
                visitedBirdcage = true;
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ":  Why is there so much suffering in this world? \n");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Interesting question indeed.");
                wait(1000);
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ":  Goblins are murdering, torturing, evil mages are fighting for power... Why?");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Only those with great evil inside have turned to goblins. A few of them have managed to return to their human nature.");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": But don't be fooled; even the mightiest warriors have succumbed. A broken heart, lack of gold, and bad companions can lead to their downfall...");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Every human is born with this evil curse. Are you strong enough to resist it?\n");
                wait(1000);
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ": What about the evil mages? They are human too, yet still harbor evil within...");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Those who sow the seeds of malevolence shall reap a harvest of despair.");
                wait(500);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Evil mages, chosen by the very people they deceive, wield their dark power with a twisted sense of purpose,");
                wait(500);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": while many remain blind to their wickedness, swayed by the whispers of those they trust. \n");
                if (rememberedDuncan) {
                    wait(500);
                    System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Even your old friend Duncan... He was too blinded by the empty promises of the evil mage.");
                    wait(500);
                    System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": He forgot the power of his own choices, believing in empty lies and allowing his mind to be clouded by nonsense.");
                    wait(500);
                    System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": And here you are... Sent by him to find what he has lost at the bottom of the ale.");
                    wait(500);
                    System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": Helping you was his last good deed before he himself turned into the very ones he sent you to kill. \n");
                }
                wait(500);
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ": What can you say about dragons and their evil doing?");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": From a warrior's eyes, dragons are fierce beasts, wreaking havoc and destruction upon their lands.");
                wait(500);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": But from the dragon's perspective, they are merely survivalists, seeking nourishment in a world that encroaches upon their territory.");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": They do not recognize human borders; to them, it's just a matter of hunger. People are killing animals and destroying forests everyday...");
                wait(1000);
                System.out.println(ANSI_YELLOW + "Parrot" + ANSI_RESET + ": What is a person in the eyes of a hungry mouse whose home has been destroyed to nourish the great beasts?\n");
                wait(500);
                System.out.println("[The parrot turned away and closed its eyes. He won't speak to you anymore.]");
            } else {
                System.out.println("[You turned back and came back to the door.]");
            }
        }
        System.out.println("\n[Seems like the parrot won't talk to you anymore.]");
        magicalRoomSwitch(magicalRoomChoose(), personnage);
    }

    public void glassTable(Personnage personnage) {
        Scanner sc = new Scanner(System.in);
        String player = personnage.getName();
        System.out.println("You approach a glass table.\n");
        if (!visitedGlassTable) {
            wait(2000);
            if (!destroyedBox) {
                System.out.println("You see a small shiny object on it.\n");
                System.out.println(ANSI_GREEN + player + ANSI_RESET + ": What a beautiful crystal box... I wonder what's inside.");
            } else {
                System.out.println("The crystal box has splintered into countless tiny pieces, now spread like glittering dust on the floor.");
            }
            boxChoices(personnage);
            int choice = sc.nextInt();
            jewelryBox(personnage, choice);
        }
            System.out.println("You've already been here.");
        magicalRoomSwitch(magicalRoomChoose(), personnage);
    }

    public void boxChoices(Personnage personnage) {
        System.out.println("[What do you want to do?]\n" +
                "1 > Leave the box. Return to the door.");

        if (!destroyedBox) {
            System.out.println("2 > Break the box.");

            if (personnage.isFoundKey()) {
                System.out.println("3 > Try the key.");
            }
        }
    }

    public void jewelryBox(Personnage personnage, int choice) {
        switch (choice) {
            case 1:
                magicalRoomSwitch(magicalRoomChoose(), personnage);
                break;
            case 2:
                if (!destroyedBox) {
                    System.out.println("You took the crystal box and threw it on the floor.");
                    System.out.println("The box broke into a million small pieces of shiny crystal diamonds.");
                    wait(2000);
                    System.out.println("Whatever was inside, got broken with the box.");
                    destroyedBox = true;
                    wait(1500);
                    glassTable(personnage);
                }
                break;
            case 3:
                if (!destroyedBox) {
                    if (personnage.isFoundKey()) {
                        System.out.println("In a moment of clarity, you recall the key you found during your quest. \n"
                                + "With a steady hand and bated breath, you took the key and carefully inserted it, feeling the weight of the moment as you anticipated what lay ahead.");
                        wait(2000);
                        System.out.println("You heard a silent *click* and the box opened.");
                        System.out.println("Inside the box, you found a small object, looking like a nut or a seed.");
                        wait(2500);
                        System.out.println("You hold the seed in your palm, observing it curiously.");
                        wait(1500);
                        System.out.println("Seed suddenly cracked and revealed a small scroll inside. Was it your warm hand, that cracked it open?");
                        wait(1500);
                        System.out.println("You opened the scroll.");
                        scroll(personnage);
                    }
                }
            default:
                magicalRoomSwitch(magicalRoomChoose(), personnage);
                break;
        }
    }

    public void scroll(Personnage personnage) {
        Scanner scanner = new Scanner(System.in);
        int currentPage = 1;
        boolean reading = true;
        while (reading) {
            printPage(pageOne(), pageTwo(), currentPage);
            System.out.println("1 < Turn the page");
            System.out.println("2 < Stop reading");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    currentPage = (currentPage == 1) ? 2 : 1;
                    break;
                case 2:
                    reading = false;
                    System.out.println("You have read the scroll. You put it back, and closed the box with the key.");
                    break;
                default:
                    System.out.println(ANSI_ORANGE + "[Choose from the options above.]" + ANSI_RESET);
                    break;
            }
        }
        visitedGlassTable = true;
        magicalRoomSwitch(magicalRoomChoose(), personnage);
    }

    public void printPage(String pageOne, String pageTwo, int currentPage) {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Page " + currentPage);
        if (currentPage == 1) {
            System.out.println(pageOne + "\n");
        } else if (currentPage == 2) {
            System.out.println(pageTwo + "\n");
        } else {
            System.out.println("No more pages to read.");
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public String pageOne() {
        String text = "To plant is to share. To care for life is to understand that not every seed must grow into another tree. \n" +
                " Just as each seed is unique, so too are the paths we choose. Some will grow into new life, while others may choose \n" +
                "to nurture the seeds of thought, creativity, or love.";
        return text;
    }

    public String pageTwo() {
        String text = "It is okay if some choose not to plant their seeds in the traditional sense. Each choice is valid; each path is worthy. \n" +
                "The legacy of life can thrive in many forms. Whether through children, art, or kindness, life continues to grow, spreading roots \n" +
                "in different directions.";
        return text;
    }
}

