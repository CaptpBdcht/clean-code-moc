import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Assembly {
    private String name;
    private List<Character> members = new ArrayList<Character>();
    private ArrayList<Role> allowedRoles;
    private List<Assembly> friends = new ArrayList<>();
    private Character master;

    Assembly(String name, ArrayList<Role> roles){
        this.name = name;
        allowedRoles = roles;
    }

    public String getName() {
        return name;
    }

    public List<Character> getMembers() {
        return members;
    }

    public ArrayList<Role> getAllowedRoles() {
        return allowedRoles;
    }

    public List<Assembly> getFriends(){ return this.friends; }

    public Character getMaster() {return master; }

    public void updateName(Character updater, String newName) {
        if (updater == master) {
            name = newName;
        }
    }


    public void addMember(Character character){
        if(this.isAllowed(character.getRole())){
            if (members.isEmpty()) {
                master = character;
            }
            members.add(character);
        }
    }
    public void removeMember(Character character){
        if(this.members.contains(character)) {
            members.remove(character);
            if (character == master) {
                if (members.isEmpty()) {
                    master = null;
                }
                else {
                    int numberNewMaster = ThreadLocalRandom.current().nextInt(0, members.size());
                    master = members.get(numberNewMaster);
                }
            }
        }
    }


    public boolean hasMember(Character character){
        return this.members.indexOf(character) != -1;
    }
    /*public boolean hasFriend(ArrayList<Assembly> assemblies) {
        for (Faction faction : factions) {
            if (this.friends.indexOf(faction) != -1) {
                return true;
            }
        }
        return false;
    }*/
    public boolean hasFriend(Assembly assembly) {
        return this.friends.contains(assembly);
    }
    public boolean isAllowed(Role role){ return this.getAllowedRoles().contains(role); }


    public void addFriend(Assembly assembly){
        this.friends.add(assembly);
        assembly.friends.add(this);
    }
    public void removeFriend(Assembly assembly){
        this.friends.remove(assembly);
        assembly.friends.remove(this);
    }

}
