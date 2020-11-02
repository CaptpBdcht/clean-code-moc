import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Assembly {
    private String name;
    public ArrayList<Class<?>> allowedRoles;
    private List<Character> members;

    Assembly(String name, ArrayList<Class<?>> allowedRoles){
        this.name = name;
        this.allowedRoles = allowedRoles;
        this.members = new ArrayList<>();
    }

    public boolean addMembers(Character character){
        if(this.allowedRoles.contains(character.getClass())){
            if(!this.members.contains(character)) {
                this.members.add(character);
                return true;
            } else {
                System.out.println(character.getName() + " is already member of " + this.name + " assembly.");
                return false;
            }
        } else {
            System.out.println(character.getClass().toString() + " is not allowed to join this assembly.");
        }
        return false;
    }

    public void leave(Character character){
        if(this.members.contains(character)){
            this.members.remove(character);
        } else {
            System.out.println("Not a member of this assembly.");
        }
    }

    public String getName(){
        return this.name;
    }

    public List<String> getMembers() {
        return members.stream().map(Character::getName).collect(Collectors.toList());
    }
}
