package Personnages;

import Board.Case;
import Equipement.Potion;
import Equipement.Shield;
import Equipement.Spell;
import Equipement.Weapon;

import java.util.Scanner;

public class EvilMage extends Personnage implements Case {
    protected boolean isDead = false;

    @Override
    public String getValue() {
        return "Enemy case";
    }

    @Override
    public void doAction(Personnage personnage) {
        EvilMage goblin = new EvilMage();
        System.out.println("[You encountered an evil mage!]");
        System.out.println("[He gazes at you with an unsettling intensity, his eyes gleaming like cold steel in the dim light.]");

        System.out.print(
                "                 =++++-              \n" +
                        "              :%        @           \n" +
                        "             .#      =@  *-         \n" +
                        "             %        @ @#+         \n" +
                        "            -=        :#            \n" +
                        "            @          %            \n" +
                        "          *@@%%%@**#@%%@@%          \n" +
                        "        :+@::  @=::-@-:::*#:.       \n" +
                        "      @    %            @    #:     \n" +
                        "      @ **=.             =+@ %.     \n" +
                        "        *##:#:         % @*%        \n" +
                        "          @ =%***%@***%# @           \n" +
                        "          %  +#=*#=%=*%  @           \n" +
                        "           %             #           \n" +
                        "           =+                        \n" +
                        "            :#        -#            \n" +
                        "       -%%+.  %      *-  =#@+.      \n" +
                        "    -#         @    @.        -*    \n" +
                        "    @           @: @           *    \n"
        );
        applyChoice(showChoices(), personnage, goblin);
    }

    public Integer showChoices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("`\n[What do you want to do?]");
        if (!this.isDead) {
            System.out.println("1 < Attack the mage.");
        } else {
            System.out.println("1 < Approach the mage's ashes. ");
        }
        System.out.println("2 < Turn away.");
        return sc.nextInt();
    }

    public void applyChoice(int choice, Personnage personnage, EvilMage mage) {
        if (choice == 1) {
            if (!this.isDead) {
                System.out.println(showPlayerStats()+"\n");
                System.out.println("[You attack the mage (" + personnage.countAttackPower() + " damage) ]");
                personnage.doAttack(mage);
                if (!mage.death(personnage.getName())){
                    System.out.println("[Mage casted a spell. (-" + countAttackPower() + " HP) ]");
                    doAttack(personnage);
                } else {
                    death(personnage.getName());
                    this.isDead = true;
                }
            } else {
                System.out.println("[Mage's body turned to ashes after his death.]");
            }
        } else {
            System.out.println("[You turned away from the mage.]");
        }
    }

    public EvilMage() {
        super("Evil mage", "enemy");
        this.attackStrength = 10;
        this.life = 22;
        this.equipmentOffensive = new Spell("Cursed amulet", 2);
        this.equipmentDefensif = new Potion("Poison", 1);
    }
}
