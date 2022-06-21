package model.rooms;

import model.characters.Character;
import model.enemies.Enemy;

import java.util.*;

public class Dungeon {

    Collection<Room> roomList = new ArrayList<>();

    ArrayList<Enemy> floorEnemies =new ArrayList<>();

    public Room generateRoom(Character character, ArrayList<Enemy> floorEnemies){
        Collection <Enemy> enemies=new ArrayList<>();
        int nEnemies= (int) (Math.random()*(3-1+1));
        for (int i=0;i<nEnemies;i++){
            enemies.add(floorEnemies.get((int) Math.random()*floorEnemies.size()));
        }
        Room room=new Room(character,enemies);
        return room;
    }
}
