import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Character extends Entity implements Attribute {


    Assembly assembly;
    List<Faction> factions = new ArrayList<>();
    String name;

    public Character(String name) {
        super(100);
        this.name = name;
    }


    public boolean hasAassembly() {
        if(this.assembly == null)
            return false;
        return true;

    }
    public boolean hasFactions() {
        if(this.factions.isEmpty())
            return false;
        return true;

    }



    public boolean hasSameFaction(Character character){

        AtomicBoolean isSame = new AtomicBoolean(false);

        if (!this.hasFactions())
            return false;

        character.factions.stream()
                .forEach(faction -> {
                    if(this.factions.contains(faction))
                        isSame.set(true);
                        return;
                });


        return isSame.get();
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


    public boolean hasFactionAllies(Character character) {

        AtomicBoolean hasAllies = new AtomicBoolean(false);;


        character.factions.stream()
                .forEach(charFaction -> {
                    charFaction.alliedFactions.stream()
                            .forEach(charalliedFaction ->{
                                this.factions.stream()
                                        .forEach(myfaction -> {
                                            if(myfaction.alliedFactions.contains(charalliedFaction)|| charFaction.alliedFactions.contains(myfaction))
                                                hasAllies.set(true);
                                            return;
                                        });
                            } );

                });
        return hasAllies.get();
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



    @Override
    public void joinFaction(Faction faction) {

        factions.add(faction);
        faction.addMember(this);
    }

    @Override
    public void leaveFaction(Faction faction) {

        factions.remove(faction);
        faction.removeMember(this);
    }

    @Override
    public void joinAssembly(Assembly assembly) {

        boolean isJoinedAssembly= assembly.addMember(this);
        if(isJoinedAssembly){
            System.out.println(this.name + " has join " + assembly.name);
        } else {
            System.out.println(this.name + " can't join " + assembly.name);
        }

    }

    @Override
    public void leaveAssembly(Assembly assembly) {
        assembly.removeMember(this);

    }

}
