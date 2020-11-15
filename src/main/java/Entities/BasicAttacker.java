package Entities;

public class BasicAttacker implements Attacker {
    @Override
    public void attack(Entity entity) {
        entity.setHealth(entity.getHealth() - 1);
    }
}
