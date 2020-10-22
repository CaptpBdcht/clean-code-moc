import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Faction {

    private String name;
    private List<Character> members;

    public List<String > getMembers() {
        return members.stream().map(member-> member.name).collect(Collectors.toList());
    }

    public void addMembers(Character member) {
        this.members.add(member);
    }
    public void leaveFaction(Character member){
        this.members.remove(member);
    }

    public Faction(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
