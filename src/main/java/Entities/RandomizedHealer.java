package Entities;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizedHealer implements Healer {
    @Override
    public void heal(Character character) {
        int value = ThreadLocalRandom.current().nextInt(5, 11);
        character.setHealth(character.getHealth() + value);
    }
}
