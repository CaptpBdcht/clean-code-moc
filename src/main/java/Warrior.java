import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character {
    private BasicHealer basicHealer = new BasicHealer();
    private BasicAttacker basicAttacker = new BasicAttacker();
    private RandomizedAttacker randomizedAttacker = new RandomizedAttacker();

    Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Entity entity) {
        if(!entity.isAlive()){
            return;
        }

        try{
            Character character = (Character) entity;

            if(equals(character)){
                basicAttacker.attack(entity);
                return;
            }

            if(!hasFaction()){
                randomizedAttacker.attack(character);
                return;
            }

            if(isAlly(character)){
                return;
            }

            randomizedAttacker.attack(character);

        }catch (Exception e){
            randomizedAttacker.attack(entity);
        }
    }

    @Override
    public void heal(Entity entity) {
        Character character;
        if(!entity.isHealable()) {
            return;
        }

        character = (Character) entity;
        if(equals(character)){
            basicHealer.heal(this);
            // return
        }
    }
}
