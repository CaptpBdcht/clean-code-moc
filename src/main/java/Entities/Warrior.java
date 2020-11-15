package Entities;
import Enum.Role;

public class Warrior extends Character {
    private BasicHealer basicHealer = new BasicHealer();
    private BasicAttacker basicAttacker = new BasicAttacker();
    private RandomizedAttacker randomizedAttacker = new RandomizedAttacker();

    public Warrior(String name) {
        super(name);
        this.role = Role.Warrior;
    }

    @Override
    public void attack(Entity entity) {
        if(!entity.isAlive()){
            return;
        }

        try{
            Character character = (Character) entity;

            if(equals(character)){
                basicAttacker.attack(entity);
                return;
            }

            if(!hasFaction() && !hasAssembly()){
                randomizedAttacker.attack(character);
                return;
            }

            if(isAlly(character)){
                return;
            }

            randomizedAttacker.attack(character);

        }catch (Exception e){
            randomizedAttacker.attack(entity);
        }
    }

    @Override
    public void heal(Entity entity) {
        Character character;
        if(!entity.isHealable()) {
            return;
        }

        character = (Character) entity;
        if(equals(character)){
            basicHealer.heal(this);
            // return
        }
    }
}
