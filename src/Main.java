import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Warrior ragnar = new Warrior("Ragnar");
        Warrior lagertha = new Warrior("Lagertha");
        Priest athelstan = new Priest("Athelstan");
        Warrior ecbert = new Warrior("Ecbert");

        Faction northmen = new Faction("Northmen");
        Faction wessex = new Faction("Wessex");

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
        System.out.println("List of northmen friend faction : " + northmen.getFriendFaction());
        System.out.println("List of wessex friend faction : " + wessex.getFriendFaction());

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

        System.out.println("\nLagertha wants to join the priest assembly");
        ArrayList<Class<?>> allowedRoles = new ArrayList<Class<?>>();
        allowedRoles.add(Priest.class);
        Assembly priestAssembly = new Assembly("Priest", allowedRoles);
        System.out.println(lagertha.status());
        lagertha.joinAssembly(priestAssembly);
        System.out.println(lagertha.status());

        System.out.println("\nAthelstan wants to join the priest assembly");
        System.out.println(athelstan.status());
        athelstan.joinAssembly(priestAssembly);
        System.out.println(athelstan.status());

        System.out.println("\nAthelstan wants to leave the priest assembly");
        System.out.println(athelstan.status());
        athelstan.leaveAssembly();
        System.out.println(athelstan.status());
    }
}
