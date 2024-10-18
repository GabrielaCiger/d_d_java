import board.PlayerOutOfBoardException;
import board.Board;
import database.GameDatabase;
import menu.GameOptions;
import menu.Menu;
import menu.MenuOptions;
import menu.Story;
import personnages.Personnage;
import personnages.heroes.Warrior;
import personnages.heroes.Wizard;

import java.util.List;

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

    /**
     * Displays the main game menu and processes user choices to start or continue a game.
     */
    public void gameMenu() {
        boolean running = true;
        while (running) {
            int choiceMenu = menu.displayMenu();
            MenuOptions selectedOption = MenuOptions.fromValue(choiceMenu);

            switch (selectedOption) {
                case START_GAME_WITH_INTRO:
                    clearConsoleCommand();
                    story.intro();
                    personnage = getPlayerInput();
                    story.outro(personnage);
                    clearConsoleCommand();
                    playGame();
                    break;
                case START_GAME_WITHOUT_INTRO:
                    personnage = getPlayerInput();
                    clearConsoleCommand();
                    playGame();
                    break;
                case SHOW_SAVED_CHARACTERS_DB:
                    showSavedCharacters();
                    break;
                case QUIT_GAME:
                    running = !menu.quitGame("");
                    break;
            }
        }
    }

    /**
     * Prompts the user for player name and type, validates their choices,
     * and returns a newly created Personnage object.
     */
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

    /**
     * Creates a new Personnage based on the specified type.
     *
     * @param name the name of the personnage
     * @param type the type of the personnage, either "wizard" or "warrior"
     * @return a new Personnage instance of the specified type
     */
    public Personnage createPersonnage(String name, String type) {
        if (type.equals("wizard")) {
            Wizard newWizard = new Wizard(name);
            GameDatabase.createHero(newWizard);
            return newWizard;
        }
        Warrior newWarrior = new Warrior(name);
        GameDatabase.createHero(newWarrior);
        return newWarrior;
    }

    /**
     * Starts the game and manages the game rounds until completion.
     * It initializes the game board and continuously runs rounds until the game is over,
     * then displays the end story for the personnage.
     */
    public void playGame() {
        this.board = new Board(personnage, menu);
        boolean gameOver = false;
        while (!gameOver) {
            clearConsoleCommand();
            gameOver = gameRound();
        }
        clearConsoleCommand();
        personnage.setWonGame(1);
        System.out.println(GameDatabase.changePlayerSavedData(personnage));
        story.gameEnd(personnage);
    }

    /**
     * Executes a player's action during their turn, including throwing the dice,
     * moving the player, and performing actions based on the new position on the board.
     * Checks for player death and handles any exceptions for moving outside the board.
     *
     * @param board The game board on which the player is acting.
     * @return true if the player reaches the end of the board; false otherwise.
     */
    public boolean playerAction(Board board) {
        int diceThrow = board.throwDice();
        int initialPosition = board.getPlayerPosition();

        menu.throwDiceMessage();
        menu.showThrow(diceThrow);
        board.movePlayer(diceThrow);
        int nextPosition = board.getPlayerPosition();

        menu.showPlayerMovement(initialPosition, nextPosition);
        board.doCaseAction(nextPosition);

        if (personnage.getLife() < 1) {
            playerDiedChoices(story.playerDied(personnage));
        }

        playerOutsideTheBoardException(board, initialPosition, nextPosition);
        return board.getPlayerPosition() == board.getBoardSize();
    }

    /**
     * Executes a round of the game based on the player's choice,
     * allowing for player actions, displaying stats, or quitting the game.
     *
     * @return true if the game ends; false otherwise.
     */
    private boolean gameRound() {
        int choice = menu.newRound();
        GameOptions selectedOption = GameOptions.fromValue(choice);
        switch (selectedOption) {
            case ROLL_DICE:
                return playerAction(board);
            case SHOW_STATS:
                System.out.println(personnage.showPlayerStats());
                break;
            case SAVE_CHARACTER:
                System.out.println(GameDatabase.changePlayerSavedData(personnage));
                break;
            case QUIT_GAME:
                System.out.println("[Is this adventure going to end?]");
                boolean quit = menu.quitGame(personnage.getName());
                return quit;
            default:
                System.out.println("Invalid choice, please try again.");
                break;
        }
        return false;
    }

    /**
     * Handles the player's choices after dying, including the option to
     * restart the game with the same character type and name or return
     * to the main game menu.
     *
     * @param choice an integer representing the player's choice after death.
     */
    public void playerDiedChoices(int choice) {
        GameOptions selectedOption = GameOptions.fromValue(choice);
        if (selectedOption == GameOptions.REPLAY_GAME) {
            Personnage savedSettings;
            if (personnage instanceof Wizard) {
                savedSettings = new Wizard(personnage.getName());
            } else {
                savedSettings = new Warrior(personnage.getName());
            }
            this.personnage = savedSettings;
            playGame();
        }
        gameMenu();
    }

    /**
     * Checks if the player's position exceeds the board's boundaries. If so,
     * resets the player's position to the last known position and throws a
     * PlayerOutOfBoardException, which is caught and handled to inform the
     * player of the error.
     *
     * @param board           the game board that contains the player's current position.
     * @param initialPosition the player's last known valid position.
     * @param nextPosition    the player's attempted new position.
     * @throws PlayerOutOfBoardException;
     */
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

    public void showSavedCharacters() {
        GameDatabase.getHeroes();
        List<Personnage> heroes = GameDatabase.getHeroes();
        menu.headerTable();
        int i = 1;
        for (Personnage hero : heroes) {
            menu.showSavedCharactersTable(hero, i);
            i++;
        }
    }

}
