import Enum.Role;
import Groups.Assembly;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestAssembly {

    @Test
    public void testNoAssembly() {
        MockWarrior guerrier = new MockWarrior("Garen");
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
    public void testCanJoinAssembly() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        MockWarrior guerrier = new MockWarrior("Garen");
        guerrier.joinAssembly(assembly);

        Assert.assertTrue(assembly.equals(guerrier.getAssembly()) && assembly.hasMember(guerrier));
    }

    @Test
    public void testCannotJoinAssembly(){
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Priest);
        Assembly assembly = new Assembly("Demacia", roles);

        MockWarrior guerrier = new MockWarrior("Garen");
        guerrier.joinAssembly(assembly);
        Assert.assertFalse( assembly.equals(guerrier.getAssembly()) && assembly.hasMember(guerrier));
    }

    @Test
    public void testLeaveAssembly() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        MockWarrior guerrier = new MockWarrior("Garen");
        guerrier.joinAssembly(assembly);
        guerrier.leaveAssembly(assembly);

        Assert.assertFalse(assembly.equals(guerrier.getAssembly()) && assembly.hasMember(guerrier));
    }

    @Test
    public void testAttackSameAssembly() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        roles.add(Role.Priest);
        Assembly assembly = new Assembly("Demacia", roles);

        MockWarrior guerrier = new MockWarrior("Garen");
        MockPriest pretre = new MockPriest("Lux");
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

        MockWarrior guerrier = new MockWarrior("Garen");
        MockWarrior enemy = new MockWarrior("Darius");

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

        MockWarrior guerrier = new MockWarrior("Garen");
        MockPriest pretre = new MockPriest("Lux");
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

        MockPriest pretre = new MockPriest("Lux");
        MockWarrior enemy = new MockWarrior("Darius");
        pretre.joinAssembly(assembly);
        enemy.joinAssembly(enemyAssembly);

        enemy.setHealth(50);

        pretre.heal(enemy);

        Assert.assertEquals(enemy.getHealth(), 50);
    }

    @Test
    public void testFirstToJoinIsMaster() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        MockWarrior guerrier = new MockWarrior("Garen");
        guerrier.joinAssembly(assembly);

        Assert.assertEquals(assembly.getMaster(), guerrier);
    }

    @Test
    public void testModifyName() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        MockWarrior guerrier = new MockWarrior("Garen");
        MockWarrior guerrierSecond = new MockWarrior("Joseph");
        guerrier.joinAssembly(assembly);
        guerrierSecond.joinAssembly(assembly);

        String newName = "NewDemacia !!!!";

        assembly.updateName(guerrier, newName);

        Assert.assertEquals(assembly.getName(), newName);
    }

    @Test
    public void testCannotModifyName() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        MockWarrior guerrier = new MockWarrior("Garen");
        MockWarrior guerrierSecond = new MockWarrior("Joseph");
        guerrier.joinAssembly(assembly);
        guerrierSecond.joinAssembly(assembly);

        String newName = "NewDemacia !!!!";

        assembly.updateName(guerrierSecond, newName);

        Assert.assertNotEquals(assembly.getName(), newName);
    }

    @Test
    public void testRandomMaster() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        MockWarrior guerrier = new MockWarrior("Garen");
        MockWarrior guerrierSecond = new MockWarrior("Joseph");
        MockWarrior guerrierDeTroie = new MockWarrior("Jonathan");
        MockWarrior guerrierFourth = new MockWarrior("Giuseppe");

        guerrier.joinAssembly(assembly);
        guerrierSecond.joinAssembly(assembly);
        guerrierDeTroie.joinAssembly(assembly);
        guerrierFourth.joinAssembly(assembly);

        guerrier.leaveAssembly(assembly);
        System.out.println(assembly.getMaster().getName());
        Assert.assertTrue(assembly.getMaster() != guerrier && assembly.getMaster() != null);
    }

}
