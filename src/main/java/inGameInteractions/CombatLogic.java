package inGameInteractions;

import model.characters.Character;
import model.enemies.Enemy;
import model.enemies.Witch;

import java.util.ArrayList;
import java.util.Collection;

public class CombatLogic {

    private int durataStatus = 0;

    public final int DOT_DMG = 5;

    public int getDurataStatus() {
        return durataStatus;
    }

    public void setDurataStatus(int durataStatus) {
        this.durataStatus = durataStatus;
    }

    public void doAttack(Character character, Enemy enemy) {
        long playerDmg = character.setDamageOutput();
        long enemyDmg = enemy.setDamageOutput();

        if (enemy instanceof Witch)
        {
            if (!character.getHasStatus()) {
                applyStatus(character, 2);
                System.out.println(enemy.getName() + " has applyied a dot of " + DOT_DMG + " points of damage for " + durataStatus + "turns, good luck.");
            }
        }

        if (playerDmg >= enemy.getHealt()) {
            System.out.println(character.getName() + " attacked " + enemy.getName() + " for " + playerDmg + " points of damage");
            System.out.println("You've defeated " + enemy.getName() + "!");
            enemy.setHealt(0);

        } else if (enemyDmg >= character.getHealt()) {
            System.out.println(enemy.getName() + " attacked " + character.getName() + " for " + enemyDmg + " points of damage");
            System.out.println(enemy.getName() + " has defeated you . . .");
            character.setHealt(0);

        } else {

            System.out.println(character.getName() + " attacked " + enemy.getName() + " for " + playerDmg + " points of damage");
            enemy.setHealt(enemy.getHealt() - playerDmg);
            System.out.println(enemy.getName() + " healt is now " + enemy.getHealt() + " HP");
            System.out.println(enemy.getName() + " attacked " + character.getName() + " for " + enemyDmg + " points of damage");
            character.setHealt(character.getHealt() - enemyDmg);
            System.out.println(character.getName() + " healt is now " + character.getHealt() + "HP");
        }
    }


    public void enemyDoAttack(Enemy enemy, Character character){
        long enemyDmg = enemy.setDamageOutput();

        if (enemyDmg >= character.getHealt()) {
            System.out.println(enemy.getName() + " attacked " + character.getName() + " for " + enemyDmg + " points of damage");
            System.out.println(enemy.getName() + " has defeated you . . .");
            character.setHealt(0);

        } else {
        System.out.println(enemy.getName() + " attacked " + character.getName() + " for " + enemyDmg + " points of damage");
        character.setHealt(character.getHealt() - enemyDmg);
        System.out.println(character.getName() + " healt is now " + character.getHealt() + "HP");
        }
    }

    public void doDot(Character character){
        character.setHealt(character.getHealt() - DOT_DMG);
    }

    public void applyStatus(Character character, int durata){
        durataStatus = durata;
        character.setHasStatus(true);
    }

    public boolean doSpecialAbility(Character character, Enemy enemy){
        if (!character.getHasUsedSA()){
            long dmgOutput = character.doSpecialAbility(enemy);
            if (dmgOutput >= enemy.getHealt()){
                System.out.println(character.getName() + " attacked " + enemy.getName() + " for " + dmgOutput + " points of damage");
                System.out.println("You've defeated " + enemy.getName() + "!");
                enemy.setHealt(0);
                return true;
            } else if (dmgOutput < enemy.getHealt()) {
                enemy.setHealt(enemy.getHealt() - dmgOutput);
                System.out.println(character.getName() + " attacked " + enemy.getName() + " for " + dmgOutput + " points of damage");
                System.out.println(enemy.getName() + " now has " + enemy.getHealt() + "HP");
                System.out.println("Your special ability needs to recharge, wait until the next fight . . .");
                return true;
            }
        } else {
            return false;
        }
        return false;
    }
}
