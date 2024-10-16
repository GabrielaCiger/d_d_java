package displayutils;
/**
 *
 * Class containing a method to be able to clear the console.
 * @deprecated This class is not used, because it doesn't work on the Windows console. Needs to be changed.
 */
public class ConsoleUtils {
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void clearConsoleCommand() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        clearConsole();
    }
}

