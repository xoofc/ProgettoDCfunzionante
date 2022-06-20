package Model.Characters;

import Model.Enemies.Enemy;

public class Knight implements Character {

    private String name;
    private long healt = 75;
    private long mana = 25;
    private long damage;
    private long gold;

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
    public long doDefend() {
        return Math.round(Math.random() * (10 - 3) + 3);
    }

    @Override
    public void doSpecialAbility() {

    }

    @Override
    public void useItem() {

    }

    @Override
    public void doEscape() {

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
