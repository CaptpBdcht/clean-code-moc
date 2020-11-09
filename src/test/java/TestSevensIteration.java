import org.junit.Assert;
import org.junit.Test;

public class TestSevensIteration {

    @Test
    public void joinMultipleFaction() {
        Warrior guerrier = new Warrior("Garen");
        Faction faction = new Faction("Demacia");
        Faction sousFaction = new Faction("Guerriers puissants");

        guerrier.joinFaction(faction);
        guerrier.joinFaction(sousFaction);

        Assert.assertTrue(guerrier.getFactions().contains(faction) && guerrier.getFactions().contains(sousFaction));
    }

    @Test
    public void leaveMultipleFaction() {
        Warrior guerrier = new Warrior("Garen");
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
