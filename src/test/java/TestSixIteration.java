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

    // tester attack / heal friend
    // deplacer shareFaction() isAlly() ..etc dans Faction ?
    // deplacer les verifs de heal.ishealable() dans Entity.sethealth ???
    // mock pour sethealth dans les tests

}
