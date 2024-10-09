package Personnages;
import Board.Case;
import Equipement.Shield;
import Equipement.Weapon;
import java.util.Scanner;

public class Goblin extends Personnage implements Case {
    protected boolean isDead = false;

    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public void doAction(Personnage personnage) {
        Goblin goblin = new Goblin();
        System.out.println("[You encountered a goblin!]");
        System.out.println("[He's even more hideous than the folks in the tavern described him to be.]");

        System.out.print("                #@@@@@@@@@@@@=             \n" +
                "         =##=  @@%           :@@:  =##=     \n" +
                "        @@--#@@@-       @ .@=  @@@@#--@@    \n" +
                "        *@=   @@               -@*   +@+    \n" +
                "         @@   @@          ==   -@+ .@@*     \n" +
                "         +@+  @@  \\         /  =@+ *@+      \n" +
                "          @@  @@  *@@@: .@@@  =@+ @@        \n" +
                "          :@@-@@     -@+       +@#-@@       \n" +
                "            +@@@     -@+       @@@@+        \n" +
                "               @@    -@**@    +@*           \n" +
                "                @@.   #@@-   @@#            \n" +
                "                 +@@       #@@              \n" +
                "                   @@@:  +@@:               \n" +
                "                     +@@@#:                 \n");
        applyChoice(showChoices(), personnage, goblin);
    }

    public Integer showChoices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("`\n[What do you want to do?]");
        if (!this.isDead) {
            System.out.println("1 < Attack the goblin.");
        } else {
            System.out.println("1 < Approach the goblin's body. ");
        }
        System.out.println("2 < Turn away.");
        return sc.nextInt();
    }

    public void applyChoice(int choice, Personnage personnage, Goblin goblin) {
        if (choice == 1) {
            if (!this.isDead) {
                System.out.println(showPlayerStats()+"\n");
                System.out.println("[You attack the goblin (" + personnage.countAttackPower() + " damage) ]");
                personnage.doAttack(goblin);
                if (!goblin.death(personnage.getName())){
                    System.out.println("[Goblin attacked you. (-" + countAttackPower() + " HP) ]");
                    doAttack(personnage);
                } else {
                    death(personnage.getName());
                    this.isDead = true;
                }
            } else {
                System.out.println("[You're disgusted by the dead body of the goblin.]");
            }
        } else {
            System.out.println("[You turned away from the goblin.]");
        }
    }

    public Goblin() {
        super("Goblin", "enemy");
        this.attackStrength = 2;
        this.life = 20;
        this.equipmentOffensive = new Weapon("Wooden sword", 1);
        this.equipmentDefensif = new Shield("Leather armor", 0);
    }
}
