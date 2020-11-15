import Groups.Faction;
import org.junit.Assert;
import org.junit.Test;

public class TestSixIteration {

    @Test
    public void testAddFriend(){
        Faction faction = new Faction("Les Réprouvés");
        Faction friend = new Faction("Durothar");
        faction.addFriend(friend);
        Assert.assertTrue(faction.hasFriend(friend) && friend.hasFriend(faction));
    }

    @Test public void testRemoveFriend(){
        Faction faction = new Faction("Le Fléau");
        Faction friend = new Faction("Les Réprouvés");
        faction.addFriend(friend);
        faction.removeFriend(friend);
        Assert.assertFalse(faction.hasFriend(friend) && friend.hasFriend(faction));
    }

    @Test public void testCannotDealDamage() {
        MockWarrior guerrier = new MockWarrior("Garen");
        MockWarrior ninja = new MockWarrior("Akali");
        Faction faction = new Faction("Demacia");
        Faction ionia = new Faction("Ionia");
        guerrier.joinFaction(faction);
        ninja.joinFaction(ionia);

        faction.addFriend(ionia);

        guerrier.attack(ninja);

        Assert.assertEquals(ninja.getHealth(), 100);
    }

    @Test public void testCanDealDamage() {
        MockWarrior guerrier = new MockWarrior("Garen");
        MockWarrior noxus = new MockWarrior("Darius");
        Faction faction = new Faction("Demacia");
        Faction nox = new Faction("Noxus");
        guerrier.joinFaction(faction);
        noxus.joinFaction(nox);

        guerrier.attack(noxus);

        Assert.assertNotEquals(noxus.getHealth(), 100);
    }

    @Test
    public void testHealFriendFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        MockPriest pretre = new MockPriest("Lux");
        Faction faction = new Faction("Demacia");
        Faction ally = new Faction("Sous-Demacia");

        faction.addFriend(ally);

        guerrier.joinFaction(faction);
        guerrier.setHealth(50);
        pretre.joinFaction(ally);

        pretre.heal(guerrier);

        Assert.assertNotEquals(guerrier.getHealth(), 50);
    }

    @Test
    public void testCannotHealFaction() {
        MockWarrior guerrier = new MockWarrior("Garen");
        MockPriest pretre = new MockPriest("Soraka");
        Faction faction = new Faction("Demacia");
        Faction ally = new Faction("Chevre");

        guerrier.joinFaction(faction);
        guerrier.setHealth(50);
        pretre.joinFaction(ally);

        pretre.heal(guerrier);

        Assert.assertEquals(guerrier.getHealth(), 50);
    }
}
