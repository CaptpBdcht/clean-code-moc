import java.util.Optional;

public interface Attribute {

    public void attack(Entity entity);
    public void heal(Character character);
    public void joinFaction(Faction faction);
    public void leaveFaction(Faction faction);

}



