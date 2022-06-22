package model.characters;

import model.enemies.Enemy;

public interface Character {

     boolean getHasStatus();
     void setHasStatus(boolean hasStatus);
    boolean isAlive();
    String getName();
    void setName(String name);
    long getHealt();
    void setHealt(long healt);
    long getMana();
    void setMana(long mana);
    long getDamage();
    void setDamage(long damage);
    long setDamageOutput();
    int doSpecialAbility(Enemy enemy);
    void useItem();
    void setGold(long gold);
    long getGold();
    boolean getHasUsedSA();
    void setHasUsedSA(boolean hasUsedSA);
}
