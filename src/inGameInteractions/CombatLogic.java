package inGameInteractions;

import model.characters.Character;
import model.enemies.Enemy;

public class CombatLogic {

    public void doAttack(Character character, Enemy enemy) {
        long playerDmg = character.setDamageOutput();
        long enemyDmg = enemy.setDamageOutput();
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

    public void doDefendPlayer(Character character, Enemy enemy){

        long shield = character.doDefend();
        long enemyDmg = enemy.setDamageOutput();
        if (character.getHealt() - (enemyDmg - shield) <= 0){
            System.out.println(enemy.getName() + " has defeated you . . .");
            character.setHealt(0);
        } else if (enemy.getHealt() - (shield - enemyDmg) <= 0){
            System.out.println("You've defeated " + enemy.getName() + "!");
            enemy.setHealt(0);
        }
       else if (enemyDmg < shield){
            System.out.println(character.getName() + " defended for " + shield + " points of shield");
            enemy.setHealt(enemy.getHealt() - (shield - enemyDmg));
            System.out.println(enemy.getName() + " attacked for " + enemyDmg + " points of damage and lost " + (shield - enemyDmg) + "HP, it now has " + enemy.getHealt() + "HP");
        } else if (enemyDmg == shield){
            System.out.println(character.getName() + " defended for " + shield + " points of shield");
            System.out.println(enemy.getName() + " attacked for " + enemyDmg + " points of damage");
            System.out.println("Attack impeccably blocked!");
        } else {
            System.out.println(character.getName() + " defended for " + shield + " points of shield");
            System.out.println(enemy.getName() + " attacked for " + enemyDmg + " points of damage");
            character.setHealt(character.getHealt() - (enemyDmg - shield));
            System.out.println(character.getName() + " lost " + (enemyDmg - shield) + "HP and now has " + character.getHealt() + "HP");
        }
    }
}

/*Se muori si ricomincia dal livello 1
* * primo piano shop prima del boss
* item pool per ogni tipo di personaggio
* oggetti consumabili e passivi
* endless run
* energia per turno
* miniboss a scelta generati in stanze causali(item pool unica)
* livello min-max a cui può stare ogni nemico (da usare in generateRoom)*/