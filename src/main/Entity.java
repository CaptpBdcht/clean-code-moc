package main;

public abstract class Entity {
    public enum states {ALIVE,DEAD}
    protected int health;
    private states state = states.ALIVE;

    public Entity(int health){
        this.health = health;
    }

    public states getState() {
        return state;
    }

    public void setState(states state) {
        this.state = state;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage){
        if(this.health - damage < 0){
            this.health = 0;
            this.setState(states.DEAD);
        }
        else
            this.health -= damage;
    }
    public abstract void die();
}