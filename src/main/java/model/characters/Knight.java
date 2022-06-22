package model.characters;

import model.enemies.Enemy;

public class Knight implements Character {

    private String name;
    private long healt = 110;
    private long mana = 3;
    private long damage;
    private long gold;

    private boolean hasUsedSA = false;

    public boolean getHasUsedSA() {
        return hasUsedSA;
    }

    public void setHasUsedSA(boolean hasUsedSA) {
        this.hasUsedSA = hasUsedSA;
    }

    private boolean hasStatus = false;

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
        return Math.round(Math.random() * (20 - 10) + 10);
    }


    @Override
    public int doSpecialAbility(Enemy enemy) {
        hasUsedSA = true;
        long timesHit = Math.round(Math.random()*3) + 2;
        int dmgAmount = 0;
        for (int i = 0; i < timesHit; i++){
            dmgAmount += 9;
        }
        return dmgAmount;
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
