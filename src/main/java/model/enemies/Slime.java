package model.enemies;

public class Slime extends Enemy{

    private String name = "Slime";
    private long healt = 40;
    private long damage;

    public Slime() {
        livelMin = 1;
        livelMax = 4;
    }

    private boolean hasStatus = false;
    public boolean getHasStatus() {
        return hasStatus;
    }

    public void setHasStatus(boolean hasStatus) {
        this.hasStatus = hasStatus;
    }

    private boolean isFrozen = false;
    @Override
    public boolean getIsFrozen() {
        return isFrozen;
    }

    @Override
    public void setFrozen(boolean frozen) {
        this.isFrozen = frozen;
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
    public long doDefend() {
        return Math.round(Math.random() * (5 - 1) + 1);
    }

    @Override
    public void doSpecialAbility() {

    }

    public long setDamageOutput() {
        return Math.round(Math.random() * (5 - 1) + 1);
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
