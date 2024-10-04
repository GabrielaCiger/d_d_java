import java.util.Scanner;

public class Game {
    Menu menu;
    Personnage personnage;
    Board board;

    public Game() {
        menu = new Menu();

        int choiceMenu = menu.displayMenu();
        switch (choiceMenu) {
            case 1:
                menu.intro();
                personnage = getPlayerInput();
                menu.outro(personnage);
                break;
            case 2:
                personnage = getPlayerInput();
                break;
            case 3:
                menu.quitGame(personnage.name);
                break;
            default:
                menu.quitGame(personnage.name);
        }
        ;
        boolean start = menu.startGame(personnage.name);
        if (start) {
            playGame();
        }
    }

    private Personnage getPlayerInput() {
        String name;
        String type;
        boolean confirmed;
        do {
            name = menu.getPlayerName();
            type = menu.getPlayerType(name);
            confirmed = menu.validateChoices();
        } while (!confirmed);
        return createPersonnage(name, type);
    }

    public Personnage createPersonnage(String name, String type) {
        return new Personnage(name, type);
    }

    public void playGame() {
        board = new Board(personnage);
        do {
            gameRound(board);
        } while (!gameRound(board));
    }

    public boolean gameRound(Board board) {
        int diceThrow = board.throwDice();
        menu.showThrow(diceThrow);

        System.out.println("pos before : " + board.playerPosition);

        board.movePlayer(diceThrow);

        System.out.println("pos after : " + board.playerPosition);
        return board.playerPosition > board.boardSize;
    }
}
