import org.junit.Assert;
import org.junit.Test;

public class TestThirdIteration {

    @Test
    public void testPriestHealsAlly(){
        MockPriest priest = new MockPriest("Aerith");
        MockWarrior warrior = new MockWarrior("Cloud");
        int healthBeforeHeal = 50;

        for(var i = 0; i < 200; i++){
            warrior.setHealth(healthBeforeHeal);
            priest.heal(warrior);
            boolean healthMin =  warrior.getHealth() >= healthBeforeHeal + 5;
            boolean healthMax = warrior.getHealth() <= healthBeforeHeal + 10;
            Assert.assertTrue( healthMin && healthMax);
        }
    }

    @Test
    public void testPriestHealsSelf(){
        MockPriest priest = new MockPriest("Aerith");
        int healthBeforeHeal = 50;

        priest.setHealth(healthBeforeHeal);
        priest.heal(priest);

        Assert.assertEquals(priest.getHealth(), healthBeforeHeal + 1);
    }

    @Test
    public void testPriestCannotAttackEnemy(){
        MockPriest priest = new MockPriest("Aerith");
        MockWarrior mechant = new MockWarrior("Sephiroth");
        int healthBeforeAttack = 50;

        mechant.setHealth(healthBeforeAttack);
        priest.attack(mechant);

        Assert.assertEquals(mechant.getHealth(), healthBeforeAttack);
    }

    @Test
    public void testPriestCannotAttackSelf(){
        MockPriest priest = new MockPriest("Aerith");
        int healthBeforeAttack = 50;

        priest.setHealth(healthBeforeAttack);
        priest.attack(priest);

        Assert.assertEquals(priest.getHealth(), healthBeforeAttack);
    }
}
