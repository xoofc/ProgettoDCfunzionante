package model.characters;

public interface Character {

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
    long doDefend();
    void doSpecialAbility();
    void useItem();
    void doEscape();
    void setGold(long gold);
    long getGold();
}
