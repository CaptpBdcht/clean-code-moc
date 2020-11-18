public class Priest extends Character implements Attribute {


    public Priest(String name) {
        super(name);
        this.name = name;
    }


    @Override
    public void attack(Entity entity) {
        return;

    }

    @Override
    public void heal(Character character) {

        if(!hasSameFaction(character) && character.hasFactions() && this.hasFactions()) {
            return;
        }

        if (character.health == 100)
            return;

        character.health += Helper.randomNumber(5, 10);;
        character.isAlive();
        character.setHealthto100();


    }


}
