import Groups.Faction;
import org.junit.Assert;
import org.junit.Test;

public class TestFourthIteration {

    @Test
    public void testNoFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        Assert.assertTrue(guerrier.getFactions().isEmpty());
    }

    @Test
    public void testNoMembers() {
        Faction faction = new Faction("Demacia");
        Assert.assertTrue(faction.getMembers().isEmpty());
    }

    @Test
    public void testJoinFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);

        Assert.assertTrue(guerrier.getFactions().contains(faction));
    }

    @Test
    public void testAddMember(){
        MockWarrior guerrier = new MockWarrior("Garen");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);

        Assert.assertTrue(faction.hasMember(guerrier));
    }

    @Test
    public void testLeaveFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);
        guerrier.leaveFaction(faction);

        Assert.assertTrue(guerrier.getFactions().isEmpty());
    }

    @Test
    public void testDeleteMember() {
        MockWarrior guerrier = new MockWarrior("Garen");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);
        guerrier.leaveFaction(faction);

        Assert.assertFalse(faction.hasMember(guerrier));
    }

    @Test
    public void testAttackSameFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        MockPriest pretre = new MockPriest("Lux");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);
        pretre.joinFaction(faction);

        guerrier.attack(pretre);

        Assert.assertEquals(pretre.getHealth(), 100);
    }

    @Test
    public void testAttackNotSameFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        MockWarrior enemy = new MockWarrior("Darius");
        Faction faction = new Faction("Demacia");
        Faction enemyFaction = new Faction("Noxus");
        guerrier.joinFaction(faction);
        enemy.joinFaction(enemyFaction);

        guerrier.attack(enemy);

        Assert.assertNotEquals(enemy.getHealth(), 100);
    }

    @Test
    public void testHealSameFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        MockPriest pretre = new MockPriest("Lux");
        Faction faction = new Faction("Demacia");
        guerrier.joinFaction(faction);
        guerrier.setHealth(50);
        pretre.joinFaction(faction);

        pretre.heal(guerrier);

        Assert.assertNotEquals(guerrier.getHealth(), 50);
    }

    @Test
    public void testHealNotSameFaction() {
        MockPriest pretre = new MockPriest("Lux");
        MockWarrior enemy = new MockWarrior("Darius");
        Faction faction = new Faction("Demacia");
        Faction enemyFaction = new Faction("Noxus");
        pretre.joinFaction(faction);
        enemy.joinFaction(enemyFaction);

        enemy.setHealth(50);

        pretre.heal(enemy);

        Assert.assertEquals(enemy.getHealth(), 50);
    }
}
