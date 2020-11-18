import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SecondIterationTest {

    @Test()
    @DisplayName("Can create Warrior")
    public void creationWarrior() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Warrior warrior = new Warrior("Mohamed");
        assertTrue(warrior != null, "warrior not created");
    }

    @Test()
    @DisplayName("Warrior is a character")
    public void WarriorIsCharacter() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Warrior warrior = new Warrior("Mohamed");
        assertTrue(warrior instanceof Character, "warrior must be a character");
    }
    @Test()
    @DisplayName("Warrior deals between 1 an 9 damage")
    public void warriorDealBetween1and9() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Warrior("Arnaud");
        Character mohamed = new Character("Mohamed");
        arnaud.attack(mohamed);

        assertTrue(mohamed.health < 100 && mohamed.health > 90,  "warrior must deals deamage between 1 and 9");
    }

    @Test()
    @DisplayName("Warrior can damage itself")
    public void warriorCanDamageItself() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Warrior("Arnaud");
        arnaud.attack(arnaud);

        assertTrue(arnaud.health < 100 , "warrior must deals damage itself");
    }

    @Test()
    @DisplayName("Warrior can heal other")
    public void warriorCannotHealOther() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Warrior("Arnaud");
        Character mohamed = new Character("Mohamed");
        arnaud.attack(mohamed);
        int healthBeforeHeal = mohamed.health;
        arnaud.heal(mohamed);
        assertEquals( mohamed.health, healthBeforeHeal , "Warrior cannot heal other");
    }

    @Test()
    @DisplayName("Warrior can heal itself")
    public void warriorCanHealItself() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Character("Arnaud");
        Character mohamed = new Warrior("Mohamed");
        arnaud.attack(mohamed);
        mohamed.heal(mohamed);

        assertEquals( mohamed.health , 100, "Warrior must heal itself");
    }

}