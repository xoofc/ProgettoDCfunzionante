package model.enemies;


public abstract class  Enemy implements Cloneable{

    public int livelMin;
    public int livelMax;
    public int livelBoss;


    abstract public boolean getIsFrozen();
    abstract public void setFrozen(boolean frozen);
    abstract public void setHasStatus(boolean hasStatus);
    abstract public boolean getHasStatus();
    abstract public boolean isAlive();
    abstract public long setDamageOutput();
    abstract public String getName();
    abstract public long getHealt();
    abstract public void setHealt(long healt);
    abstract public long getDamage();
    abstract public void setDamage(long damage);
    abstract public void doAttack();
    abstract public long doDefend();
    abstract public void doSpecialAbility();

    @Override
    public Enemy clone() {
        try {
            return (Enemy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
