package board;
import equipement.defensif.Potion;
import equipement.defensif.Shield;
import equipement.offensif.Spell;
import equipement.offensif.Weapon;
import personnages.*;
import menu.Menu;
import personnages.enemies.Dragon;
import personnages.enemies.EvilMage;
import personnages.enemies.Goblin;
import static displayutils.Colors.*;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
    int boardSize = 64;
    Menu menu;
    Personnage personnage;
    int playerPosition = 1;

    ArrayList<Case> boardCases = new ArrayList<>();

    public Board(Personnage personnage, Menu menu) {
        this.personnage = personnage;
        this.menu = menu;
        populateBoard();
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public int getPlayerPosition() {
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
    }

    public void populateBoard() {
        BasicCase basicCase = new BasicCase(menu);
        addSpecialCases();
        while (boardCases.size() < boardSize) {
            boardCases.add(basicCase);
        }
        Collections.shuffle(boardCases);
    }

    public void addSpecialCases(){
        boardCases.add(new Goblin(menu));
        boardCases.add(new Goblin(menu));
        boardCases.add(new Goblin(menu));
        boardCases.add(new Goblin(menu));
        boardCases.add(new EvilMage(menu));
        boardCases.add(new EvilMage(menu));
        boardCases.add(new EvilMage(menu));
        boardCases.add(new EvilMage(menu));
        boardCases.add(new Dragon(menu));
        boardCases.add(new Dragon(menu));
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

    public void doCaseAction(int playerPosition) {
        if (playerPosition >= boardSize) {
            return;
        }
        Case currentCase = boardCases.get(playerPosition);
        System.out.println("Current case value: " + ANSI_YELLOW + currentCase.getValue() + ANSI_RESET);
        currentCase.doAction(personnage);
    }
}
