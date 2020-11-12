package main;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Character extends Entity {
    protected static final int MAXHEALTH = 100;
    private ArrayList<Faction> factions = new ArrayList<Faction>();
    private final String name;
    private Assembly assembly;

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
        String assemblyName = "null";
        if(this.assembly != null){
            assemblyName = this.assembly.getName();
        }
        return this.name + "{ currentHealth:" + this.health + ", state:" + this.getState() + ", factions:" + factionsNames + ", assembly:" + assemblyName + " }";
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
        faction.leave(this);
    }

    public boolean checkFaction(Character target){
        for(Faction targetFaction: target.getFactions()){
            if(this.factions.contains(targetFaction)){
                return true;
            }
        }
        return false;
    }

    public void joinAssembly(Assembly assembly){
        if(assembly.addMembers(this)) {
            this.assembly = assembly;
        }
    }

    public void leaveAssembly(){
        if(this.assembly!=null){
            this.assembly.leave(this);
            this.assembly = null;
        } else {
            System.out.println("Not member of any assembly ");
        }
    }

    public Assembly getAssembly(){
        return this.assembly;
    }

    public String getName(){
        try {
            return this.name;
        }catch (NullPointerException e){
            return "none";
        }
    }

    public ArrayList<Faction> getFactions(){
        return this.factions;
    }

    public void updateAssemblyName(String name){
        if(this.assembly.getMaster() == this){
            this.assembly.setName(name);
        } else {
            System.out.println("You can't do that, you are not the fucking master !");
        }
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if(this.getState() == states.DEAD){
            die();
        }
    }

    @Override
    public void die() {
        leaveAssembly();
        for (int i = 0; i < this.factions.size(); i++) {
            this.leaveFaction(this.factions.get(i));
        }
    }
}
