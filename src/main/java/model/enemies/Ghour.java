package model.enemies;

// I Ghours erano un tipo di demone creato dal signore dei demoni Baphomet all'interno
// della sua Torre della Scienza.
// Servirono come ambasciatori e consiglieri per i cultisti del Signore Cornuto sul Piano Materiale.
// Dominando la maggior parte degli altri esseri, i ghour somigliavano a orchi
// alti 20 piedi (6,1 metri) con molti tratti simili a minotauri, in particolare le enormi corna
// che sporgevano dai loro crani. A coprire le loro corporature muscolose c'era
// una pelle spessa e pelosa, così come altre caratteristiche bestiali.
// In aggiunta alla loro immagine simile a un minotauro c'erano i loro zoccoli al posto dei piedi.

public class Ghour extends Enemy {
    private String name = "Ghour";
    private long healt = 40;
    private long damage;

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

    public Ghour() {
        livelMin = 4;
        livelMax = 5;
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
