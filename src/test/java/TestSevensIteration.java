import Groups.Faction;
import org.junit.Assert;
import org.junit.Test;

public class TestSevensIteration {

    @Test
    public void joinMultipleFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        Faction faction = new Faction("Demacia");
        Faction sousFaction = new Faction("Guerriers puissants");

        guerrier.joinFaction(faction);
        guerrier.joinFaction(sousFaction);

        Assert.assertTrue(guerrier.getFactions().contains(faction) && guerrier.getFactions().contains(sousFaction));
    }

    @Test
    public void leaveMultipleFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        Faction faction = new Faction("Demacia");
        Faction sousFaction = new Faction("Guerriers puissants");
        Faction tripleFaction = new Faction("Mages antiques");

        guerrier.joinFaction(faction);
        guerrier.joinFaction(sousFaction);
        guerrier.joinFaction(tripleFaction);

        guerrier.leaveFaction(sousFaction);

        Assert.assertFalse(guerrier.getFactions().contains(sousFaction));
    }
}
