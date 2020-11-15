import org.junit.Assert;
import org.junit.Test;

public class TestSecondIteration {

    @Test
    public void testWarriorAttacksEnemy(){
        MockWarrior gentil = new MockWarrior("Red Hood");
        MockWarrior mechant = new MockWarrior("Joker");
        int healthBeforeAttacks = 100;

        for(int i = 0; i < 200; i ++){
            mechant.setHealth(healthBeforeAttacks);
            gentil.attack(mechant);
            boolean healthMin = mechant.getHealth() <= 100 ;
            boolean healthMax = mechant.getHealth() >= 91;
            Assert.assertTrue(healthMin && healthMax);
        }
    }

    @Test
    public void testWarriorAttacksSelf(){
        MockWarrior gentil = new MockWarrior("Red Hood");
        int healthBeforeAttacks = 100;

        for(int i = 0; i < 200; i ++){
            gentil.setHealth(healthBeforeAttacks);
            gentil.attack(gentil);
            boolean healthMin = gentil.getHealth() <= 100 ;
            boolean healthMax = gentil.getHealth() >= 91;
            Assert.assertTrue(healthMin && healthMax);
        }
    }

    @Test
    public void testWarriorCannotHealEnemy(){
        MockWarrior gentil = new MockWarrior("Jason Todd");
        MockWarrior mechant = new MockWarrior("Joker");
        int healthBeforeHeal = 50;

        mechant.setHealth(healthBeforeHeal);
        gentil.heal(mechant);
        Assert.assertEquals(mechant.getHealth(), healthBeforeHeal);
    }

    @Test
    public void testWarriorHealsSelf(){
        MockWarrior gentil = new MockWarrior("Jason Todd");
        int healthBeforeHeal = 50;

        gentil.setHealth(healthBeforeHeal);
        gentil.heal(gentil);
        Assert.assertEquals(gentil.getHealth(), healthBeforeHeal + 1);
    }

}
