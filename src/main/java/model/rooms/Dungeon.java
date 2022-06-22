package model.rooms;

import model.characters.Character;
import model.enemies.Enemy;
import model.enemies.Mugger;
import model.enemies.Skeleton;
import model.enemies.Slime;

import java.util.*;


public class Dungeon {

    Collection<Room> roomList = new ArrayList<>();

    ArrayList<Enemy> enemies =new ArrayList<>();

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void allEnemies() {
        enemies.add(new Skeleton());
        enemies.add(new Slime());
        enemies.add(new Mugger());
    }

    public ArrayList<Enemy> generateEnemiesList(int livelloPiano){
        ArrayList<Enemy>floorEnemies=new ArrayList<>();
        allEnemies();
        for (Enemy enemy:enemies ) {
            if(enemy.livelMin<=livelloPiano&&enemy.livelMax>=livelloPiano)
                floorEnemies.add(enemy);
        }
        return floorEnemies;
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
