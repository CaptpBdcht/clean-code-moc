import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void testFirstIteration() {
        Character gentil = new Character("Link");
        Assert.assertEquals(gentil.getHealth(), 100);

        Character mechant = new Character("Ganondorf");
        mechant.attack(gentil);
        Assert.assertEquals(gentil.getHealth(), 99);

        gentil.heal(gentil);
        Assert.assertEquals(gentil.getHealth(), 100);

        // Ne dépasse pas 100
        gentil.heal(gentil);
        Assert.assertEquals(gentil.getHealth(), 100);

        mechant.attack(mechant);
        Assert.assertEquals(mechant.getHealth(), 100);

        for (int i = 0; i < 200; i++) {
            mechant.attack(gentil);
        }

        Assert.assertEquals(gentil.getHealth(), 0);
        Assert.assertFalse(gentil.isAlive());
    }

    @Test
    public void testSecondIteration(){
        Warrior gentil = new Warrior("Red Hood");
        Warrior mechant = new Warrior("Joker");

        gentil.attack(mechant);
        Assert.assertTrue(mechant.getHealth() <= 100 && mechant.getHealth() >= 91);

        gentil.attack(gentil);
        Assert.assertTrue(gentil.getHealth() <= 100 && gentil.getHealth() >= 91);

        int healthMechant = mechant.getHealth();
        gentil.heal(mechant);
        Assert.assertEquals(mechant.getHealth(), healthMechant);

        int healthGentil = 5;
        gentil.setHealth(healthGentil);
        gentil.heal(gentil);
        Assert.assertEquals(gentil.getHealth(), healthGentil + 1);
    }

    @Test
    public void testThirdIteration(){
        Priest priest = new Priest("Aerith");
        Character gentil = new Character("Cloud");
        Character mechant = new Character("Sephiroth");

        int healthGentil = 50;
        gentil.setHealth(healthGentil);
        priest.heal(gentil);
        Assert.assertTrue( healthGentil + 5 <= gentil.getHealth() &&  gentil.getHealth() <= healthGentil + 10);

        priest.attack(mechant);
        Assert.assertEquals(mechant.getHealth(), 100);

        int healthPriest = 50;
        priest.setHealth(healthPriest);
        priest.heal(priest);
        Assert.assertEquals(priest.getHealth() - 1, healthPriest);
    }


}
