import java.util.Random;

public class Priest extends Character{
    public Priest(String name) {
        super(name);
    }

    @Override
    public void attack(Entity attackTarget) {
        System.out.println("A priest is a man of religion, and do not tolerate violence.");
    }

    @Override
    public void heal(Character healTarget) {
        if (!this.checkFaction(healTarget)){
            System.out.println("Cannot heal someone from another faction");
            return;
        }
        Random randHeal = new Random();
        int min = 5;
        int max = 11;
        int healPoints = randHeal.nextInt(max - min) + min;
        healTarget.increaseCurrentHealth(healPoints);
        System.out.println(this.getName() + " healed by " + healPoints + " points to " + healTarget.getName());
    }
}
