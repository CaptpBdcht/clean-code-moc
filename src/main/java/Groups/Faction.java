package Groups;

import java.util.ArrayList;
import java.util.List;
import Entities.Character;

public class Faction<Faction> extends Alliance {
    String name;
    //private List<Character> members = new ArrayList<>();
    //private List<Faction> friends = new ArrayList<>();

    public Faction(String name) {
        super(name);
    }

}
