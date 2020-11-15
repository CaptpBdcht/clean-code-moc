package Entities;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizedAttacker implements Attacker {
    private int min;
    private int max;

    public RandomizedAttacker(int min, int max){
        this.min = min;
        this.max = max;
    }

    @Override
    public void attack(Entity entity) {
        int damages = ThreadLocalRandom.current().nextInt(min, max);
        entity.setHealth(entity.getHealth() - damages);
    }
}
