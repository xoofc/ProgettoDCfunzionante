package model.rooms;

import model.characters.Character;

public class RoomReward {

    public void generateReward(Character character){
        long goldAmount = Math.round(Math.random()*(30-5)+5);
        character.setGold(character.getGold() + goldAmount);
    }
}
