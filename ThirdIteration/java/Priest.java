public class Priest extends Character implements Attribute {


    public Priest(String name) {
        super(name);
        this.name = name;
    }


    @Override
    public void attack(Character character) {
        return;

    }

    @Override
    public void heal(Character character) {

        if (character.health == 100)
            return;

        character.health += Helper.randomNumber(5, 10);;
        character.isAlive();
        character.setHealthto100();


    }


}
