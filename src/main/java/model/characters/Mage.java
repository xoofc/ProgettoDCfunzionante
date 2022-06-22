package model.characters;

import model.enemies.Enemy;

import java.util.Arrays;
import java.util.Collections;

public class Mage implements Character{

    private String name;
    private long healt = 110;
    private long mana = 6;
    private long damage;
    private long gold;

    private boolean hasStatus = false;

    boolean hasUsedSA = false;


    public boolean getHasUsedSA() {
        return hasUsedSA;
    }

    @Override
    public void setHasUsedSA(boolean hasUsedSA) {
        this.hasUsedSA = hasUsedSA;
    }

    public boolean getHasStatus() {
        return hasStatus;
    }

    public void setHasStatus(boolean hasStatus) {
        this.hasStatus = hasStatus;
    }


    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public long getHealt() {
        return healt;
    }

    public void setHealt(long healt) {
        this.healt = healt;
    }

    public long getMana() {
        return mana;
    }

    public void setMana(long mana) {
        this.mana = mana;
    }

    public long getDamage() {
        return damage;
    }

    public void setDamage(long damage) {
        this.damage = damage;
    }

    @Override
    public long setDamageOutput() {
        return Math.round(Math.random() * (15 - 9) + 7);
    }


    @Override //palla casuale (fuoco/ghiaccio): fuoco -> dot al nemico per 3 turni, ghiaccio -> il nemico non attacca nel turno corrente
    public int doSpecialAbility() {
        int[] fireballType = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Collections.shuffle(Arrays.asList(fireballType));
        int randScelta = (int) Math.round(Math.random()*40);
        return fireballType[randScelta];
    }

    @Override
    public void useItem() {

    }



    public boolean isAlive() {
        if (this.getHealt()>0) {
            return true;
        } else if (this.getHealt() <= 0) {
            return false;
        }
        return false;
    }
}
