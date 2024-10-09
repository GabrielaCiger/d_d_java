package Board;

import Equipement.Potion;
import Equipement.Shield;
import Equipement.Spell;
import Equipement.Weapon;
import Personnages.EvilMage;
import Personnages.Goblin;
import Personnages.Personnage;

import java.util.ArrayList;
import java.util.Collections;
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


    public void populateBoard() {
        BasicCase basicCase = new BasicCase();
        addSpecialCases();
        while (boardCases.size() < boardSize) {
            boardCases.add(basicCase);
        }
        Collections.shuffle(boardCases);
    }

    public void addSpecialCases(){
        boardCases.add(new Goblin());
        boardCases.add(new Goblin());
        boardCases.add(new Goblin());
        boardCases.add(new Goblin());
        boardCases.add(new EvilMage());
        boardCases.add(new EvilMage());
        boardCases.add(new Weapon("Iron sword", 5));
        boardCases.add(new Weapon("Diamond sword", 7));
        boardCases.add(new Weapon("Dragonslayer", 10));
        boardCases.add(new Spell("Windblow", 4));
        boardCases.add(new Spell("Earthblock", 5));
        boardCases.add(new Spell("Lavaboom", 6));
        boardCases.add(new Shield("Iron shield", 3));
        boardCases.add(new Shield("Knight's armor", 5));
        boardCases.add(new Potion("Telepathy potion", 3));
        boardCases.add(new Potion("Invisibility potion", 4));
    }
}
