package test;

import main.Assembly;
import main.Priest;
import main.Warrior;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class AssemblyTest extends DataTest{

    ArrayList<Class<?>> allowedRoles = new ArrayList<Class<?>>(Collections.singletonList(Warrior.class));
    Assembly scandinavians = new Assembly("Scandinavians", allowedRoles);

    ArrayList<Class<?>> enAllowedRoles = new ArrayList<>(Collections.singletonList(Warrior.class));
    Assembly english = new Assembly("English", enAllowedRoles);

    @Test
    public void shouldHaveTorsteinAsMaster(){
        torstein.joinAssembly(scandinavians);
        porunn.joinAssembly(scandinavians);
        assertEquals(scandinavians.getMaster(), torstein);
    }

    @Test
    public void shouldElectANewMaster(){
        torstein.joinAssembly(scandinavians);
        porunn.joinAssembly(scandinavians);
        ragnar.joinAssembly(scandinavians);
        floki.joinAssembly(scandinavians);
        torstein.leaveAssembly();
        assertNotEquals(scandinavians.getMaster(), torstein);
        assertNotNull(scandinavians.getMaster());
        System.out.println(scandinavians.getMaster().getName());
    }

    @Test
    public void shouldMasterBeAllowedToUpdate(){
        porunn.joinAssembly(scandinavians);
        ragnar.joinAssembly(scandinavians);
        floki.joinAssembly(scandinavians);
        floki.updateAssemblyName("Vikings");
        assertEquals(scandinavians.getName(), "Scandinavians");
    }

    @Test
    public void shouldBeAbandonned(){
        porunn.joinAssembly(scandinavians);
        ragnar.joinAssembly(scandinavians);
        ragnar.leaveAssembly();
        porunn.leaveAssembly();
        assertNull(scandinavians.getMaster());
    }

    @Test
    public void shouldOnlyAcceptWarriors(){
        athelstan.joinAssembly(scandinavians);
        assertNull(athelstan.getAssembly());
    }

    @Test
    public void shouldChangeAssembly(){
        porunn.joinAssembly(english);
        porunn.joinAssembly(scandinavians);
        assertEquals(porunn.getAssembly(), scandinavians);
    }
}
