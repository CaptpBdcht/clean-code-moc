import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FifthIterationTest {

    @Test()
    @DisplayName("A Character can now damage non-character entities")
    public void NewCharacterHavntFaction() {
        FifthIterationTest tester = new FifthIterationTest(); // MyClass is tested

        // assert statements
        Warrior warrior = new Warrior("Mohamed");
        Entity entity = new Entity(200);

        warrior.attack(entity);

        assertTrue(entity.health < 200, "character must damage entity");
    }
    @Test()
    @DisplayName("Anything that has health is considered an Entity")
    public void AnythingHasHealthIsEntity() {
        FifthIterationTest tester = new FifthIterationTest(); // MyClass is tested

        // assert statements
        Warrior warrior = new Warrior("Mohamed");
        Priest priest = new Priest("Arnaud");

        boolean isEntity = warrior instanceof Entity && priest instanceof Entity;

        assertTrue(isEntity, "if have health must be considered as an Entity");
    }
    @Test()
    @DisplayName("An Entity cannot deal damage and cannot heal and cannot be healed and can't join Faction")
    public void EntityCannotDamageAndHeal() {
        FifthIterationTest tester = new FifthIterationTest(); // MyClass is tested

        // assert statements
        Entity entity = new Entity(200);

        assertTrue(!(entity instanceof Attribute), "entity must not deal damage and must not heal and can't join faction");
    }

}
