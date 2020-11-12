package test;

import org.junit.Test;
import static org.junit.Assert.*;

public class FactionTest extends DataTest {

    @Test
    public void createScandinavianFaction(){
        assertEquals("Northmen",northmen.getName());
    }
    @Test
    public void shouldGetSomeMembers() {
        ragnar.joinFaction(northmen);
        ecbert.joinFaction(northmen);
        System.out.println(northmen.getMembers());
        assertEquals(northmen.getMembers().size(), 2);
    }

    @Test
    public void shouldNotAttackingFriends(){
        ragnar.joinFaction(northmen);
        floki.joinFaction(northmen);
        ragnar.attack(floki);
        assertEquals(floki.getHealth(), 100);
    }

    @Test
    public void shouldAddFriendsFaction(){

    }
}
