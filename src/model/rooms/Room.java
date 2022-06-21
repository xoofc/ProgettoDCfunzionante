package model.rooms;

import model.characters.Character;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Collection;

public class Room {

    private Character character;
    private Enemy enemy;

    private Collection<Enemy> enemies=new ArrayList<>();

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public Collection<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(Collection<Enemy> enemies) {
        this.enemies = enemies;
    }

    public Room(){}
    public Room(Character character, Enemy enemy){
        this.character = character;
        this.enemy = enemy;
    }


    public Room(Character character,Collection<Enemy> enemies){
        this.character=character;
        this.enemies=enemies;
    }

    public boolean isCompleted(){
        return !enemy.isAlive();
    }

}
