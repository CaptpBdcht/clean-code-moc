import org.junit.Assert;
import org.junit.Test;

public class TestFourthIteration {

    @Test
    public void testNoFaction() {
        Warrior guerrier = new Warrior("Garen");
        Assert.assertNull(guerrier.getFaction());
    }

    @Test
    public void testNoMembers() {
        Faction faction = new Faction("Demacia");
        Assert.assertEquals(faction.getMembers().size(), 0);
    }

    @Test
    public void testJoinFaction() {
        Warrior guerrier = new Warrior("Garen");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);

        Assert.assertEquals(guerrier.getFaction(), faction);
    }

    @Test
    public void testAddMember(){
        Warrior guerrier = new Warrior("Garen");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);

        Assert.assertTrue(faction.isMember(guerrier));
    }

    @Test
    public void testLeaveFaction() {
        Warrior guerrier = new Warrior("Garen");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);
        guerrier.leaveFaction();

        Assert.assertNull(guerrier.getFaction());
    }

    @Test
    public void testDeleteMember() {
        Warrior guerrier = new Warrior("Garen");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);
        guerrier.leaveFaction();

        Assert.assertFalse(faction.isMember(guerrier));
    }

    @Test
    public void testAttackSameFaction() {
        Warrior guerrier = new Warrior("Garen");
        Priest pretre = new Priest("Lux");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);
        pretre.joinFaction(faction);

        guerrier.attack(pretre);

        Assert.assertEquals(pretre.getHealth(), 100);
    }

    @Test
    public void testAttackNotSameFaction() {
        Warrior guerrier = new Warrior("Garen");
        Warrior enemy = new Warrior("Darius");
        Faction faction = new Faction("Demacia");
        Faction enemyFaction = new Faction("Noxus");
        guerrier.joinFaction(faction);
        enemy.joinFaction(enemyFaction);

        guerrier.attack(enemy);

        Assert.assertNotEquals(enemy.getHealth(), 100);
    }

    @Test
    public void testHealSameFaction() {
        Warrior guerrier = new Warrior("Garen");
        Priest pretre = new Priest("Lux");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);
        guerrier.setHealth(50);
        pretre.joinFaction(faction);

        pretre.heal(guerrier);

        Assert.assertNotEquals(guerrier.getHealth(), 50);
    }

    @Test
    public void testHealNotSameFaction() {
        Priest pretre = new Priest("Lux");
        Warrior enemy = new Warrior("Darius");
        Faction faction = new Faction("Demacia");
        Faction enemyFaction = new Faction("Noxus");
        pretre.joinFaction(faction);
        enemy.joinFaction(enemyFaction);

        enemy.setHealth(50);

        pretre.heal(enemy);

        Assert.assertEquals(enemy.getHealth(), 50);
    }
}
