package model.characters;

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
    void doSpecialAbility();
    void useItem();
    void setGold(long gold);
    long getGold();
}
