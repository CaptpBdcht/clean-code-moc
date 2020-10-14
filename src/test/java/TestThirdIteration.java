import org.junit.Assert;
import org.junit.Test;

import javax.print.DocFlavor;

public class TestThirdIteration {

    @Test
    public void testPriestHealsAlly(){
        Priest priest = new Priest("Aerith");
        Warrior warrior = new Warrior("Cloud");
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
        Priest priest = new Priest("Aerith");
        int healthBeforeHeal = 50;

        priest.setHealth(healthBeforeHeal);
        priest.heal(priest);

        Assert.assertEquals(priest.getHealth(), healthBeforeHeal + 1);
    }

    @Test
    public void testPriestCannotAttackEnemy(){
        Priest priest = new Priest("Aerith");
        Warrior mechant = new Warrior("Sephiroth");
        int healthBeforeAttack = 50;

        mechant.setHealth(healthBeforeAttack);
        priest.attack(mechant);

        Assert.assertEquals(mechant.getHealth(), healthBeforeAttack);
    }

    @Test
    public void testPriestCannotAttackSelf(){
        Priest priest = new Priest("Aerith");
        int healthBeforeAttack = 50;

        priest.setHealth(healthBeforeAttack);
        priest.attack(priest);

        Assert.assertEquals(priest.getHealth(), healthBeforeAttack);
    }
}
