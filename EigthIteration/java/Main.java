import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        System.out.println("Start Game \n");
        Entity entity = new Entity(200);
        Character arnaud = new Character("Arnaud");
        Character mohamed = new Character("Mohamed");
        Priest priest = new Priest("Benoit");
        Warrior warrior = new Warrior("Sananes");
        Faction students = new Faction(  "students");
        Faction teachers = new Faction("teachers");

        Faction school = new Faction("ESGI");
        students.addAlliedFaction(school);
        //teachers.addAlliedFaction(school);

        arnaud.joinFaction(students);
        mohamed.joinFaction(students);
        priest.joinFaction(teachers);
        warrior.joinFaction(teachers);

        arnaud.joinFaction(school);
        mohamed.joinFaction(school);
        priest.joinFaction(school);
        warrior.joinFaction(school);


        //Assembly test MOC4
        List<Roles> roles = new ArrayList<Roles>();
        roles.add(Roles.Character);
        Assembly assembly = new Assembly("Moc4", roles);
        arnaud.joinAssembly(assembly);
        mohamed.joinAssembly(assembly);


        //Assembly test Profs
        List<Roles> roles2 = new ArrayList<Roles>();
        roles2.add(Roles.Warrior);
        roles2.add(Roles.Priest);
        Assembly assembly1 = new Assembly("Profs", roles2);


        priest.joinAssembly(assembly1);
        warrior.joinAssembly(assembly1);
        arnaud.joinAssembly(assembly1);
        mohamed.joinAssembly(assembly1);
        
        
        arnaud.leaveAssembly(assembly);


        System.out.println( "\n");
        System.out.println(arnaud.name + " is member of assembly : " + arnaud.assembly.name);
        System.out.println( "\n");
        System.out.println(mohamed.name + " is member of assembly : " + mohamed.assembly.name);
        System.out.println( "\n");
        System.out.println(priest.name + " is member of assembly : " + priest.assembly.name);
        System.out.println( "\n");
        System.out.println(warrior.name + " is member of assembly : " + warrior.assembly.name);
        System.out.println( "\n");





        System.out.println( "\n");
        System.out.println(arnaud.name + " is member of : ");
        arnaud.factions.stream()
                .forEach(faction -> System.out.println(faction.name));
        System.out.println( "\n");


        System.out.println(mohamed.name + " is member of : ");
        mohamed.factions.stream()
                .forEach(faction -> System.out.println(faction.name));
        System.out.println( "\n");



        System.out.println(priest.name + " is member of : ");
        priest.factions.stream()
                .forEach(faction -> System.out.println(faction.name));
        System.out.println( "\n");


        System.out.println(warrior.name + " is member of : ");
        warrior.factions.stream()
                .forEach(faction -> System.out.println(faction.name));
        System.out.println( "\n");



        System.out.println("Game Start!\n");

        System.out.println("First move!\n");
        System.out.println(arnaud.name + " Attack " + mohamed.name + "\n");
        arnaud.attack(mohamed);
        System.out.println(mohamed.name + " HP are " + mohamed.health + "\n");

        System.out.println("Second move!\n");
        System.out.println(warrior.name + " Attack " + priest.name + "\n");
        warrior.attack(priest);
        System.out.println(priest.name + " HP are " + priest.health + "\n");

        System.out.println("Third move!\n");
        System.out.println(arnaud.name + " Attack " + warrior.name + "\n");
        arnaud.attack(warrior);
        System.out.println(warrior.name + " HP are " + warrior.health + "\n");

        System.out.println("Four move!\n");
        System.out.println(warrior.name + " Attack " + arnaud.name + "\n");
        warrior.attack(arnaud);
        System.out.println(arnaud.name + " HP are " + arnaud.health + "\n");

        System.out.println("move Five!\n");
        System.out.println(priest.name + " Heal " + arnaud.name + "\n");
        priest.heal(arnaud);
        System.out.println(arnaud.name + " HP are " + arnaud.health + "\n");

        System.out.println("move Six!\n");
        System.out.println(priest.name + " Heal " + warrior.name + "\n");
        priest.heal(warrior);
        System.out.println(warrior.name + " HP are " + warrior.health + "\n");

        System.out.println("move Seven!\n");
        System.out.println(arnaud.name + " Attack Entity\n");
        arnaud.attack(entity);
        System.out.println("Entity HP are " + entity.health + "\n");

        System.out.println("move Eight!\n");
        System.out.println(mohamed.name + " Attack Entity\n");
        mohamed.attack(entity);
        System.out.println("Entity HP are " + entity.health + "\n");

        System.out.println("move Eight!\n");
        System.out.println(priest.name + " Attack Entity\n");
        priest.attack(entity);
        System.out.println("Entity HP are  " + entity.health + "\n");

        System.out.println("move Eight!\n");
        System.out.println(warrior.name + " Attack Entity \n");
        warrior.attack(entity);
        System.out.println( "Entity  HP are " + entity.health + "\n");

        System.out.println("End Games!\n");



    }
}
