import java.util.ArrayList;

public class Faction {
    private String name;
    private ArrayList<Character> members = new ArrayList<>();

    Faction(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public ArrayList<Character> getMembers(){ return this.members; }

    public boolean isMember(Character character){
        return this.members.indexOf(character) != -1;
    }


    void addMember(Character character){
        members.add(character);
    }

    void deleteMember(Character character){
        if(members.indexOf(character) != -1){
            members.remove(character);
        }
    }
}
