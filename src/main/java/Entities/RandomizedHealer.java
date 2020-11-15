package Entities;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizedHealer implements Healer {
    private int min;
    private int max;

    public RandomizedHealer(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public void heal(Character character) {
        int value = ThreadLocalRandom.current().nextInt(min, max);
        character.setHealth(character.getHealth() + value);
    }
}
