import org.junit.Assert;
import org.junit.Test;

public class TestWarrior {

    @Test
    public void testWarriorAttacksEnemy(){
        MockWarrior gentil = new MockWarrior("Red Hood");
        MockWarrior mechant = new MockWarrior("Joker");

        gentil.attack(mechant);

        boolean healthMin = mechant.getHealth() <= 100 - mechant.getMinDamages() ;
        boolean healthMax = mechant.getHealth() >= 100 - mechant.getMaxDamages();
        Assert.assertTrue(healthMin && healthMax);
    }

    @Test
    public void testWarriorAttacksSelf(){
        MockWarrior gentil = new MockWarrior("Red Hood");

        gentil.attack(gentil);

        Assert.assertEquals(gentil.getHealth(), 100 - 1);
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
