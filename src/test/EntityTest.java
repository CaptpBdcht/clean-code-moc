package test;
import main.Entity;
import main.Priest;
import main.Warrior;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntityTest {

    static final int OAKHEALTH = 300;
    Warrior floki = new Warrior("Floki");
    Priest athelstan = new Priest("Athlestan");
    Entity oak = new Entity(OAKHEALTH) {
        @Override
        public void die() {
            //nothing to do here
        }
    };

    @Test
    public void shouldStartToCutDownTheOakToMakeBoats(){
        int oakHealth = oak.getHealth();
        floki.attack(oak);
        assertTrue(oak.getHealth() < oakHealth);
    }

    @Test
    public void shouldBeCuttedDown(){
        while(oak.getHealth() > 0){
            floki.attack(oak);
        }
        assertEquals(oak.getState(), Entity.states.DEAD);
    }
}
