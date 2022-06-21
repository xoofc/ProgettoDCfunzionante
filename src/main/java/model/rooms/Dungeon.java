package model.rooms;

import model.characters.Character;
import model.enemies.Enemy;
import model.enemies.Mugger;
import model.enemies.Skeleton;
import model.enemies.Slime;

import java.util.*;


public class Dungeon {

    Collection<Room> roomList = new ArrayList<>();

    ArrayList<Enemy> floorEnemies =new ArrayList<>();

    public ArrayList<Enemy> generateEnemiesList(int livelloPiano){
        ArrayList<Enemy>enemies=new ArrayList<>();
        Enemy skeleton=new Skeleton();
        if(skeleton.livelMin<=livelloPiano&&skeleton.livelMax>=livelloPiano)
            enemies.add(skeleton);
        Enemy slime=new Slime();
        if(slime.livelMin<=livelloPiano&&slime.livelMax>=livelloPiano)
            enemies.add(slime);
        Enemy mugger=new Mugger();
        if(mugger.livelMin<=livelloPiano&&mugger.livelMax>=livelloPiano)
            enemies.add(mugger);
        return enemies;
    }

    public Room generateRoom(Character character, ArrayList<Enemy> floorEnemies){
        Random random =new Random();
        ArrayList <Enemy> enemies=new ArrayList<>();
        int nEnemies= random.nextInt(3)+1;
        for (int i=0;i<nEnemies;i++){
            int ranNemico = random.nextInt(floorEnemies.size());
            enemies.add(floorEnemies.get(ranNemico).clone());
        }
        Room room=new Room(character,enemies);
        return room;
    }
}
