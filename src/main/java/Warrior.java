import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character {
    Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        if (character.isAlive()) {
            if (character.getFaction() == this.getFaction() && this.getFaction() != null) {
                return;
            }
            int damages = ThreadLocalRandom.current().nextInt(0, 9);
            character.setHealth(getHealth() - damages);
        }
    }

    @Override
    public void heal(Character character) {
        if (this.getFaction() != character.getFaction()) {
            return;
        }
        if(this.equals(character)) {
            character.setHealth(character.getHealth() + 1);
        }
    }
}
