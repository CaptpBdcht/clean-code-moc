import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Priest extends Character {
    Priest(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) { }

    @Override
    public void heal(Character character) {
        int value = this.equals(character) ? 1 : ThreadLocalRandom.current().nextInt(5, 11);
        character.setHealth(character.getHealth() + value);
    }
}
