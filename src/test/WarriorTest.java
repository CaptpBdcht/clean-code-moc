package test;

import main.Entity;
import main.Priest;
import main.Warrior;
import org.junit.Test;
import static org.junit.Assert.*;

public class WarriorTest {
    Warrior ragnar, lagertha, ecbert, floki, rollo, torstein, porunn;
    Priest athelstan;

    @Test
    public void shouldCreateWarriors(){
        this.ragnar = new Warrior("Ragnar");
        this.lagertha = new Warrior("Lagertha");
        this.ecbert = new Warrior("Ecbert");
        this.floki = new Warrior("Floki");
        this.rollo = new Warrior("Rollo");
        this.torstein = new Warrior("Torstein");
        this.porunn = new Warrior("Porunn");
        this.athelstan = new Priest("Athelstan");

        assertEquals(ragnar.getState(), Entity.states.ALIVE);
        assertEquals(lagertha.getState(), Entity.states.ALIVE);
        assertEquals(ecbert.getState(), Entity.states.ALIVE);
        assertEquals(floki.getState(), Entity.states.ALIVE);
        assertEquals(rollo.getState(), Entity.states.ALIVE);
        assertEquals(torstein.getState(), Entity.states.ALIVE);
        assertEquals(porunn.getState(), Entity.states.ALIVE);
        assertEquals(athelstan.getState(), Entity.states.ALIVE);
    }
    
    //@Test
    //public void
}
