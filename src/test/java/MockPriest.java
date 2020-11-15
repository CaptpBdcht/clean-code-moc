import Entities.Priest;
class MockPriest extends Priest{
    public MockPriest(String name){
        super(name);
    }

    public void setHealth(int health){
        this.health = health;
    }
}
