import java.util.Optional;

public class Character implements Attribute {


    String name;
    int health;
    States state;
    Optional<Faction> faction;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.state = States.alive;
    }



    @Override
    public void attack(Character character) {

        if (this.hasSameFaction(character))
            return;

        if (character != this) {

            if (character.isAlive())
                character.health -= 1;
        }

    }


    @Override
    public void heal(Character character) {

        if (character.health == 100)
            return;

        character.health += 1;
        character.isAlive();

    }

    @Override
    public void joinFaction(Optional<Faction> faction) {

        this.faction = faction;
        faction.get().addMember(this);
    }

    @Override
    public void leaveFaction(Optional<Faction> faction) {

        this.faction = null;
        faction.get().remouveMember(this);
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


}
