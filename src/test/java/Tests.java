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
}
