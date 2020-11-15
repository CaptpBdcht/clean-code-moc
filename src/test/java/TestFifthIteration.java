import org.junit.Assert;
import org.junit.Test;

public class TestFifthIteration {

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
        MockEntity epona = new MockEntity(40);
        MockWarrior warrior = new MockWarrior("Ganondorf");
        int healthBeforeAttacks = 40;

        for(int i = 0; i < 200; i ++){
            epona.setHealth(healthBeforeAttacks);
            warrior.attack(epona);
            boolean healthMin = epona.getHealth() <= 40 ;
            boolean healthMax = epona.getHealth() >= 31;
            Assert.assertTrue(healthMin && healthMax);
        }
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
