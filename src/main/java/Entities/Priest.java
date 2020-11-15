package Entities;
import Enum.Role;

public class Priest extends Character {
    public Priest(String name) {
        super(name);
        this.role = Role.Priest;
    }

    private RandomizedHealer randomizedHealer = new RandomizedHealer(); // random à l'instanciation
    private BasicHealer basicHealer = new BasicHealer();


    @Override
    public void attack(Entity entity) { }

    @Override
    public void heal(Entity entity) {
        Character character;
        if(!entity.isHealable()){
            return;
        }

        character = (Character) entity;
        if(equals(character)){
            basicHealer.heal(character);
            return;
        }

        if(!hasFaction() && !hasAssembly()){
            randomizedHealer.heal(character);
            return;
        }

        if(isAlly(character)){
            randomizedHealer.heal(character);
            //return;
        }
    }
}
