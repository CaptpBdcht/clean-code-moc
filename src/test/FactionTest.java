package test;

import org.junit.Test;
import static org.junit.Assert.*;

public class FactionTest extends DataTest {

    @Test
    public void createScandinavianFaction(){
        assertEquals("Northmen",northmen.getName());
    }
    @Test
    public void getSomeMembers() {
        ragnar.joinFaction(northmen);
        ecbert.joinFaction(northmen);
        assertEquals(northmen.getMembers().size(), 2);
    }
}
