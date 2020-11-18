import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SixthIterationTest {

    @Test()
    @DisplayName("A Faction may now declare one or more Factions as friends")
    public void FactionMayHaveAlledFaction() {
        SixthIterationTest tester = new SixthIterationTest(); // MyClass is tested

        // assert statements
        Faction stud = new Faction("stud");
        Faction teach = new Faction("teach");
        List<Faction> studalledFactions = new ArrayList();
        List<Faction> teachalledFactions = new ArrayList();
        teachalledFactions.add(stud);
        studalledFactions.add(teach);
        stud.addAlliedFactions(studalledFactions);
        teach.addAlliedFactions(teachalledFactions);

        boolean hasCorrectAlledFaction = stud.alliedFactions.contains(teach) && teach.alliedFactions.contains(stud);


        assertTrue(hasCorrectAlledFaction, "faction may have allied Faction");
    }

    @Test()
    @DisplayName("A Character cannot deal damage to another Character of the same Faction or of one of its friends")
    public void CharacterCannotDamageAlly() {
        SixthIterationTest tester = new SixthIterationTest(); // MyClass is tested

        // assert statements
        Optional<Faction> stud = Optional.of(new Faction("stud"));
        Optional<Faction>  teach = Optional.of(new Faction("teach"));
        List<Faction> studalledFactions = new ArrayList();
        List<Faction> teachalledFactions = new ArrayList();
        teachalledFactions.add(stud.get());
        studalledFactions.add(teach.get());
        stud.get().addAlliedFactions(studalledFactions);
        teach.get().addAlliedFactions(teachalledFactions);
        Warrior mohamed = new Warrior("Mohamed");
        Warrior arnaud = new Warrior("Arnaud");
        mohamed.joinFaction(teach);
        arnaud.joinFaction(stud);

        arnaud.attack(mohamed);


        assertEquals(mohamed.health, 100, "A Character must not damage character of the same Faction or of one of its friends" );



    }
    @Test()
    @DisplayName("A Character cannot deal damage to another Character of the same Faction or of one of its friends")
    public void CharacterCanHealAllyOnly() {
        SixthIterationTest tester = new SixthIterationTest(); // MyClass is tested

        // assert statements
        Optional<Faction>  stud = Optional.of(new Faction("stud"));
        Optional<Faction>  teach = Optional.of(new Faction("teach"));
        List<Faction> studalledFactions = new ArrayList();
        List<Faction> teachalledFactions = new ArrayList();
        teachalledFactions.add(stud.get());
        studalledFactions.add(teach.get());
        stud.get().addAlliedFactions(studalledFactions);
        teach.get().addAlliedFactions(teachalledFactions);
        Priest mohamed = new Priest("Mohamed");
        Warrior arnaud = new Warrior("Arnaud");
        mohamed.joinFaction(teach);
        arnaud.joinFaction(stud);
        arnaud.attack(arnaud);
        int healthBeforHeal = arnaud.health;
        mohamed.heal(arnaud);


        assertEquals(arnaud.health, healthBeforHeal, "A Character must heal character of the same Faction or of one of its friends" );



    }
}
