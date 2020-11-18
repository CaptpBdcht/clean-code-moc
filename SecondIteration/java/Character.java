
public class Character implements Attribute {


    String name;
    int health;
    States state;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.state = States.alive;
    }



    @Override
    public void attack(Character character) {

        if (character != this) {

            if (character.isAlive())
                character.health -= 1;
        }

    }


    @Override
    public void heal(Character character) {


        if (character.health == 100)
            return;

        character.health += 1;
        character.isAlive();

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
