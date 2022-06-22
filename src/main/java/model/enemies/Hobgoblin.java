package model.enemies;
//Gli hobgoblin sono grandi goblinoidi con la pelle arancione scuro o rosso-arancio.
// Un hobgoblin misura la virtù in base alla forza fisica e all'abilità marziale,
// non curandosi di nient'altro che dell'abilità e dell'astuzia in battaglia.
public class Hobgoblin extends Enemy{
    private String name = "Hobgoblin";
    private long healt = 35;
    private long damage;

    public Hobgoblin() {
        livelMin = 3;
        livelMax = 4;
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
        return Math.round(Math.random() * (6 - 1) + 1);
    }

    @Override
    public void doSpecialAbility() {

    }

    public long setDamageOutput() {
        return Math.round(Math.random() * (10 - 6) + 6);
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
