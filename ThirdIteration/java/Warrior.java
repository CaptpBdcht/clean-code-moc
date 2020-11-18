import java.util.Optional;

public class Warrior extends Character implements Attribute {

    public Warrior(String name) {
        super(name);
        this.name = name;
    }
    @Override
    public void attack(Character character) {

        if (character.isAlive())
            character.health -= Helper.randomNumber(0, 9);

    }

    @Override
    public void heal(Character character) {


        if (character == this) {
            if (character.isAlive())
                character.health += 1;
        }

    }
}
