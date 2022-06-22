package model.enemies;

public class Mugger extends Enemy{

    private String name = "Mugger";
    private long healt = 30;
    private long damage;

    private boolean hasStatus = false;
    public boolean getHasStatus() {
        return hasStatus;
    }

    public void setHasStatus(boolean hasStatus) {
        this.hasStatus = hasStatus;
    }

    public Mugger() {
        livelMin = 1;
        livelMax = 1;
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

    @Override //il mugger non usa defend, usa dodge come la classe Character Thief
    public long doDefend() {
        return 0;
    }

    public boolean dodge(){
        long dodge = Math.round(Math.random()*3);
        long dodgeCheck = Math.round(Math.random()*3);
        return dodge == dodgeCheck;
    }

    @Override
    public void doSpecialAbility() {

    }

    public long setDamageOutput() {
        return Math.round(Math.random() * (7 - 5) + 5);
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
