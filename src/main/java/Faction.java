import java.util.ArrayList;
import java.util.List;

public class Faction {
    private String name;
    private List<Character> members = new ArrayList<>();
    private List<Faction> friends = new ArrayList<>();

    Faction(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public List<Character> getMembers(){ return this.members; }
    public List<Faction> getFriends(){ return this.friends; }

    public boolean hasMember(Character character){
        return this.members.indexOf(character) != -1;
    }
    public boolean hasFriend(ArrayList<Faction> factions) {
        for (Faction faction : factions) {
            if (this.friends.indexOf(faction) != -1) {
                return true;
            }
        }
        return false;
    }
    public boolean hasFriend(Faction faction) {
        return this.friends.indexOf(faction) != -1;
    }

    public void addFriend(Faction faction){
        this.friends.add(faction);
        faction.friends.add(this);
    }

    public void removeFriend(Faction faction){
        this.friends.remove(faction);
        faction.friends.remove(this);
    }

    void addMember(Character character){
        members.add(character);
    }

    void removeMember(Character character){
        if(members.contains(character)){
            members.remove(character);
        }
    }
}