import java.util.List;

public class Assembly extends Faction implements Properties {
    List<Roles> allowedRoles;

    public Assembly(String name, List<Roles> allowedRoles) {
        super(name);
        this.allowedRoles = allowedRoles;
    }

    @Override
    public boolean addMember(Character character) {

        if(character.hasAassembly()) {
            return false;
        }

        if (character instanceof Priest)
            if(allowedRoles.contains(Roles.Priest)){
                character.assembly = this;
                this.members.add(character);
                return true;
            }

        if (character instanceof Warrior)
            if (allowedRoles.contains(Roles.Warrior)) {

                character.assembly = this;
                this.members.add(character);
                return true;
            }


        if (character instanceof Character)
            if(allowedRoles.contains(Roles.Character)) {
                character.assembly = this;
                this.members.add(character);
                return true;
            }

        return false;

    }

    @Override
    public void removeMember(Character character) {
        if(members.contains(character))
            this.members.remove(character);
    }


}