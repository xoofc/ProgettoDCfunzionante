package model.enemies;

public class Skeleton extends Enemy{

    private String name = "Skeleton";
    private long healt = 15;
    private long damage;

    /*public Skeleton(){
        Enemy enemy = new Skeleton(name, 15);
    }

    public Skeleton(String name, long healt){
        this.name = name;
        this.healt = healt;
    }*/
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
        return Math.round(Math.random() * (8 - 1) + 1);
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
