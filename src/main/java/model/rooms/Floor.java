package model.rooms;

public class Floor {

    public static int levelFloor;
    public static int nRoom = 8;

    public Floor(){
        levelFloor=1;
    }

    public int getLevelFloor() {
        return levelFloor;
    }


    //Implementare in rungame l'incremento di floor ogni 10 room
    public boolean levelBossControl(){
        if (nRoom%10==0){
            System.out.println("YOU'VE REACHED THE BOSS");
            return true;
        }else {
            return false;
        }
    }
}
