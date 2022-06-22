package model.rooms;

import model.characters.Character;
import model.enemies.Enemy;
import run.RunGame;

import java.util.ArrayList;
import java.util.Collection;

public class Room {

    private Character character;
//    private Enemy enemy;

    private ArrayList<Enemy> enemies=new ArrayList<>();


    public Room(){}

//    public Room(Character character, Enemy enemy){
//        this.character = character;
//        this.enemy = enemy;
//    }

    public Room(Character character,ArrayList<Enemy> enemies){
        this.character=character;
        this.enemies=enemies;
        Floor.nRoom += 1;
    }

//    public boolean isCompleted(){
//        return !enemy.isAlive();
//    }

    public Character getCharacter() {
        return character;
    }
    public void setCharacter(Character character) {
        this.character = character;
    }


    //    public Enemy getEnemy() {
//        return enemy;
//    }

//    public void setEnemy(Enemy enemy) {
//        this.enemy = enemy;
//    }





    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }


}
