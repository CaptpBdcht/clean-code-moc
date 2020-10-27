import org.junit.Assert;
import org.junit.Test;

public class TestFifthIteration {

    /*
    @Test
    public void testCannotJoinFaction(){
        Faction faction = new Faction("Rohan");
        Entity cheval = new Entity(40);
        new AssertionError(faction.addMember(cheval););
    }
     */

    @Test
    public void testCanBeAttacked(){
        Entity epona = new Entity(40);
        Warrior warrior = new Warrior("Ganondorf");
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
        Entity epona = new Entity(40);
        Priest priest = new Priest("Zelda");

        int healthBeforeHeal = 20;
        epona.setHealth(healthBeforeHeal);
        priest.heal(epona);

        Assert.assertEquals(epona.getHealth(), healthBeforeHeal);
    }
}
