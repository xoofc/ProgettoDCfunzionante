package model.rooms;

import model.characters.Character;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Collection;

public class Room {

    private Character character;
//    private Enemy enemy;

    private int nRoom=0;

    private ArrayList<Enemy> enemies=new ArrayList<>();


    public Room(){}

//    public Room(Character character, Enemy enemy){
//        this.character = character;
//        this.enemy = enemy;
//    }

    public Room(Character character,ArrayList<Enemy> enemies){
        this.character=character;
        this.enemies=enemies;
        new Floor(this);
        nRoom++;
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


    public int getNRoom() {
        return nRoom;
    }
    public void setNRoom(int nRoom){
        this.nRoom=nRoom;
    }


    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }


}
