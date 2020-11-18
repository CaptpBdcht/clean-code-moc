import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FourthIterationTest {


    @Test()
    @DisplayName("A newly created Character doesn't belong to any Faction")
    public void NewCharacterHavntFaction() {
        FourthIterationTest tester = new FourthIterationTest(); // MyClass is tested

        // assert statements
        Priest priest = new Priest("Mohamed");

        assertTrue(!priest.hasFactions(), "character must not have a faction");
    }
    @Test()
    @DisplayName("A Faction should have a name")
    public void FactionHasName() {
        FourthIterationTest tester = new FourthIterationTest(); // MyClass is tested

        // assert statements
        Faction faction = new Faction("stud");

        assertTrue(!faction.name.isEmpty(), "faction must have a name ");
    }

    @Test()
    @DisplayName("A Character can join a Faction")
    public void CharacterCanJoinFaction() {
        FourthIterationTest tester = new FourthIterationTest(); // MyClass is tested

        // assert statements
        Faction faction = new Faction("stud");
        Priest priest = new Priest("Mohamed");
        priest.joinFaction(faction);


        assertTrue(priest.factions.contains(faction), "character can join a Faction");
    }

    @Test()
    @DisplayName("A Character cannot deal damage to another Character of the same Faction")
    public void CharCannotDamageCharInSameFaction() {
        FourthIterationTest tester = new FourthIterationTest(); // MyClass is tested

        // assert statements
        Faction faction = new Faction("stud");
        Priest priest = new Priest("Mohamed");
        Warrior warrior = new Warrior("Arnaud");
        priest.joinFaction(faction);
        warrior.joinFaction(faction);
        warrior.attack(priest);


        assertEquals(priest.health, 100, "character must not deal damage to another Character of the same Faction");
    }
    @Test()
    @DisplayName("A Character can only heal another Character of the same Faction.")
    public void CharCanHealCharInSameFaction() {
        FourthIterationTest tester = new FourthIterationTest(); // MyClass is tested

        // assert statements
        Faction stud = new Faction("stud");
        Faction faction = new Faction("overwatch");
        Priest priest = new Priest("Mohamed");
        Warrior warrior = new Warrior("Arnaud");
        priest.joinFaction(faction);
        warrior.joinFaction(faction);
        warrior.attack(warrior);
        int healthBeforeHeal = warrior.health;
        priest.heal(warrior);


        assertEquals(warrior.health, healthBeforeHeal, "character must heal character of the same Faction");
    }

    @Test()
    @DisplayName("A Character can leave a Faction")
    public void CharacterCanLeaveFaction() {
        FourthIterationTest tester = new FourthIterationTest(); // MyClass is tested

        // assert statements
        Faction faction = new Faction("stud");
        Priest priest = new Priest("Mohamed");
        priest.joinFaction(faction);
        priest.leaveFaction(faction);


        assertTrue(!priest.hasFactions(), "character can join a Faction");
    }
}
