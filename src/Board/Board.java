package Board;

import Personnages.Personnage;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int boardSize = 64;
    Personnage personnage;
    int playerPosition = 1;

    ArrayList<Case> boardCases = new ArrayList<>();

    public Board(Personnage personnage) {
        this.personnage = personnage;
        populateBoard();
    }

    public Integer getBoardSize() {
        return this.boardSize;
    }

    public Integer getPlayerPosition() {
        return this.playerPosition;
    }

    public void setPlayerPosition(Integer newPlayerPosition) {
        this.playerPosition = newPlayerPosition;
    }

    public int throwDice() {
        return (int)(Math.random() * 6 + 1);
    }

    public void movePlayer(int diceValue) {
        playerPosition += diceValue;
        if (playerPosition >= boardSize) {
            return;
        }
        Case currentCase = boardCases.get(playerPosition);
        System.out.println("Current case value: " + currentCase.getValue());
        currentCase.doAction(personnage);
    }

    public int getRandomPosition() {
        return (int)(Math.random() * boardSize + 1);
    }

    public void populateBoard() {
        BasicCase basicCase = new BasicCase();
        for (int i = 0; i < boardSize; i++) {
            boardCases.add(i, basicCase);
        }
        List<Integer> specialCases = new ArrayList<Integer>();
        for (int j = 0; j < 2; j++) {
            addSpecialCase(new BonusCase(), specialCases);
            addSpecialCase(new BonusDefenseCase(), specialCases);
        }
    }

    public void addSpecialCase(Case specialCase, List<Integer> alreadyPopulated) {
        int position;
        do {
            position = getRandomPosition();
        } while (alreadyPopulated.contains(position) || position >= boardSize);
        alreadyPopulated.add(position);
        boardCases.set(position, specialCase);
    }
}
