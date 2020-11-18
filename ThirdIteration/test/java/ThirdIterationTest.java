import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThirdIterationTest {

    @Test()
    @DisplayName("Can create Priest")
    public void creationWarrior() {
        ThirdIterationTest tester = new ThirdIterationTest(); // MyClass is tested

        // assert statements
        Priest priest = new Priest("Mohamed");
        assertTrue(priest != null, "Priest must be created");
    }

    @Test()
    @DisplayName("Priest is a character")
    public void PriestIsCharacter() {
        ThirdIterationTest tester = new ThirdIterationTest(); // MyClass is tested

        // assert statements
        Priest priest = new Priest("Mohamed");
        assertTrue(priest instanceof Character, "priest must be a character");
    }
    @Test()
    @DisplayName("Priest cannot deal any damage")
    public void warriorDealBetween1and9() {
        ThirdIterationTest tester = new ThirdIterationTest(); // MyClass is tested

        // assert statements
        Character arnaud = new Priest("Arnaud");
        Character mohamed = new Character("Mohamed");
        arnaud.attack(mohamed);

        assertEquals(mohamed.health , 100, "priest must not deals any damage");
    }


    @Test()
    @DisplayName("heal beatween 5 and 10")
    public void priestCannotHealOther() {
        ThirdIterationTest tester = new ThirdIterationTest(); // MyClass is tested

        // assert statements
        Warrior arnaud = new Warrior("Arnaud");
        Priest mohamed = new Priest("Mohamed");
        while(arnaud.health > 60){
            arnaud.attack(arnaud);
        }
        int healthBeforeHeal = arnaud.health;
        mohamed.heal(arnaud);
        assertTrue((arnaud.health >= (healthBeforeHeal + 5)) && (arnaud.health <= (healthBeforeHeal + 10)), "Priest must heal beatween 5 and 10");
    }

    // Character can't exist without job

}