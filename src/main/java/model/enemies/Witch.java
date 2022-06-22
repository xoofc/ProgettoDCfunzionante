package model.enemies;

public class Witch extends Enemy {

    private String name = "Witch";

    private long healt = 25;

    private long damage;


    @Override
    public boolean isAlive() {
        if (this.getHealt()>0) {
            return true;
        } else if (this.getHealt() <= 0) {
            return false;
        }
        return false;
    }


    @Override
    public long setDamageOutput() {
        return Math.round(Math.random() * (8 - 4) + 4);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public long getHealt() {
        return 0;
    }

    @Override
    public void setHealt(long healt) {

    }

    @Override
    public long getDamage() {
        return 0;
    }

    @Override
    public void setDamage(long damage) {

    }

    @Override
    public void doAttack() {

    }

    @Override
    public long doDefend() {
        return 0;
    }

    @Override
    public void doSpecialAbility() {

    }

}
