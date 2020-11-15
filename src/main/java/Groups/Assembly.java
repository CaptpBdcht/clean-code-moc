package Groups;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import Entities.Character;
import Enum.Role;
import Entities.Character;
import org.junit.Ignore;

public class Assembly<Assembly> extends Alliance<Groups.Assembly> {
    private ArrayList<Role> allowedRoles;
    private Character master;

    public Assembly(String name, ArrayList<Role> roles){
        super(name);
        allowedRoles = roles;
    }

    public ArrayList<Role> getAllowedRoles() {
        return allowedRoles;
    }

    public Character getMaster() {return master; }

    public void updateName(Character updater, String newName) {
        if (updater == master) {
            name = newName;
        }
    }


    @Override
    public void addMember(Character character){
        if(!this.isAllowed(character.getRole())){
            return;
        }

        if (getMembers().isEmpty()) {
            master = character;
        }
        super.addMember(character);
    }

    @Override
    public void removeMember(Character character){
        super.removeMember(character);

        if(character.equals(master)){

            if(getMembers().isEmpty()){
                master = null;
                return;
            }

            int numberNewMaster = ThreadLocalRandom.current().nextInt(0, getMembers().size());
            master = (Character) this.getMembers().get(numberNewMaster);
        }
    }

    public boolean isAllowed(Role role){ return this.getAllowedRoles().contains(role); }

}
