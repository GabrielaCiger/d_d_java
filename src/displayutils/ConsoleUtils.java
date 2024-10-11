package displayutils;

public class ConsoleUtils {
    public static void clearConsole() {
        try {
            // Check if the operating system is Windows
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                // Use the "cls" command for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Use the "clear" command for Unix/Linux systems
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

