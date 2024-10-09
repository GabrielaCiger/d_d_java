import Board.PlayerOutOfBoardException;
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

    public void startMenu() {
        boolean running = true;
        while (running) {
            int choiceMenu = menu.displayMenu();
            switch (choiceMenu) {
                case 1: /* ! Story mode */
                    menu.intro();
                    personnage = getPlayerInput();
                    menu.outro(personnage);
                    startGame(personnage, menu);
                    break;
                case 2: /* ? Fast mode */
                    personnage = getPlayerInput();
                    System.out.println(personnage.showPlayerStats());
                    startGame(personnage, menu);
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
            if (personnage.death("an enemy")){
                playerDiedChoices(menu.playerDied(personnage));
            }
        } while (!gameOver);
        menu.gameEnd(personnage);
    }

    public void startGame(Personnage personnage, Menu menu) {
        boolean start = menu.validateContinue(personnage.getName());
        if (start || personnage != null) {
            playGame();
        }
    }

    public boolean gameRound(Board board) {
        int diceThrow = board.throwDice();
        menu.showThrow(diceThrow);

        int initialPosition = board.getPlayerPosition();
        board.movePlayer(diceThrow);
        int nextPosition = board.getPlayerPosition();

        menu.showPlayerMovement(initialPosition, nextPosition);

        playerOutsideTheBoardException(board, initialPosition);
        return board.getPlayerPosition() == board.getBoardSize();
    }

    public void playerOutsideTheBoardException(Board board, int initialPosition) {
        try {
            if (board.getPlayerPosition() > board.getBoardSize()) {
                board.setPlayerPosition(initialPosition);
                throw new PlayerOutOfBoardException("[Attention : You went too far. You must return to the last known place.");
            }
        } catch (PlayerOutOfBoardException e) {
            System.out.println(e.getMessage());
            System.out.println("[Info : You went back to the position " + initialPosition +".]");
        }
    }

   public void playerDiedChoices(int choice) {
        if (choice==3){
            Personnage savedSettings;
            if (personnage.getType().equals("wizard")) {
                savedSettings = new Wizard(personnage.getName());
            } else {
                savedSettings = new Warrior(personnage.getName());
            }
            this.personnage = savedSettings;
            startGame(personnage, menu);
        }
        startMenu();
   }
}
