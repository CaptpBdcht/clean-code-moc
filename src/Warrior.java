import java.util.Random;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character attackTarget) {
        if(attackTarget.state != status.DEAD){
            Random randDamage = new Random();
            int damage = randDamage.nextInt(10);
            attackTarget.currentHealth -= damage;
            System.out.println(this.name + " inflict " + damage + " damages to " + attackTarget.name);
            if (attackTarget.currentHealth <= 0){
                attackTarget.currentHealth = 0;
                attackTarget.state = status.DEAD;
                if(attackTarget == this){
                    System.out.println(this.name + " is suicide");
                } else {
                    System.out.println(this.name + " killed " + attackTarget.name);
                }
            }
        }
    }

    @Override
    public void heal(Character healTarget) {
        if(healTarget == this){
            if(healTarget.currentHealth<healTarget.MAXHEALTH && healTarget.state != status.DEAD ){
                healTarget.currentHealth +=1;
                System.out.println(this.name + " healed.");
            }
        } else {
            System.out.println("A warrior is selfish, so can only heal himself.");
        }
    }
}
