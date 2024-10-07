package Board;

import Personnages.Personnage;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int boardSize = 64;
    Personnage personnage;
    int playerPosition = 1;

    ArrayList<String> boardCases = new ArrayList<>();

    public Board(Personnage personnage) {
        this.personnage = personnage;
        populateBoard();
    }

    public Integer getBoardSize() {
        return boardSize;
    }

    public Integer getPlayerPosition() {
        return playerPosition;
    }

    public int throwDice() {
        return (int)(Math.random() * 6 + 1);
    }

    public void movePlayer(int diceValue) {
        playerPosition += diceValue;
        if (playerPosition >= boardSize) {
            System.out.println("Game ends.");
            return;
        }
        String currentCase = boardCases.get(playerPosition);
        System.out.println("Current case value: " + currentCase);
    }

    public int getRandomPosition() {
        return (int)(Math.random() * boardSize + 1);
    }

    public void populateBoard() {
        for (int i = 0; i < boardSize; i++) {
            boardCases.add(i, "Nothing special");
        }
        List<Integer> specialCases = new ArrayList<Integer>();
        addSpecialCase("Goblin", specialCases);
        addSpecialCase("Dragon", specialCases);
        addSpecialCase("Evil mage", specialCases);
        addSpecialCase("Tower", specialCases);
        addSpecialCase("Market", specialCases);
    }

    public void addSpecialCase(String specialCase, List alreadyPopulated) {
        int position;
        do {
            position = getRandomPosition();
        } while (alreadyPopulated.contains(position));
        alreadyPopulated.add(position);
        boardCases.add(position, specialCase);
    }
}
