package inGameInteractions;

import model.characters.Character;
import model.characters.Knight;
import model.characters.Mage;
import model.enemies.Enemy;
import model.enemies.Witch;

import java.util.ArrayList;
import java.util.Collection;

public class CombatLogic {

    private int durataStatus = 0;

    public final int DOT_DMG = 4;

    public int getDurataStatus() {
        return durataStatus;
    }

    public void setDurataStatus(int durataStatus) {
        this.durataStatus = durataStatus;
    }

    public void doAttack(Character character, Enemy enemy) {
        long playerDmg = character.setDamageOutput();
        long enemyDmg = enemy.setDamageOutput();

        if (enemy instanceof Witch) {
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


    public void enemyDoAttack(Enemy enemy, Character character) {
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

    public void doDot(Character character) {
        character.setHealt(character.getHealt() - DOT_DMG);
    }

    public void applyStatus(Character character, int durata) {
        durataStatus = durata;
        character.setHasStatus(true);
    }

    public boolean doSpecialAbility(Character character, Enemy enemy) {
        if (!character.getHasUsedSA()) {
            if (character instanceof Knight) {
                long dmgOutput = character.doSpecialAbility();
                if (dmgOutput >= enemy.getHealt()) {
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
            } else if (character instanceof Mage){
                int scelta = character.doSpecialAbility();
                switch (scelta){
                    case 0:
                        long dmgOutputFire = 20;
                        if (dmgOutputFire >= enemy.getHealt()){
                            System.out.println(character.getName() + " casted a Fireball against " + enemy.getName() + " for " + dmgOutputFire + " points of damage");
                            System.out.println("You've defeated " + enemy.getName() + "!");
                            enemy.setHealt(0);
                            return true;
                        }  else if (dmgOutputFire < enemy.getHealt()) {
                            enemy.setHealt(enemy.getHealt() - dmgOutputFire);
                            System.out.println(character.getName() + " casted a Fireball against " + enemy.getName() + " for 20 points of damage, it now has " + enemy.getHealt() + "HP");
                            System.out.println("Your special ability needs to recharge, wait until the next fight . . .");
                        }
                        break;

                    case 1:
                        long dmgOutputFrost = 25;
                        if (dmgOutputFrost >= enemy.getHealt()){
                            System.out.println(character.getName() + " casted a Frostball against " + enemy.getName() + " for " + dmgOutputFrost + " points of damage");
                            System.out.println("You've defeated " + enemy.getName() + "!");
                            enemy.setHealt(0);
                            return true;
                        }  else if (dmgOutputFrost < enemy.getHealt()) {
                            enemy.setHealt(enemy.getHealt() - dmgOutputFrost);
                            System.out.println(character.getName() + " casted a Frostball against " + enemy.getName() + " for 25 points of damage, it now has " + enemy.getHealt() + "HP");
                            System.out.println("Your special ability needs to recharge, wait until the next fight . . .");
                        }
                        break;
                }
            }

        } else {
            return false;
        }
        return false;
    }
}
