import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class EighthIterationTest {

    @Test()
    @DisplayName("A Character can now belong to an Assembly")
    public void CharacterMayBelongtoAssembly() {
        EighthIterationTest tester = new EighthIterationTest(); // MyClass is tested
        Warrior warrior = new Warrior("Mohamed");
        List<Roles> roles = new ArrayList<>();
        roles.add(Roles.Priest);
        roles.add(Roles.Warrior);
        Assembly assembly =new Assembly("ESGI", roles);
        warrior.joinAssembly(assembly);

        assertTrue(warrior.hasAassembly(), "character can now belong to an Assembly");

    }

    @Test()
    @DisplayName("Assembly has allowedRoles")
    public void AssemblyHaveAlloedRoles() {
        EighthIterationTest tester = new EighthIterationTest(); // MyClass is tested
        List<Roles> roles = new ArrayList<>();
        roles.add(Roles.Priest);
        roles.add(Roles.Warrior);
        Assembly assembly =new Assembly("ESGI", roles);

        assertTrue(!assembly.allowedRoles.isEmpty(), "Assembly must have allowedRoles");

    }

    @Test()
    @DisplayName("Character can only join one Assembly at a time")
    public void CharJoinOneAssembly() {
        EighthIterationTest tester = new EighthIterationTest(); // MyClass is tested

        Warrior warrior = new Warrior("Mohamed");
        List<Roles> roles = new ArrayList<>();
        roles.add(Roles.Priest);
        roles.add(Roles.Warrior);
        Assembly esgi = new Assembly("ESGI", roles);
        Assembly stud = new Assembly("Student", roles);
        warrior.joinAssembly(esgi);
        warrior.joinAssembly(stud);
        assertTrue(warrior.assembly.equals(esgi), "Assembly must have allowedRoles");

    }
}

