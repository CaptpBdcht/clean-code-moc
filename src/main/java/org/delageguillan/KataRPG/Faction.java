package org.delageguillan.KataRPG;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Faction {

    private String name;
    private List<Character> members;
    private List<Faction> friendFactions;

    public Faction(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.friendFactions = new ArrayList<>();
    }

    public List<String> getMembers() {
        return members.stream().map(Character::getName).collect(Collectors.toList());
    }

    public List<String> getFriends() {
        return friendFactions.stream().map(Faction::getName).collect(Collectors.toList());
    }

    public List<Faction> getFriendsFactions(){
        return friendFactions;
    }

    public void addMembers(Character member) {
        this.members.add(member);
    }
    public void leave(Character member){
        this.members.remove(member);
    }

    public void addFriend(Faction friend) {
        this.friendFactions.add(friend);
        friend.friendFactions.add(this);
    }
    public void leaveFriend(Faction friend){
        this.friendFactions.remove(friend);
    }

    public String getName() {
        return name;
    }

}
