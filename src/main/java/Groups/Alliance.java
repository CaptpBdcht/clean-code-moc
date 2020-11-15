package Groups;

import Entities.Character;

import java.util.ArrayList;
import java.util.List;

public abstract class Alliance<T extends Alliance> {
    String name;
    private List<Character> members = new ArrayList<>();
    private List<T> friends = new ArrayList<>();

    public Alliance(String name) {
        this.name = name;
    }

    // GETTER

    public String getName() { return name; }
    public List<Character> getMembers(){ return this.members; }
    public List<T> getFriends(){ return this.friends; }


    // BOOLEANS

    public boolean hasFriend(ArrayList<T> alliances) {
        for (T alliance : alliances) {
            if (this.friends.contains(alliance)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFriend(T alliance) {
        return this.friends. contains(alliance);
    }

    public boolean hasMember(Character character){
        return this.members.contains(character);
    }


    // FONCTIONNALITES

    public void addFriend(T alliance){
        if(friends.contains(alliance)){
            return;
        }
        this.friends.add(alliance);
        alliance.addFriend(this);
    }

    public void removeFriend(T alliance){
        if(friends.contains(alliance)) {
            this.friends.remove(alliance);
            alliance.removeFriend(this);
        }
    }

    public void addMember(Character character){
        if(members.contains(character)){
            return;
        }
        members.add(character);
    }

    public void removeMember(Character character){
        members.remove(character);
    }
}
