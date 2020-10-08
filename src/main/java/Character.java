public class Character {
    private String name;
    private int health = 100;

    Character(String name) {
        this.name = name;
    }

    private void dealDamage(int damage) {
        setHealth(getHealth() - damage);
    }

    private void giveHeal(int lifeHeal) {
        setHealth(getHealth() + lifeHeal);
    }

    public void setHealth(int health) {
        if (health > 100) {
            this.health = 100;
        }
        else if (health < 0) {
            this.health = 0;
        }
        else {
            this.health = health;
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Character character) {
        if (this == character) {
            return;
        }
        if (character.isAlive()) {
            character.dealDamage(1);
        }
    }
    public void heal(Character character) {
        character.giveHeal(1);
    }
}
