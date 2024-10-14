package board;
import equipement.HealingItem;
import equipement.Key;
import equipement.defensif.*;
import equipement.offensif.*;
import personnages.*;
import menu.Menu;
import personnages.enemies.*;
import static displayutils.Colors.*;
import java.util.ArrayList;
import java.util.Collections;

public class Board {
    int boardSize = 64;
    Menu menu;
    Personnage personnage;
    int playerPosition = 1;
    ArrayList<Case> boardCases;

    public Board(Personnage personnage, Menu menu) {
        this.personnage = personnage;
        this.menu = menu;
        this.boardCases = new ArrayList<>();
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
        goblinMageCases(5);
        dragonCases(4);
        nymphCases(5);
        warriorEquipmentCases();
        wizardEquipmentCases();
        healingItems();
        boardCases.add(new Key());
    }
    public void goblinMageCases(int number) {
        for (int i = 0; i < number; i++) {
            boardCases.add(new Goblin());
            boardCases.add(new EvilMage());
        }
    }
    public void dragonCases(int number) {
        for (int i = 0; i < number; i++) {
            boardCases.add(new Dragon());
        }
    }
    public void nymphCases(int number) {
        for (int i = 0; i < number; i++) {
            boardCases.add(new Nymph());
        }
    }

    public void healingItems(){
        boardCases.add(new HealingItem("Red apple", 1));
        boardCases.add(new HealingItem("Green apple", 1));
        boardCases.add(new HealingItem("Memberberry jam", 1));
        boardCases.add(new HealingItem("Herbal tea", 2));
        boardCases.add(new HealingItem("Elven bandage", 3));
        boardCases.add(new HealingItem("Honeycomb Elixir", 4));
        boardCases.add(new HealingItem("Bottle of live water", 5));
    }

    public void warriorEquipmentCases() {
        boardCases.add(new Weapon("The Spoon of Doom", 1));
        boardCases.add(new Weapon("Swordfish", 2));
        boardCases.add(new Weapon("Iron sword", 5));
        boardCases.add(new Weapon("Diamond sword", 7));
        boardCases.add(new Weapon("Dragonslayer", 10));

        boardCases.add(new Shield("Adam's clothes", 1));
        boardCases.add(new Shield("Silky pyjama", 2));
        boardCases.add(new Shield("Iron shield", 3));
        boardCases.add(new Shield("Knight's armor", 5));
        boardCases.add(new Shield("Shield of the Archangel", 7));
    }

    public void wizardEquipmentCases(){
        boardCases.add(new Spell("Glitter Bomb", 1));
        boardCases.add(new Spell("Null Pointer Exception Spell", 2));
        boardCases.add(new Spell("Windblow", 4));
        boardCases.add(new Spell("Frostbite", 5));
        boardCases.add(new Spell("Earthquake", 6));

        boardCases.add(new Potion("Gin tonic", 2));
        boardCases.add(new Potion("Telepathy potion", 3));
        boardCases.add(new Potion( "Invisibility potion", 4));
        boardCases.add(new Potion("Celestial Brew", 5));
        boardCases.add(new Potion("Elixir of Near-Immortality", 6));
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
