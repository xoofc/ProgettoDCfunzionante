package model.enemies;


public interface Enemy {
    boolean isAlive();
    public long setDamageOutput();
    String getName();
    long getHealt();
    void setHealt(long healt);
    long getDamage();
    void setDamage(long damage);
    void doAttack();
    long doDefend();
    void doSpecialAbility();
}
