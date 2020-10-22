import java.util.Random;

public class Warrior extends Character{

    public Warrior(String name) {
        super(name);
    }
    @Override
    public void attack(Entity attackTarget) {
        if(attackTarget instanceof Character){
            boolean sameFaction = false;
            try{
                sameFaction = this.checkFaction((Character) attackTarget);
            } catch (Exception e){
                System.err.println(e.getLocalizedMessage());
            }
            if (sameFaction){
                System.out.println("Cannot hit someone from the same faction or friend faction");
                return;
            }
        }
        if(attackTarget.getState() != states.DEAD){
            Random randDamage = new Random();
            int damage = randDamage.nextInt(10);
            attackTarget.takeDamage(damage);
            System.out.println(this.getName() + " inflict " + damage + " damages");
            if(attackTarget.getState() == states.DEAD){
                if(attackTarget == this){
                    System.out.println(this.getName() + " is suicide");
                } else {
                    String name = attackTarget instanceof Character ? ((Character) attackTarget).getName() : String.valueOf(attackTarget.getClass().getName());
                    System.out.println(this.getName() + " killed " + name);
                }
            }
        }
    }

    @Override
    public void heal(Character healTarget) {
        if(healTarget == this){
            if(healTarget.health < MAXHEALTH && healTarget.getState() != states.DEAD ){
                healTarget.increaseCurrentHealth(1);
                System.out.println(this.getName() + " healed.");
            }
        } else {
            System.out.println("A warrior is selfish, so can only heal himself.");
        }
    }
}
