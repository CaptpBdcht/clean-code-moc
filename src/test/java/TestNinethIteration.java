import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestNinethIteration {

    @Test
    public void testFirstMaster() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        guerrier.joinAssembly(assembly);

        Assert.assertEquals(assembly.getMaster(), guerrier);
    }

    @Test
    public void testModifyName() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(Role.Warrior);
        Assembly assembly = new Assembly("Demacia", roles);

        Warrior guerrier = new Warrior("Garen");
        Warrior guerrierSecond = new Warrior("Joseph");
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

        Warrior guerrier = new Warrior("Garen");
        Warrior guerrierSecond = new Warrior("Joseph");
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

        Warrior guerrier = new Warrior("Garen");
        Warrior guerrierSecond = new Warrior("Joseph");
        Warrior guerrierDeTroie = new Warrior("Jonathan");
        Warrior guerrierFourth = new Warrior("Giuseppe");

        guerrier.joinAssembly(assembly);
        guerrierSecond.joinAssembly(assembly);
        guerrierDeTroie.joinAssembly(assembly);
        guerrierFourth.joinAssembly(assembly);

        guerrier.leaveAssembly(assembly);

        Assert.assertTrue(assembly.getMaster() != guerrier && assembly.getMaster() != null);
    }

}
