import java.util.List;

public class Assembly extends Faction implements Properties {
    List<Roles> allowedRoles;
    Character master;

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
                if(!isMasterSet()) {
                    this.members.add(character);
                    setMaster(0);
                    return true;
                }
                this.members.add(character);
                return true;
            }

        if (character instanceof Warrior)
            if (allowedRoles.contains(Roles.Warrior)) {

                character.assembly = this;
                if(!isMasterSet()) {
                    this.members.add(character);
                    setMaster(0);
                    return true;
                }
                this.members.add(character);
                return true;
            }


        if (character instanceof Character)
            if(allowedRoles.contains(Roles.Character)) {
                character.assembly = this;
                if(!isMasterSet()) {
                    this.members.add(character);
                    setMaster(0);
                    return true;
                }
                this.members.add(character);
                return true;
            }

        return false;

    }

    @Override
    public void removeMember(Character character) {
        if(members.contains(character))
            this.members.remove(character);
            if(master.equals(character)){
                int randomIndex = Helper.randomNumber(0,this.members.size());
                this.members.stream()
                        .forEach(character1 -> System.out.println(character.name));
                setMaster(randomIndex);
            }
    }

    public void renameAssembly(Character character, String name) {
        if(character.equals(master)) {
            this.name = name;
        }
    }

    public boolean isMasterSet(){
        if(this.members.isEmpty()){
            return false;
        }
        return true;
    }

    public void setMaster(int index){
        if(isMasterSet()){
            master = members.get(index);
        }
    }

}