package model.enemies;

//creatura leggendaria o un tipo di hobgoblin paragonabile all'uomo nero e ad altre creature del folklore
public class Bugbear extends Enemy {
    private String name = "Bugbear";
    private long healt = 35;
    private long damage;

    private boolean hasStatus = false;

    private boolean isFrozen = false;
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

    public Bugbear() {
        livelMin = 2;
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

    @Override
    public long doDefend() {
        return Math.round(Math.random() * (5 - 1) + 1);
    }

    @Override
    public void doSpecialAbility() {

    }

    public long setDamageOutput() {
        return Math.round(Math.random() * (12 - 5) + 5);
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
