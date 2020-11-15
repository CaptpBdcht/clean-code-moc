import Entities.Entity;

class MockEntity extends Entity {
    public MockEntity(int health) {
        super(health);
    }

    public void setHealth(int health){
        this.health = health;
    }
}
