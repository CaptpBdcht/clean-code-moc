import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Priest extends Character {
    Priest(String name) {
        super(name);
    }

    @Override
    public void attack(Entity entity) { }

    @Override
    public void heal(Entity entity) {
        if(!(entity instanceof Character)) {
            return;
        }

        Character character = (Character) entity;
        if (this.getFaction() != character.getFaction()) {
            return;
        }
        int value = this.equals(character) ? 1 : ThreadLocalRandom.current().nextInt(5, 11);
        character.setHealth(character.getHealth() + value);
    }
}
