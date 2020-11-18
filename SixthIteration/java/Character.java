import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class Character extends Entity implements Attribute {


    Optional<Faction> faction;
    String name;

    public Character(String name) {
        super(100);
        this.name = name;
    }



    @Override
    public void joinFaction(Optional<Faction> faction) {

        this.faction = faction;
        faction.get().addMember(this);
    }

    @Override
    public void leaveFaction(Optional<Faction> faction) {

        this.faction = null;
        faction.get().removeMember(this);
    }

    public boolean hasFactions() {

        if(this.faction == null)
            return false;
        return true;

    }



    public boolean hasSameFaction(Character character){

        if (!this.hasFactions())
            return false;

        character.faction.equals(faction);


        return true;
    }




    public boolean isAlive(){

        if(this.health <= 0) {
            this.setState();
            return false;
        }
        this.setState();
        return true;
    }

    public void setState() {
        if(this.health <= 0) {
            this.state = States.dead;
            return;
        }
        this.state = States.alive;
    }

    public void setHealthto100() {
        if(health > 100)
            this.health = 100;
    }


    @Override
    public void attack(Entity entity) {



        if(!entity.isCharacter()){

            if(entity.isAlive())
                entity.health -= 1;

            return;
        }

        Character character = (Character) entity;

        if (this.hasSameFaction(character))
            return;

        if(hasFactionAllies(character))
            return;

        if (character != this) {

            if (character.isAlive())
                entity.health -= 1;
        }

    }



    @Override
    public void heal(Character character) {
        if(!hasSameFaction(character) && character.hasFactions() && this.hasFactions()) {
            return;
        }

        if (character.health == 100)
            return;

        character.health += 1;
        character.isAlive();

    }


    public boolean hasFactionAllies(Character character) {

        AtomicBoolean hasAllies = new AtomicBoolean(false);;

        if(faction == null){
            return hasAllies.get();
        }
                    faction.get().alliedFactions.stream()
                            .forEach(faction -> {
                                            if(faction.alliedFactions.contains(character.faction.get())|| faction.alliedFactions.contains(this.faction.get()))
                                                hasAllies.set(true);

                            });

        return hasAllies.get();
    }
}
