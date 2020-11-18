import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstIterationTest {

    @Test()
    @DisplayName("Can create Character")
    public void creationCharacter() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character character = new Character("Mohamed");
        assertTrue(character != null, "character not created");
    }

    @Test()
    @DisplayName("Character should have a name")
    public void characterNamed() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character character = new Character("Mohamed");
        assertTrue(character.name != null, "character should have name");
    }

    @Test()
    @DisplayName("Character should have a health initialized at 100")
    public void characterHealthInitalised() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character character = new Character("Mohamed");
        assertEquals(100, character.health, "character health should be 10O");
    }

    @Test()
    @DisplayName("Character health cannot go above 100")
    public void characterHealthMaxIs100() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character mohamed = new Character("Mohamed");
        Character arnaud = new Character("Arnaud");

        mohamed.heal(arnaud);

        assertEquals(100, arnaud.health, "character health should not go above 10O");
    }


    @Test()
    @DisplayName("Character must die when health is 0")
    public void characterHealthDie() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character character = new Character("Benoit");
        Character warrior = new Character("Mohamed");
        while (character.isAlive()) {
            warrior.attack(character);
        }


        assertTrue( character.state.toString().equals(States.dead.toString()), "Character must die when health is 0");
    }

    @Test()
    @DisplayName("Character and deal 1 damage point to its enemy's health")
    public void charactermake1domage() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Character("Arnaud");
        Character mohamed = new Character("Mohamed");

        arnaud.attack(mohamed);



        assertEquals( mohamed.health, 99, "Character must deal 1 damage point to its enemy's health");
    }

    @Test()
    @DisplayName("Character cannot deal damage to a dead enemy")
    public void characterCannotDamageDead() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Character("Arnaud");
        Character mohamed = new Character("Mohamed");
        while (mohamed.isAlive()) {
            arnaud.attack(mohamed);
        }
        assertEquals( mohamed.health, 0, "Character must not deal damage point to a dead enemy");
    }

    @Test()
    @DisplayName("Character can heal other")
    public void characterCanHealOther() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Character("Arnaud");
        Character mohamed = new Character("Mohamed");
        arnaud.attack(mohamed);
        arnaud.heal(mohamed);
        assertEquals( mohamed.health, 100, "Character must heal other");
    }

    @Test()
    @DisplayName("Character can heal itself")
    public void characterCanHealItself() {
        SecondIterationTest tester = new SecondIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Character("Arnaud");
        Character mohamed = new Character("Mohamed");
        arnaud.attack(mohamed);
        mohamed.heal(mohamed);
        assertEquals( mohamed.health, 100, "Character must heal itself");
    }

}