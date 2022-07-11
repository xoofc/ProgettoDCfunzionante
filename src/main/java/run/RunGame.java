package run;

import inGameInteractions.CombatLogic;
import model.characters.*;
import model.characters.Character;
import model.enemies.*;
import model.rooms.Dungeon;
import model.rooms.Floor;
import model.rooms.Room;
import java.util.Scanner;

public class RunGame {
    public static void main(String[] args) {

        Character player = null;
        Enemy enemy = null;
        CombatLogic gameAction = new CombatLogic();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Dungeon dungeon = new Dungeon();
        int nTurno = 1;
        boolean checkCharacterChoice = true;

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

                    while(checkCharacterChoice) {
                        switch (scanner.next()) {
                            case "0":
                                player = new Knight();
                                checkCharacterChoice = false;
                                break;

                            case "1":
                                player = new Mage();
                                checkCharacterChoice = false;
                                break;

                            case "2":
                                player = new Thief();
                                checkCharacterChoice = false;
                                break;

                            case "3":
                                player = new Priest();
                                checkCharacterChoice = false;
                                break;

                            default:
                                System.out.println("Really?!");
                                break;
                        }
                    }
                    System.out.println("Name your character");
                    String playerName = scanner.next();
                    player.setName(playerName);

                    //ArrayList<Enemy> allEnemies = new ArrayList<>();
                    // allEnemies.add(new Skeleton());
                    // allEnemies.add(new Slime());
                    //allEnemies.add(new Mugger());
                    //allEnemies.add(new Witch());

                    boolean runAway = false;
                    Room room = dungeon.generateRoom(player, dungeon.generateEnemiesList(dungeon.getFloor().getLevelFloor()));
                    boolean uplevel = false;
                    while (!runAway) {
                        if (room.getEnemies().isEmpty()) {
                            if(uplevel){
                                Floor.levelFloor=Floor.levelFloor+1;
                            }
                            if (player.getHasStatus()) {
                                player.setHasStatus(false);
                                gameAction.setDurataStatus(0);
                            }
                            player.setHasUsedSA(false);
                            System.out.println("You killed everyone in the room and moved on to the next one");
                            if(dungeon.getFloor().levelBossControl()){
                                room = dungeon.generateRoomBoos(player,dungeon.getFloor().getLevelFloor());
                                uplevel=true;
                            }else {
                                room = dungeon.generateRoom(player, dungeon.generateEnemiesList(dungeon.getFloor().getLevelFloor()));
                                uplevel=false;
                            }
                        } else if (!room.getCharacter().isAlive()) {
                            System.out.println("The enemies drag your lifeless body out of the dungeon . . .");
                            runAway = true;
                            exit = true;
                            break;
                        }
                        System.out.println("what are you gonna do: 0 run away, 1 attack, 2 special ability");

                        switch (scanner.next()) {

                            case "1":

                                // Aggiunta e modifica per avere codice più robusto
                                String sceltaString = null;
                                int scelta;
                                boolean sceltaChecker = true;
                                Enemy nemicoScelto = null;
                                while (sceltaChecker) {
                                    try {
                                        System.out.println("choose the target of your attack: ");
                                        for (int i = 0; i < room.getEnemies().size(); i++) {
                                            System.out.println(i + 1 + " " + room.getEnemies().get(i).getName() + " " + room.getEnemies().get(i).getHealt() + "HP");
                                        }
                                        sceltaString = scanner.next();
                                        scelta = Integer.parseInt(sceltaString);
                                        while (scelta > room.getEnemies().size()) {
                                            System.out.println("You have to choose a valid target of your attack.");
                                            System.out.println("Choose the target of your attack: ");
                                            for (int i = 0; i < room.getEnemies().size(); i++) {
                                                System.out.println(i + 1 + " " + room.getEnemies().get(i).getName() + " " + room.getEnemies().get(i).getHealt() + "HP");
                                            }
                                            sceltaString = scanner.next();
                                            scelta = Integer.parseInt(sceltaString);
                                        }
                                        sceltaChecker = false;
                                        nemicoScelto = room.getEnemies().get(scelta - 1);
                                    } catch (NumberFormatException numberFormatException) {
                                        System.out.println("This is not a number!");
                                    }
                                }
                                gameAction.doAttack(room.getCharacter(), nemicoScelto);

                                if (player.getHasStatus()) {
                                    if (gameAction.getDurataStatus() == 0) {
                                        player.setHasStatus(false);
                                    } else {
                                        gameAction.doDot(player);
                                        gameAction.setDurataStatus(gameAction.getDurataStatus() - 1);
                                        System.out.println(player.getName() + " received 4 points of damage and now has " + player.getHealt() + "HP");
                                    }
                                }

                                for (Enemy enemy2 : room.getEnemies()
                                ) {
                                    if (enemy2.isAlive())
                                        if (enemy2.getHasStatus()) {
                                            if (gameAction.getDurataStatusToEnemy() == 0) {
                                                enemy2.setHasStatus(false);
                                            } else {
                                                gameAction.doDotToEnemy(enemy2);
                                                gameAction.setDurataStatusToEnemy(gameAction.getDurataStatusToEnemy() - 1);
                                                System.out.println(enemy2.getName() + " received 4 points of damage and now has " + enemy2.getHealt() + "HP");
                                            }
                                        }
                                }

                                for (Enemy element : room.getEnemies()
                                ) {
                                    if (element != nemicoScelto) {
                                        gameAction.enemyDoAttack(element, room.getCharacter());
                                    }
                                }
                                for (int i = 0; i < room.getEnemies().size(); i++) {
                                    if (!room.getEnemies().get(i).isAlive()) {
                                        room.getEnemies().remove(i);
                                    }
                                }
                                break;

                            case "2":
                                if (player.getHasUsedSA()) {
                                    System.out.println("You've already used your special ability this combat, it needs to recharge");
                                    break;
                                }
                                System.out.println("choose the target of your attack: ");

                                for (int i = 0; i < room.getEnemies().size(); i++) {
                                    System.out.println(i + 1 + " " + room.getEnemies().get(i).getName() + " " + room.getEnemies().get(i).getHealt() + "HP");
                                }

                                int sceltaAbility = scanner.nextInt();
                                Enemy nemicoSceltoAbility = room.getEnemies().get(sceltaAbility - 1);
                                gameAction.doSpecialAbility(room.getCharacter(), nemicoSceltoAbility);

                                if (player.getHasStatus()) {
                                    if (gameAction.getDurataStatus() == 0) {
                                        player.setHasStatus(false);
                                    } else {
                                        gameAction.doDot(player);
                                        gameAction.setDurataStatus(gameAction.getDurataStatus() - 1);
                                        System.out.println(player.getName() + " received 4 points of damage and now has " + player.getHealt() + "HP");
                                    }
                                }

                                for (Enemy enemy2 : room.getEnemies()
                                ) {
                                    if (enemy2 != null)
                                        if (enemy2.isAlive())
                                            if (enemy2.getHasStatus()) {
                                                if (gameAction.getDurataStatusToEnemy() == 0) {
                                                    enemy2.setHasStatus(false);
                                                } else {
                                                    gameAction.doDotToEnemy(enemy2);
                                                    gameAction.setDurataStatusToEnemy(gameAction.getDurataStatusToEnemy() - 1);
                                                    System.out.println(enemy2.getName() + " received 4 points of damage and now has " + enemy2.getHealt() + "HP");
                                                }
                                            }
                                }

                                for (Enemy element : room.getEnemies()
                                ) {
                                    if (element != nemicoSceltoAbility) {
                                        gameAction.enemyDoAttack(element, room.getCharacter());
                                    }
                                }

                                for (int i = 0; i < room.getEnemies().size(); i++) {
                                    if (!room.getEnemies().get(i).isAlive()) {
                                        room.getEnemies().remove(i);
                                    }
                                }
                                break;

                            case "0":
                                runAway = true;
                                break;

                            default:
                                System.out.println("Choose a valid action you Dumb-Head . . .");
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

