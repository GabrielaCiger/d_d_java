package Board;

import Personnages.Personnage;

public class BasicCase implements Case {
protected String value;
    public BasicCase() {
        this.value = "Basic Case";}

    public BasicCase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void doAction(Personnage personnage) {
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


}
