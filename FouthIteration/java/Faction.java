import java.util.ArrayList;
import java.util.List;

public class Faction implements Properties {
    public List<Character> members;
    public String name;

    public Faction(String name) {
        this.members = new ArrayList<>();
        this.name = name;
    }


    @Override
    public boolean addMember(Character character) {
        if(members.contains(character))
            return false;
        return true;
    }

    @Override
    public void remouveMember(Character character) {
        if(members.contains(character))
            members.remove(character);
    }
}
