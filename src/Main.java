public class Main {

    public static void main(String[] args) {

        Character player1 = new Character("player1");
        Character player2 = new Character("player2");

        System.out.println("character deal damage to another character");
        System.out.println("player 2 heath before attack: "+player2.currentHealth);
        player1.attack(player2);
        System.out.println("player 2 heath after attack: "+player2.currentHealth);

        System.out.println("\ncharacter attack itself");
        System.out.println("player 1 before hit itself : "+player1.currentHealth);
        player1.attack(player1);
        System.out.println("player 1 after hit itself : "+player1.currentHealth);

        System.out.println("\nplayer should be dead after attack");
        player2.currentHealth=1;
        System.out.println("player2 heath before attack : "+player2.currentHealth+" player2 state "+player2.state);
        player1.attack(player2);
        System.out.println("player2 heath after attack : "+player2.currentHealth+" player2 state "+player2.state);

        System.out.println("\ndamage dead character");
        System.out.println("dead player 2 health before player 1 attack : "+player2.currentHealth);
        player1.attack(player2);
        System.out.println("dead player 2 health after player 1 attack : "+player2.currentHealth);

        System.out.println("\ncharacter heal damaged character");
        player2.state = Character.status.ALIVE;
        player2.currentHealth = 99;
        System.out.println("player 2 before player 1 healing: "+player2.currentHealth);
        player1.heal(player2);
        System.out.println("player 2 after player 1 healing: "+player2.currentHealth);

        System.out.println("\ncharacter heal itself");
        player1.currentHealth = 99;
        System.out.println("player 1 before heal itself: "+player1.currentHealth);
        player1.heal(player1);
        System.out.println("player 1 after heal itself: "+player1.currentHealth);

        System.out.println("\nheal full health");
        System.out.println("health before healing: "+player1.currentHealth);
        player1.heal(player1);
        System.out.println("health after healing: "+player1.currentHealth);

    }
}
