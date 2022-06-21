package model.characters;

public class Thief implements Character{
    private String name;
    private long healt = 80;
    private long mana = 3;
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
        return Math.round(Math.random() * (15 - 5) + 10);
    }

    @Override  //non utilizzare, il thief non può difendersi ma usa dodge() per schivare
    public long doDefend() {
        return 0;
    }

    public boolean dodge(){
        long dodge = Math.round(Math.random()*3);
        long dodgeCheck = Math.round(Math.random()*3);
        return dodge == dodgeCheck;
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
