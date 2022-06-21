package run;

import inGameInteractions.CombatLogic;
import model.characters.Character;
import model.characters.Knight;
import model.enemies.Enemy;
import model.enemies.Skeleton;
import model.rooms.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class RunGame {
    public static void main(String[] args) {

        Character player = null;
        Enemy enemy = null;
        CombatLogic gameAction = new CombatLogic();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            System.out.println("Welcome to Newtopia's ancient Dungeon, what will your choise be? (0: Turn around and run away, 1 Jump into action!)");
            switch (scanner.next()) {
                case "0":
                    System.out.println("Such a coward . . .");
                    exit = true;
                    break;

                case "1":
                    System.out.println("I knew you had it in you, i've seen it in your eyes" +
                            ", now now . . . tell me about yourself (Choose a class: 0 Knight, 1 Mage, 2 Thief, 3 Priest)");
                    switch (scanner.next()) {
                        case "0":
                            player = new Knight();
                            break;

                        default:
                            System.out.println("Really?!");
                            break;
                    }
                    System.out.println("Name your character");
                    String playerName = scanner.next();
                    player.setName(playerName);
                    System.out.println("The developer decided to make you fight Skelly");
                    enemy = new Skeleton();
                    boolean runAway = false;
                    while (!runAway) {
                        if (!player.isAlive()) {
                            System.out.println("The enemies drag your lifeless body out of the dungeon . . .");
                            runAway = true;

                        } else if (!enemy.isAlive()) {
                            System.out.println("You killed " + enemy.getName() + " and moved on to the next room");
                            runAway = true;
                        } else {
                            System.out.println("what are you gonna do: 0 run away, 1 attack, 2 defend");
                        }
                        switch (scanner.next()) {

                            case "1":
                                gameAction.doAttack(player, enemy);
                                break;

                            case "2":
                                gameAction.doDefendPlayer(player, enemy);
                                break;

                            case "0":
                                runAway = true;
                                break;
                        }
                    }

                    break;

                default:
                    System.out.println("Don't even bother trying");
                    break;
            }
        }
    }
}

