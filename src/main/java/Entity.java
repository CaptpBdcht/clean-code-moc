public class Entity {

    protected int health;
    protected int maxHealth;

    Entity(int health){
        this.health = health;
        this.maxHealth = health;
    }

    void setHealth(int health) {
        if (this.isMaximumHealth(health)) {
            this.health = maxHealth;
        }
        else if (this.isMinimumHealth(health)) {
            this.health = 0;
        }
        else {
            this.health = health;
        }
    }

    int getHealth() { return health; }


    private boolean isMaximumHealth(int value) { return value > maxHealth; }

    private boolean isMinimumHealth(int value) { return value < 0; }

    public boolean isHealable(){ return this instanceof Character; }

    boolean isAlive() { return health > 0; }

}
