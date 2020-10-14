import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Priest extends Character {
    Priest(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        return;
    }

    @Override
    public void heal(Character character) {
        if(this != character){
            int healPoints = ThreadLocalRandom.current().nextInt(5, 11);
            character.giveHeal(healPoints);
        }else{
            character.giveHeal(1);
        }
    }
}
