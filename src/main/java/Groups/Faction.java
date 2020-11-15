package Groups;

import Entities.Character;

public class Faction extends Alliance<Groups.Faction> {

    public Faction(String name) {
        super(name);
    }

    @Override
    public String toString(){
        String result =  "=> Faction " + this.name + "\n";

        result += " o Members :\n";
        for (Character character: this.getMembers()) {
            result += " " + character;
        }

        result += " o Friends:\n";
        for(Faction friend: this.getFriends()){
            result += "  - " + friend.name;
        }

        return result;
    }
}
