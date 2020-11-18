import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SeventhIterationTest {

    @Test()
    @DisplayName("A Character may now belong to one or more Factions")
    public void CharacterMayBelongtoOneOrMoreFaction() {
        SixthIterationTest tester = new SixthIterationTest(); // MyClass is tested

        // assert statements
        Faction stud = new Faction("stud");
        Faction teach = new Faction("teach");

        Warrior mohamed = new  Warrior("Mohamed");

        mohamed.joinFaction(teach);
        mohamed.joinFaction(stud);


        assertTrue(mohamed.factions.contains(stud) && mohamed.factions.contains(teach), "Character may now belong to one or more Factions");
    }
}
