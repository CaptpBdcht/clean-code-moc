import org.junit.Assert;
import org.junit.Test;

public class TestEntities {

    /*
    @Test
    public void testCannotJoinFaction(){
        Groups.Faction faction = new Groups.Faction("Rohan");
        Characters.Entity cheval = new Characters.Entity(40);
        new AssertionError(faction.addMember(cheval););
    }
    */

    @Test
    public void testCanBeAttacked(){
        int maxHealth = 40;

        MockEntity epona = new MockEntity(maxHealth);
        MockWarrior warrior = new MockWarrior("Ganondorf");

        warrior.attack(epona);
        Assert.assertTrue(epona.getHealth() < maxHealth);
    }

    @Test
    public void testCannotBeHealed(){
        MockEntity epona = new MockEntity(40);
        MockPriest priest = new MockPriest("Zelda");

        int healthBeforeHeal = 20;
        epona.setHealth(healthBeforeHeal);
        priest.heal(epona);

        Assert.assertEquals(epona.getHealth(), healthBeforeHeal);
    }
}
