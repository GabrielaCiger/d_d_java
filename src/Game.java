import Board.Board;
import Personnages.Personnage;
import Personnages.Warrior;
import Personnages.Wizard;

public class Game {
    Menu menu;
    Personnage personnage;
    Board board;

    public Game() {
        menu = new Menu();
    }

    public void startMenu(){
        boolean running = true;
        boolean start;

        /* * STARTING THE GAME - CHOICES FROM MENU */
        while (running) {
            int choiceMenu = menu.displayMenu();
            switch (choiceMenu) {
                case 1: /* ! Story mode */
                    menu.intro();
                    personnage = getPlayerInput();
                    menu.outro(personnage);
                    start = menu.validateContinue(personnage.getName());
                    if (start || personnage != null) {
                        playGame();
                    }
                    break;
                case 2: /* ! Fast mode */
                    personnage = getPlayerInput();
                    System.out.println(personnage.showPlayerStats());
                    start = menu.validateContinue(personnage.getName());
                    if (start || personnage != null) {
                        playGame();
                    }
                    break;
                default: /* * Quitting the game */
                    running = !menu.quitGame("");
                    break;
            }

        }
    }
    private Personnage getPlayerInput() {
        String name;
        String type;
        boolean confirmed;
        do {
            name = menu.getPlayerName();
            type = menu.getPlayerType();
            String[] updatedValues = menu.changePlayerSettings(menu.changePlayer(), name, type);
            name = updatedValues[0];
            type = updatedValues[1];
            confirmed = menu.validateChoices();
        } while (!confirmed);
        return createPersonnage(name, type);
    }

    public Personnage createPersonnage(String name, String type) {
        if (type.equals("wizard")) {
            return new Wizard(name);
        }
        return new Warrior(name);
    }

    public void playGame() {
        board = new Board(personnage);
        boolean gameOver = false;
        do {
            int choice = menu.newRound();
            if (choice == 1) {
                System.out.println("[You decided to throw the magic dice.]");
                gameOver = gameRound(board);
            } else if (choice == 2) {
                System.out.println(personnage.showPlayerStats());
            } else {
                System.out.println("[Is this adventure going to end?]");
                boolean quit = menu.quitGame(personnage.getName());
                if (quit) {
                    gameOver = true;
                }
            }
        } while (!gameOver);
        System.out.println("[You reached the Temple. What might it be guarding?]");
        System.out.println("[YOU WON!]");
    }

    public boolean gameRound(Board board) {
        int diceThrow = board.throwDice();
        menu.showThrow(diceThrow);

        int initialPosition = board.getPlayerPosition();
        System.out.println("pos before : " + initialPosition);

        board.movePlayer(diceThrow);

        int nextPosition = board.getPlayerPosition();
        System.out.println("pos after : " + nextPosition);

        try {
            if (board.getPlayerPosition() > board.getBoardSize()) {
                throw new IllegalArgumentException("[There's nothing ahead. Return back.]");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            board.setPlayerPosition(initialPosition);
            System.out.println("[You returned to the last known place (" + initialPosition + ")]");
        }

        return board.getPlayerPosition() == board.getBoardSize();
    }
}
