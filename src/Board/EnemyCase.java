package Board;
import Personnages.Personnage;

import java.util.Scanner;

public class EnemyCase implements Case {
    protected Personnage enemy;

    public EnemyCase(Personnage setEnemyType) {
        this.enemy = setEnemyType;
    }

    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public void doAction(Personnage personnage) {
        System.out.println("[You encountered an enemy.]");
        System.out.println("[You see a chest, barely touched by a fire. Do you want to open it?]");
    }

    public Integer showChoices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[What do you want to do?]");
        System.out.println("1 < Attack the goblin (start the fight).");
        System.out.println("2 < Run away (go back).");
        return sc.nextInt();
    }

    public void showEnemy(){

    }
}

