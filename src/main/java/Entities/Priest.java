package Entities;
import Enum.Role;

public class Priest extends Character {
    protected RandomizedHealer randomizedHealer = new RandomizedHealer(5, 11);
    private BasicHealer basicHealer = new BasicHealer();

    public Priest(String name) {
        super(name);
        this.role = Role.Priest;
    }

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

    @Override
    public String toString(){
        return " - Priest" + super.toString();
    }
}
