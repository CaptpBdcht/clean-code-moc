import java.util.Optional;

public interface Attribute {

    public void attack(Entity entity);
    public void heal(Character character);
    public void joinFaction(Faction faction);
    public void leaveFaction(Faction faction);
    public void joinAssembly(Assembly assembly);
    public void leaveAssembly(Assembly assembly);
    public void renameAssembly(String name);



}



