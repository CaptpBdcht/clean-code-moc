package test;
import org.delageguillan.KataRPG.Entity;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest extends DataTest {

    static final int OAKHEALTH = 300;
    Entity oak = new Entity(OAKHEALTH) {
        @Override
        public void die() {
            //nothing to do here
        }
    };

    @Test
    public void shouldStartToCutDownTheOakToMakeBoats(){
        while(oak.getHealth() == OAKHEALTH){
            floki.attack(oak);
        }
        floki.attack(oak);
        assertTrue(oak.getHealth() < OAKHEALTH);
    }

    @Test
    public void shouldBeCuttedDown(){
        while(oak.getHealth() > 0){
            floki.attack(oak);
        }
        assertEquals(oak.getState(), Entity.states.DEAD);
    }
}
