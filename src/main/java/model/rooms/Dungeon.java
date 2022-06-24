package model.rooms;

import model.characters.Character;
import model.enemies.*;

import java.util.*;


public class Dungeon {

    private Collection<Room> roomList = new ArrayList<>();

    private ArrayList<Enemy> enemies =new ArrayList<>();

    private Floor floor;


    public Dungeon(){
        floor=new Floor();
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    //Crea lista di tutti i nemici
    public void allEnemies() {
        enemies.add(new Arpia());
        enemies.add(new Behir());
        enemies.add(new Bugbear());
        enemies.add(new Centauro());
        enemies.add(new Cerbero());
        enemies.add(new Coboldo());
        enemies.add(new DrowArcher());
        enemies.add(new Ghour());
        enemies.add(new Goblin());
        enemies.add(new Hobgoblin());
        enemies.add(new Idra());
        enemies.add(new InfernalDog());
        enemies.add(new Mugger());
        enemies.add(new Orco());
        enemies.add(new Sahuagin());
        enemies.add(new Skeleton());
        enemies.add(new SkeletonArcher());
        enemies.add(new Slime());
        enemies.add(new Witch());
    }

    //Genera una lista di nemici del piano dove si trova il player
    public ArrayList<Enemy> generateEnemiesList(int livelloPiano){
        ArrayList<Enemy>floorEnemies=new ArrayList<>();
        allEnemies();
        for (Enemy enemy:enemies ) {
            if(enemy.livelMin<=livelloPiano&&enemy.livelMax>=livelloPiano)
                floorEnemies.add(enemy);
        }
        return floorEnemies;
    }

    //Genera una room con i nemici random
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
