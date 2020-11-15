import Entities.RandomizedAttacker;
import Entities.Warrior;

class MockWarrior extends Warrior {

    private int minDamages = 5;
    private int maxDamages = 6;

    public MockWarrior(String name){
        super(name);
        this.randomizedAttacker = new RandomizedAttacker(minDamages, maxDamages);
    }

    public int getMinDamages() {
        return minDamages;
    }

    public int getMaxDamages(){
        return maxDamages;
    }

    public void setHealth(int health){
        this.health = health;
    }
}
