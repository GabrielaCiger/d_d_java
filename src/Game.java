import board.PlayerOutOfBoardException;
import board.Board;
import menu.Menu;
import menu.Story;
import personnages.Personnage;
import personnages.heroes.Warrior;
import personnages.heroes.Wizard;

import static displayutils.ConsoleUtils.clearConsoleCommand;

public class Game {
    Menu menu;
    Story story;
    Personnage personnage;
    Board board;

    public Game() {
        this.menu = new Menu();
        this.story = new Story();
    }

    public void gameMenu() {
        boolean running = true;
        while (running) {
            int choiceMenu = menu.displayMenu();
            switch (choiceMenu) {
                case 1:
                    clearConsoleCommand();
                    story.intro();
                    personnage = getPlayerInput();
                    story.outro(personnage);
                    clearConsoleCommand();
                    playGame();
                    break;
                case 2:
                    personnage = getPlayerInput();
                    clearConsoleCommand();
                    playGame();
                    break;
                default:
                    running = !menu.quitGame("");
                    break;
            }
        }
    }

    private Personnage getPlayerInput() {
        String name;
        String type;
        boolean confirmed;
        name = menu.getPlayerName();
        type = menu.getPlayerType();
        do {
            menu.showPlayerCreation(name, type);
            confirmed = menu.validateChoices();
            if (!confirmed) {
                clearConsoleCommand();
                String[] updatedValues = menu.changePlayerSettings(menu.changePlayer(), name, type);
                name = updatedValues[0];
                type = updatedValues[1];
            }
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
        this.board = new Board(personnage, menu);
        boolean gameOver = false;
        while (!gameOver) {
            clearConsoleCommand();
            gameOver = gameRound();
        }
        clearConsoleCommand();
        story.gameEnd(personnage);
    }

    public boolean playerAction(Board board) {
        int diceThrow = board.throwDice();
        int initialPosition = board.getPlayerPosition();

        menu.showThrow(diceThrow);
        board.movePlayer(diceThrow);
        int nextPosition = board.getPlayerPosition();

        menu.showPlayerMovement(initialPosition, nextPosition);
        board.doCaseAction(nextPosition);

        playerOutsideTheBoardException(board, initialPosition, nextPosition);
        return board.getPlayerPosition() == board.getBoardSize();
    }

    public boolean gameRound() {
        int choice = menu.newRound();
        switch (choice) {
            case 1:
                return playerAction(board);
            case 2:
                System.out.println(personnage.showPlayerStats());
                break;
            case 3:
                System.out.println("[Is this adventure going to end?]");
                boolean quit = menu.quitGame(personnage.getName());
                return quit;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
        if (personnage.getLife() < 1) {
            playerDiedChoices(story.playerDied(personnage));
        }
        return false;
    }

    public void playerDiedChoices(int choice) {
        if (choice == 3) {
            Personnage savedSettings;
            if (personnage.getType().equals("wizard")) {
                savedSettings = new Wizard(personnage.getName());
            } else {
                savedSettings = new Warrior(personnage.getName());
            }
            this.personnage = savedSettings;
            playGame();
        }
        gameMenu();
    }

    public void playerOutsideTheBoardException(Board board, int initialPosition, int nextPosition) {
        try {
            if (board.getPlayerPosition() > board.getBoardSize()) {
                board.setPlayerPosition(initialPosition);
                menu.showPlayerMovement(nextPosition, initialPosition);
                throw new PlayerOutOfBoardException("[Attention : You went too far. You must return to the last known place.");
            }
        } catch (PlayerOutOfBoardException e) {
            System.out.println(e.getMessage());
            System.out.println("[Info : You went back to the position " + initialPosition + ".]");
        }
    }

}
