import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NinethIterationTest {


    @Test()
    @DisplayName("An Assembly should have a master, which is the first Character to join the Assembly")
    public void AssembèHaveMaster() {
        NinethIterationTest tester = new NinethIterationTest(); // MyClass is tested

        // assert statements
        List<Roles> roles = new ArrayList<>();
        roles.add(Roles.Warrior);
        Assembly stud = new Assembly("stud", roles);

        Warrior mohamed = new  Warrior("Mohamed");

        mohamed.joinFaction(stud);


        assertTrue(stud.master.equals(mohamed),"the first Character to join the Assembly sould be the master");

    }

    @Test()
    @DisplayName("The master is the only one allowed to update the Assembly name.")
    public void MasterCanRenameAssembly() {
        NinethIterationTest tester = new NinethIterationTest(); // MyClass is tested

        // assert statements
        List<Roles> roles = new ArrayList<>();
        roles.add(Roles.Warrior);
        Assembly stud = new Assembly("stud", roles);

        Warrior mohamed = new  Warrior("Mohamed");
        Warrior arnaud = new  Warrior("Arnaud");
        Warrior thierry = new  Warrior("Thierry");

        mohamed.joinFaction(stud);
        arnaud.joinFaction(stud);
        thierry.joinFaction(stud);
        mohamed.renameAssembly("MOC4");
        thierry.renameAssembly("MOC5");

        assertEquals(stud.name, "MOC4" ,"master must be the only one allowed to update the Assembly name.");

    }
    @Test()
    @DisplayName("When the master leaves an Assembly, another random master is automatically selected")
    public void RandomMasterIfMasterleave() {
        NinethIterationTest tester = new NinethIterationTest(); // MyClass is tested

        // assert statements
        List<Roles> roles = new ArrayList<>();
        roles.add(Roles.Warrior);
        Assembly stud = new Assembly("stud", roles);

        Warrior mohamed = new  Warrior("Mohamed");
        Warrior arnaud = new  Warrior("Arnaud");
        Warrior thierry = new  Warrior("Thierry");

        mohamed.joinFaction(stud);
        arnaud.joinFaction(stud);
        thierry.joinFaction(stud);
        mohamed.leaveAssembly(stud);

        assertTrue(!stud.master.equals(mohamed),"if the master leaves an Assembly, another random master is automatically selected");

    }

}
