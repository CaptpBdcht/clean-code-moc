package org.delageguillan.KataRPG;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Warrior ragnar = new Warrior("Ragnar");
        Warrior lagertha = new Warrior("Lagertha");
        Priest athelstan = new Priest("Athelstan");
        Warrior ecbert = new Warrior("Ecbert");
        Warrior floki = new Warrior("Floki");
        Warrior rollo = new Warrior("Rollo");
        Warrior torstein = new Warrior("Torstein");
        Warrior porunn = new Warrior("Porunn");

        Faction northmen = new Faction("Northmen");
        Faction wessex = new Faction("Wessex");

        ArrayList<Class<?>> scandinavianAllowedRoles = new ArrayList<Class<?>>();
        scandinavianAllowedRoles.add(Warrior.class);
        Assembly scandinavianAssembly = new Assembly("Scandinavian", scandinavianAllowedRoles);

        ArrayList<Class<?>> englandAllowedRoles = new ArrayList<Class<?>>();
        englandAllowedRoles.add(Priest.class);
        englandAllowedRoles.add(Warrior.class);
        Assembly englandAssembly = new Assembly("England", englandAllowedRoles);

        System.out.println("Ragnar and Lagertha join Northmen faction, and athelstan join northumbia faction");
        ragnar.joinFaction(northmen);
        lagertha.joinFaction(northmen);
        athelstan.joinFaction(wessex);
        ecbert.joinFaction(wessex);
        System.out.println(ragnar.status());
        System.out.println(lagertha.status());
        System.out.println(athelstan.status());

        System.out.println("List of northmen member : " + northmen.getMembers());
        System.out.println("List of wessex member : " + wessex.getMembers());

        System.out.println("\nRagnar tries to hit Lagherta");
        ragnar.attack(lagertha);
        System.out.println(lagertha.status());

        ragnar.health = 90;

        System.out.println("\nAthelstan tries to heal Ragnar");
        System.out.println(ragnar.status());
        athelstan.heal(ragnar);
        System.out.println(ragnar.status());

        System.out.println("\nRagnar hit Ecbert and Athelstan heal Ecbert");
        ragnar.attack(ecbert);
        System.out.println(ecbert.status());
        athelstan.heal(ecbert);
        System.out.println(ecbert.status());

        System.out.println("\nNow northem and wessex faction are friend");
        northmen.addFriend(wessex);
        System.out.println("List of northmen friend faction : " + northmen.getFriends());
        System.out.println("List of wessex friend faction : " + wessex.getFriends());

        System.out.println("\nNow ragnar tries to hit ecbert");
        ragnar.attack(ecbert);

        System.out.println("\nNow Athelstan tries to heal ragnar");
        System.out.println(ragnar.status());
        athelstan.heal(ragnar);
        System.out.println(ragnar.status());

        System.out.println("\nAthelstan keep his faction but also joined Ragnar's");
        System.out.println(athelstan.status());
        athelstan.joinFaction(northmen);
        System.out.println(athelstan.status());

        System.out.println("\nNow Athelstan should be able to heal Ragnar");
        System.out.println(ragnar.status());
        athelstan.heal(ragnar);
        System.out.println(ragnar.status());

        System.out.println("\nNow that Athelstan has healed Ragnar, he leaved the faction");
        System.out.println(athelstan.status());
        athelstan.leaveFaction(northmen);
        System.out.println(athelstan.status());

        System.out.println("\nRagnar join the scandinavian assembly");
        System.out.println(ragnar.status());
        ragnar.joinAssembly(scandinavianAssembly);
        System.out.println(ragnar.status());
        System.out.println("Actual scandianvian master: " + scandinavianAssembly.getMaster().getName());

        System.out.println("\nEcbert join the england assembly");
        System.out.println(ecbert.status());
        ecbert.joinAssembly(englandAssembly);
        System.out.println(ecbert.status());
        System.out.println("Actual england master : " + englandAssembly.getMaster().getName());

        System.out.println("\nRagnar changes scandinavian assembly's name to Vikings");
        System.out.println("Old name : " + scandinavianAssembly.getName());
        ragnar.updateAssemblyName("Vikings");
        System.out.println("New name : " + scandinavianAssembly.getName());

        System.out.println("\nLagertha tries to change the assembly name");
        lagertha.joinAssembly(scandinavianAssembly);
        lagertha.updateAssemblyName("Bjorn");

        System.out.println("\nRagnar was killed and let the mastering to another viking");
        floki.joinAssembly(scandinavianAssembly);
        rollo.joinAssembly(scandinavianAssembly);
        porunn.joinAssembly(scandinavianAssembly);
        torstein.joinAssembly(scandinavianAssembly);

        while(ragnar.getState()== Entity.states.ALIVE){
            ecbert.attack(ragnar);
        }
        System.out.println("New Vikings master : " + scandinavianAssembly.getMaster().getName());

        System.out.println("\nEcbert leaves his assembly");
        System.out.println("Old master name : " + englandAssembly.getMaster().getName());
        ecbert.leaveAssembly();
        System.out.println("New master name : " + englandAssembly.getMaster());
    }
}
