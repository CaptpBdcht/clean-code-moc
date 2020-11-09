package test;
import main.Entity;
import main.Faction;
import main.Priest;
import main.Warrior;
import org.junit.Test;
import static org.junit.Assert.*;

public class PriestTest {
    Priest athelstan = new Priest("Athelstan");
    Warrior ragnar = new Warrior("Ragnar");
    Faction vikings = new Faction("Vikings");

    @Test
    public void shouldBeAlive(){
        assertEquals(athelstan.getState(), Entity.states.ALIVE);
    }

    @Test
    public void shouldTryToAttack() {
        athelstan.attack(ragnar);
        assertEquals(ragnar.getHealth(), 100);
    }

    @Test
    public void shouldHealRagnar(){
        ragnar.joinFaction(vikings);
        athelstan.joinFaction(vikings);
        while(ragnar.getHealth() == 100) {
            ragnar.attack(ragnar);
        }
        int ragnarHealth = ragnar.getHealth();
        athelstan.heal(ragnar);
        assertTrue(ragnar.getHealth() > ragnarHealth);
    }


}
