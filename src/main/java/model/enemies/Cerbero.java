package model.enemies;

public class Cerbero extends Enemy {
    private String name = "Cerbero";

    private long healt = 90;

    private long damage;

    public Cerbero() {
        livelMin = 1;
        livelMax = 3;
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

    @Override
    public void setHealt(long healt) {
        this.healt = healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }

    public long getDamage() {
        return damage;
    }

    @Override
    public void setDamage(long damage) {

    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void doAttack() {

    }

    @Override // la strega è già abbastanza rotta, non deve difendersi
    public long doDefend(){
        return 0;
    }

    @Override
    public void doSpecialAbility() {

    }

    public long setDamageOutput() {
        return Math.round(Math.random() * (14 - 1) + 1);
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

