package Entities;

import java.util.concurrent.ThreadLocalRandom;

public class RandomizedAttacker implements Attacker {

    @Override
    public void attack(Entity entity) {
        int damages = ThreadLocalRandom.current().nextInt(0, 9);
        entity.setHealth(entity.getHealth() - damages);
    }
}
