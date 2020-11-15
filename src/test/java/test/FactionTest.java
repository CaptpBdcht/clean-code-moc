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
        northmen.addFriend(wessex);
        assertNotNull(wessex.getFriends());
        assertNotNull(northmen.getFriends());
    }

    @Test
    public void shouldLeaveFaction(){
        ragnar.joinFaction(northmen);
        ragnar.leaveFaction(northmen);
        assertFalse(ragnar.getFactions().contains(northmen));
    }

    @Test
    public void shouldHealFriends(){
        athelstan.joinFaction(northmen);
        floki.joinFaction(northmen);
        while(floki.getHealth() == 100){
            floki.attack(floki);
        }
        int currentFlokiHeath = floki.getHealth();
        athelstan.heal(floki);
        assertTrue(floki.getHealth() > currentFlokiHeath);
    }

    @Test
    public void ShouldNotHeal(){
        athelstan.joinFaction(northmen);
        floki.joinFaction(wessex);
        while(floki.getHealth() == 100){
            floki.attack(floki);
        }
        int currentFlokiHeath = floki.getHealth();
        athelstan.heal(floki);
        assertEquals(floki.getHealth(), currentFlokiHeath);
    }

    @Test
    public void shouldHealFriend(){
        northmen.addFriend(wessex);
        athelstan.joinFaction(wessex);
        floki.joinFaction(northmen);
        while(floki.getHealth() == 100){
            floki.attack(floki);
        }
        int currentFlokiHeath = floki.getHealth();
        athelstan.heal(floki);
        assertTrue(floki.getHealth() > currentFlokiHeath);
    }
}