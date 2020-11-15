import Entities.Character;
import Entities.Warrior;

class MockWarrior extends Warrior {

    public MockWarrior(String name){
        super(name);
    }

    public void setHealth(int health){
        this.health = health;
    }
}
