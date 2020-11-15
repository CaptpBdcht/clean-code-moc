import Enum.Role;
import Groups.Assembly;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestNinethIteration {

    @Test
    public void testFirstMaster() {
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
