package model.rooms;

public class Floor {

    private int levelFloor=0;

    public Floor(){
        levelFloor=1;
    }

    public Floor(Room room){
        levelControl(room);
    }

    public int getLevelFloor() {
        return levelFloor;
    }

    public void setLevelFloor(int levelFloor) {
        this.levelFloor = levelFloor;
    }

    public void levelControl(Room room){
        if (room.getNRoom()%10==0){
            levelFloor++;
        }
    }
}
