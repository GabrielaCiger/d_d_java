import Board.Board;
import Personnages.Personnage;

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
                menu.quitGame(personnage.getName());
                break;
            default:
                System.out.println("Invalid choice. Goodbye.");
                menu.quitGame(personnage.getName());
        }
        ;
        boolean start = menu.startGame(personnage.getName());
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

        System.out.println("pos before : " + board.getPlayerPosition());

        board.movePlayer(diceThrow);

        System.out.println("pos after : " + board.getPlayerPosition());
        return board.getPlayerPosition() > board.getBoardSize();
    }
}
