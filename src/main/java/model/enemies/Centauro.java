package model.enemies;

public class Centauro extends Enemy{
    private String name = "Centauro";

    private long healt = 45;

    private long damage;

    private boolean hasStatus = false;

    private boolean isFrozen = false;

    public Centauro() {
        livelMin = 1;
        livelMax = 3;
    }

    @Override
    public boolean getIsFrozen() {
        return isFrozen;
    }

    @Override
    public void setFrozen(boolean frozen) {
        this.isFrozen = frozen;
    }

    public boolean getHasStatus() {
        return hasStatus;
    }
    public void setHasStatus(boolean hasStatus) {
        this.hasStatus = hasStatus;
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

    @Override
    public long doDefend(){
        return 0;
    }

    @Override
    public void doSpecialAbility() {

    }

    public long setDamageOutput() {
        return Math.round(Math.random() * (11 - 6) + 1);
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
