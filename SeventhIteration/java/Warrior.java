import java.util.Optional;

public class Warrior extends Character implements Attribute {

    public Warrior(String name) {
        super(name);
        this.name = name;
    }
    @Override
    public void attack(Entity entity) {

        if(!entity.isCharacter()){

            if(entity.isAlive())
                entity.health -= Helper.randomNumber(0, 9);

            return;
        }
        Character character = (Character) entity;
        if(this.hasSameFaction(character))
            return;

        if(hasFactionAllies(character))
            return;

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
