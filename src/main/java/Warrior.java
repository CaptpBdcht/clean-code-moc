import java.util.Random;

public class Warrior extends Character {
    Warrior(String name) {
        super(name);
    }

    @Override
    public void attack(Character character) {
        Random random = new Random();
        int damage = random.nextInt(9);
        if (character.isAlive()) {
            character.dealDamage(damage);
        }
    }

    @Override
    public void heal(Character character) {
        if(this.equals(character)) {
            super.heal(character);
        }
    }
}
