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
    int boardSize;
    Menu menu;
    Personnage personnage;
    int playerPosition = 1;
    ArrayList<Case> boardCases;

    public Board(Personnage personnage, Menu menu) {
        this.boardSize = 64;
        this.personnage = personnage;
        this.menu = menu;
        this.boardCases = new ArrayList<>();
        populateBoard();
    }

    /* * GETTERS & SETTERS */

    public int getBoardSize() {
        return this.boardSize;
    }

    public int getPlayerPosition() {
        return this.playerPosition;
    }

    public void setPlayerPosition(Integer newPlayerPosition) {
        this.playerPosition = newPlayerPosition;
    }

    /**
     * Throw dice function.
     * @return Random number between 1 and 6.
     */
    public int throwDice() {
        return (int)(Math.random() * 6 + 1);
    }

    /**
     * Updates player's position.
     * @param diceValue Value of the dice.
     * @see #throwDice();
     */
    public void movePlayer(int diceValue) {
        playerPosition += diceValue;
    }
    /**
     * Adds cases to the board - special and basic. Order of the cases is shuffled.
     * Length of the board is set as boardSize in the constructor, default value: 64.
     * @see #addSpecialCases();
     * @see BasicCase;
     */
    public void populateBoard() {
        BasicCase basicCase = new BasicCase(menu);
        addSpecialCases();
        while (boardCases.size() < boardSize) {
            boardCases.add(basicCase);
        }
        Collections.shuffle(boardCases);
    }
    /**
     * Adds special cases to the board. Adds one rare bonus chest with the key object.
     * @see Key;
     * @see #goblinMageCases(int);
     * @see #dragonCases(int);
     * @see #nymphCases(int);
     * @see #healingItems();
     * @see #warriorEquipmentCases();
     * @see #wizardEquipmentCases();
     */
    private void addSpecialCases(){
        goblinMageCases(5);
        dragonCases(4);
        nymphCases(5);
        warriorEquipmentCases();
        wizardEquipmentCases();
        healingItems();
        boardCases.add(new Key());
    }

    /**
     * Adds pairs of goblin and mage objects to the board in a loop.
     * @param number The number of iterations, where each iteration adds one goblin and one mage to the board.
     * @see Goblin;
     * @see EvilMage;
     */
    private void goblinMageCases(int number) {
        for (int i = 0; i < number; i++) {
            boardCases.add(new Goblin());
            boardCases.add(new EvilMage());
        }
    }
    /**
     * Adds a dragon object to the board in a loop.
     * @param number The number of iterations, where each iteration adds one dragon to the board.
     * @see Dragon;
     */
    private void dragonCases(int number) {
        for (int i = 0; i < number; i++) {
            boardCases.add(new Dragon());
        }
    }

    /**
     * Adds a nymph object to the board in a loop.
     * @param number The number of iterations, where each iteration adds one nymph to the board.
     * @see Nymph;
     */
    private void nymphCases(int number) {
        for (int i = 0; i < number; i++) {
            boardCases.add(new Nymph());
        }
    }

    /**
     * Adds healing objects to the board. Creates healing items with the specified name and healing value.
     * @see HealingItem;
     */
    private void healingItems(){
        boardCases.add(new HealingItem("Red apple", 1));
        boardCases.add(new HealingItem("Green apple", 1));
        boardCases.add(new HealingItem("Memberberry jam", 1));
        boardCases.add(new HealingItem("Herbal tea", 2));
        boardCases.add(new HealingItem("Elven bandage", 3));
        boardCases.add(new HealingItem("Honeycomb Elixir", 4));
        boardCases.add(new HealingItem("Bottle of live water", 5));
    }

    /**
     * Adds weapon and shield objects to the board. Creates weapons/shields with the specified name and attack/defense value.
     * Weapon/Shield objects could be assigned only to Warrior characters.
     * @see Weapon;
     * @see Shield;
     * @see personnages.heroes.Warrior;
     */
    private void warriorEquipmentCases() {
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

    /**
     * Adds spell and potion objects to the board. Creates spells/potions with the specified name and attack/defense value.
     * Spell/Potion objects could be assigned only to Wizard characters.
     * @see Spell;
     * @see Potion;
     * @see personnages.heroes.Wizard;
     */
    private void wizardEquipmentCases(){
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

    /**
     * Manages case interaction between player and the case type. Interaction is triggered by matching the player's and case's position.
     * Calls the doAction of the object (implementing Case interface).
     * @see Case;
     * @param playerPosition Updated player's position. Called in the Game class.
     */
    public void doCaseAction(int playerPosition) {
        if (playerPosition >= boardSize) {
            return;
        }
        Case currentCase = boardCases.get(playerPosition);
        System.out.println("Current case value: " + ANSI_YELLOW + currentCase.getValue() + ANSI_RESET);
        currentCase.doAction(personnage);
    }
}
