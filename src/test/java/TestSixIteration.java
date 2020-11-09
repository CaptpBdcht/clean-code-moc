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
        Warrior guerrier = new Warrior("Garen");
        Warrior ninja = new Warrior("Akali");
        Faction faction = new Faction("Demacia");
        Faction ionia = new Faction("Ionia");
        guerrier.joinFaction(faction);
        ninja.joinFaction(ionia);

        faction.addFriend(ionia);

        guerrier.attack(ninja);

        Assert.assertEquals(ninja.getHealth(), 100);
    }

    @Test public void testCanDealDamage() {
        Warrior guerrier = new Warrior("Garen");
        Warrior noxus = new Warrior("Darius");
        Faction faction = new Faction("Demacia");
        Faction nox = new Faction("Noxus");
        guerrier.joinFaction(faction);
        noxus.joinFaction(nox);

        guerrier.attack(noxus);

        Assert.assertNotEquals(noxus.getHealth(), 100);
    }

    @Test
    public void testHealFriendFaction() {
        Warrior guerrier = new Warrior("Garen");
        Priest pretre = new Priest("Lux");
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
        Warrior guerrier = new Warrior("Garen");
        Priest pretre = new Priest("Soraka");
        Faction faction = new Faction("Demacia");
        Faction ally = new Faction("Chevre");

        guerrier.joinFaction(faction);
        guerrier.setHealth(50);
        pretre.joinFaction(ally);

        pretre.heal(guerrier);

        Assert.assertEquals(guerrier.getHealth(), 50);
    }

    // tester attack / heal friend
    // deplacer shareFaction() isAlly() ..etc dans Faction ?
    // deplacer les verifs de heal.ishealable() dans Entity.sethealth ???
    // mock pour sethealth dans les tests

}
