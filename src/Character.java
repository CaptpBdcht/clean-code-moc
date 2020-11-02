import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Character extends Entity {
    protected static final int MAXHEALTH = 100;
    private ArrayList<Faction> factions = new ArrayList<Faction>();
    private final String name;

    public Character(String name) {
        super(MAXHEALTH);
        this.name = name;
    }

    public abstract void attack(Entity attackTarget);

    public abstract void heal(Character healTarget);

    public void increaseCurrentHealth(int healthPoint){
        if(this.getHealth() + healthPoint <= MAXHEALTH && this.getState() == states.ALIVE){
            this.health += healthPoint;
        } else if (this.health + healthPoint > MAXHEALTH){
            this.health = MAXHEALTH;
        }
    }

    //Like toString but roleplay
    public String status() {
        String factionsNames = "null";
        if (this.factions.size() > 0){
            List<String> factions = this.factions.stream().map(Faction::getName).collect(Collectors.toList());
            factionsNames = factions.toString();
        }
        return this.name + "{ currentHealth:" + this.health + ", state:" + this.getState() + ", factions:" + factionsNames + " }";
    }

    public void joinFaction(Faction faction){
        if(!this.factions.contains(faction)) {
            this.factions.add(faction);
            faction.addMembers(this);
        } else {
            System.out.println("Already member of this faction.");
        }
    }


    public void leaveFaction(Faction faction){
        if(this.factions.contains(faction)) {
            this.factions.remove(faction);
        } else {
            System.out.println("Not member of this faction.");
        }
        faction.leaveFaction(this);
    }

    public boolean checkFaction(Character target){
        for(Faction targetFaction: target.getFactions()){
            if(this.factions.contains(targetFaction)){
                return true;
            }
        }
        return false;
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Faction> getFactions(){
        return this.factions;
    }
}
