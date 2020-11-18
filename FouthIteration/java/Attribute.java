import java.util.Optional;

public interface Attribute {

    public void attack(Character character);
    public void heal(Character character);
    public void joinFaction(Optional<Faction> faction);
    public void leaveFaction(Optional<Faction> faction);


}



