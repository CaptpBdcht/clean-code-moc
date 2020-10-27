import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Character {
    Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Entity entity) {
        if (entity.isAlive()) {
            if(entity instanceof Character) {
                Character character = (Character) entity;
                if (character.getFaction() == this.getFaction() && this.getFaction() != null) {
                    return;
                }
            }

            int damages = ThreadLocalRandom.current().nextInt(0, 9);
            entity.setHealth(entity.getHealth() - damages);
        }
    }

    @Override
    public void heal(Entity entity) {
        if(!(entity instanceof Character)) {
            return;
        }

        Character character = (Character) entity;

        if (this.getFaction() != character.getFaction()) {
            return;
        }
        if(this.equals(character)) {
            character.setHealth(character.getHealth() + 1);
        }
    }
}
