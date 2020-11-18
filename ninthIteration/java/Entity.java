public class Entity {

    int health;


    States state;

    public Entity(int health) {
        this.health = health;
        this.state = States.alive;
    }


    public void setHealthto100() {
        if(health > 100)
            this.health = 100;
    }

    public boolean isCharacter(){
        if (this instanceof Character) return true;
        return false;

    }

    public boolean isAlive(){

        if(this.health <= 0) {
            this.setState();
            return false;
        }
        this.setState();
        return true;
    }

    public void setState() {
        if(this.health <= 0) {
            this.state = States.dead;
            return;
        }
        this.state = States.alive;
    }


}
