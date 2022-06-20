package Model.Rooms;

import Model.Characters.Character;
import Model.Enemies.Enemy;

public class Room {

    public Character character;
    public Enemy enemy;

    public Room(Character character, Enemy enemy){
        this.character = character;
        this.enemy = enemy;
    }

    public boolean isCompleted(){
        return !enemy.isAlive();
    }

}
