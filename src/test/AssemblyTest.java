package test;

import main.Assembly;
import main.Priest;
import main.Warrior;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class AssemblyTest extends DataTest{

    ArrayList<Class<?>> allowedRoles = new ArrayList<Class<?>>(Collections.singletonList(Warrior.class));
    Assembly scandinavians = new Assembly("Scandinavians", allowedRoles);

    @Test
    public void shouldHaveTorsteinAsMaster(){
        torstein.joinAssembly(scandinavians);
        porunn.joinAssembly(scandinavians);
        assertEquals(scandinavians.getMaster(), torstein);
    }

    @Test
    public void shouldOnlyAcceptWarriors(){
        athelstan.joinAssembly(scandinavians);
        assertNull(athelstan.getAssembly());
    }
}
