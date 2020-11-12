package test;

import main.Entity;
import main.Priest;
import main.Warrior;
import org.junit.Test;
import static org.junit.Assert.*;

public class WarriorTest extends DataTest {

    @Test
    public void shouldBeAlive(){
        assertEquals(ragnar.getState(), Entity.states.ALIVE);
        assertEquals(ecbert.getState(), Entity.states.ALIVE);
    }

    @Test
    public void shouldAttack(){
        ragnar.attack(ecbert);
        assertTrue(ecbert.getHealth() <= 100 && ecbert.getHealth() >= 91);
    }

    @Test
    public void shouldHurtHimself(){
        ragnar.attack(ragnar);
        assertTrue(ragnar.getHealth() <= 100 && ragnar.getHealth() >= 91);
    }

    @Test
    public void shouldHealEcbert(){
        int ecbertHealth = this.ecbert.getHealth();
        ragnar.heal(ecbert);
        assertEquals(ecbertHealth, ecbert.getHealth());
    }

    @Test
    public void shouldHealHimself(){
        while(ragnar.getHealth() == 100){
            ecbert.attack(ragnar);
        }
        int ragnarHealth =ragnar.getHealth();
        ragnar.heal(ragnar);
        assertTrue(ragnar.getHealth() > ragnarHealth);
    }
}
