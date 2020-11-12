import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestEightIteration {
    @Test
    public void testNoAssembly() {
        Warrior guerrier = new Warrior("Garen");
        Assert.assertNull(guerrier.getAssembly());
    }

    @Test
    public void testNoMembers() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("La Confrérie des Chevaliers Noirs", roles);
        Assert.assertTrue(assembly.getMembers().isEmpty());
    }

    @Test
    public void testJoinAssembly() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        guerrier.joinAssembly(assembly);

        Assert.assertEquals(guerrier.getAssembly(), assembly);
    }

    @Test
    public void cannotJoinAssembly(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Priest);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        guerrier.joinAssembly(assembly);
        Assert.assertFalse( assembly.equals(guerrier.getAssembly()) && assembly.getMembers().contains(guerrier));
    }

    @Test
    public void testAddMember(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        guerrier.joinAssembly(assembly);

        Assert.assertTrue(assembly.hasMember(guerrier));
    }

    @Test
    public void testLeaveAssembly() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        guerrier.joinAssembly(assembly);
        guerrier.leaveAssembly(assembly);

        Assert.assertNull(guerrier.getAssembly());
    }

    @Test
    public void testDeleteMember() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        guerrier.joinAssembly(assembly);
        guerrier.leaveAssembly(assembly);

        Assert.assertFalse(assembly.hasMember(guerrier));
    }

    @Test
    public void testAttackSameAssembly() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        roles.add(Role.Priest);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        Priest pretre = new Priest("Lux");
        guerrier.joinAssembly(assembly);
        pretre.joinAssembly(assembly);

        guerrier.attack(pretre);

        Assert.assertEquals(pretre.getHealth(), 100);
    }

    @Test
    public void testAttackNotSameAssembly() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);

        Assembly assembly = new Assembly("Demacia", roles);
        Assembly enemyAssembly = new Assembly("Noxus", roles);

        Warrior guerrier = new Warrior("Garen");
        Warrior enemy = new Warrior("Darius");

        guerrier.joinAssembly(assembly);
        enemy.joinAssembly(enemyAssembly);

        guerrier.attack(enemy);

        Assert.assertNotEquals(enemy.getHealth(), 100);
    }

    @Test
    public void testHealSameAssembly() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        roles.add(Role.Priest);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        Priest pretre = new Priest("Lux");
        guerrier.joinAssembly(assembly);
        guerrier.setHealth(50);
        pretre.joinAssembly(assembly);

        pretre.heal(guerrier);

        Assert.assertNotEquals(guerrier.getHealth(), 50);
    }

    @Test
    public void testHealNotSameAssembly() {
        ArrayList<Role> rolesAssembly = new ArrayList<>();
        rolesAssembly.add(Role.Priest);

        ArrayList<Role> rolesEnemyAssembly = new ArrayList<>();
        rolesEnemyAssembly.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", rolesAssembly);
        Assembly enemyAssembly = new Assembly("Noxus", rolesEnemyAssembly);

        Priest pretre = new Priest("Lux");
        Warrior enemy = new Warrior("Darius");
        pretre.joinAssembly(assembly);
        enemy.joinAssembly(enemyAssembly);

        enemy.setHealth(50);

        pretre.heal(enemy);

        Assert.assertEquals(enemy.getHealth(), 50);
    }

    @Test
    public void testAddFriend(){
        ArrayList<Role> rolesAssembly = new ArrayList<>();
        rolesAssembly.add(Role.Priest);

        ArrayList<Role> rolesFriendAssembly = new ArrayList<>();
        rolesFriendAssembly.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", rolesAssembly);
        Assembly friend = new Assembly("Noxus", rolesFriendAssembly);

        assembly.addFriend(friend);
        Assert.assertTrue(assembly.hasFriend(friend) && friend.hasFriend(assembly));
    }

    @Test public void testRemoveFriend(){
        ArrayList<Role> rolesAssembly = new ArrayList<>();
        rolesAssembly.add(Role.Priest);

        ArrayList<Role> rolesFriendAssembly = new ArrayList<>();
        rolesFriendAssembly.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", rolesAssembly);
        Assembly friend = new Assembly("Noxus", rolesFriendAssembly);

        assembly.addFriend(friend);
        assembly.removeFriend(friend);
        Assert.assertFalse(assembly.hasFriend(friend) && friend.hasFriend(assembly));
    }

    @Test public void testCannotDamageFriend() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);

        ArrayList<Role> rolesFriendAssembly = new ArrayList<>();
        Assembly assembly = new Assembly("Demacia", roles);
        Assembly friend = new Assembly("Noxus", rolesFriendAssembly);

        Warrior guerrier = new Warrior("Garen");
        Warrior ninja = new Warrior("Akali");
        guerrier.joinAssembly(assembly);
        ninja.joinAssembly(friend);

        assembly.addFriend(friend);

        guerrier.attack(ninja);

        Assert.assertEquals(ninja.getHealth(), 100);
    }

    @Test
    public void testHealFriend() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Priest);

        ArrayList<Role> rolesFriendAssembly = new ArrayList<>();
        Assembly assembly = new Assembly("Demacia", roles);
        Assembly friend = new Assembly("Noxus", rolesFriendAssembly);

        Warrior guerrier = new Warrior("Garen");
        Priest pretre = new Priest("Lux");

        assembly.addFriend(friend);

        guerrier.joinAssembly(assembly);
        guerrier.setHealth(50);
        pretre.joinAssembly(friend);

        pretre.heal(guerrier);

        Assert.assertNotEquals(guerrier.getHealth(), 50);
    }

}
