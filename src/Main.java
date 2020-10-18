public class Main {

    public static void main(String[] args) {
        Warrior ragnar = new Warrior("Ragnar");
        Warrior lagertha = new Warrior("Lagertha");

        System.out.println("\nShould kill Lagertha");
        System.out.println("Lagertha's status before ragnar's attacks:");
        System.out.println(lagertha.status());
        while (lagertha.state == Character.status.ALIVE){
            ragnar.attack(lagertha);
        }
        System.out.println(lagertha.status());


        System.out.println("\nRagnar's kill himself after killed his own wife.");
        System.out.println("Ragnar's status before his own attacks:");
        System.out.println(ragnar.status());
        while (ragnar.state == Character.status.ALIVE){
            ragnar.attack(ragnar);
        }
        System.out.println(ragnar.status());

        System.out.println("\nRagnar shoud gain one life point.");
        ragnar.currentHealth = ragnar.MAXHEALTH - 10;
        ragnar.state = Character.status.ALIVE;
        System.out.println(ragnar.status());
        ragnar.heal(ragnar);
        System.out.println(ragnar.status());

        System.out.println("\nShould failed heal lagertha.");
        lagertha.state = Character.status.ALIVE;
        lagertha.currentHealth = lagertha.MAXHEALTH - 5;
        ragnar.heal(lagertha);
        lagertha.status();
    }
}
