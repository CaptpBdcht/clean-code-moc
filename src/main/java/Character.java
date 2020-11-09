import java.util.ArrayList;

public abstract class Character extends Entity {
    private String name;
    private ArrayList<Faction> factions = new ArrayList<Faction>();

    private BasicHealer basicHealer = new BasicHealer();
    private BasicAttacker basicAttacker = new BasicAttacker();

    Character(String name){
        super(100);
        this.name = name;
    }

    public String getName() { return name; }

    public ArrayList<Faction> getFactions() { return this.factions; }

    public void attack(Entity entity) {
        if(!entity.isAlive()){
            return;
        }

        Character character = (Character) entity;
        if(equals(character) || isAlly(character)){
            return;
        }

        basicAttacker.attack(entity);
    }

    public void heal(Entity entity) {
        Character character;
        if(!entity.isHealable()){
            return;
        }

        character = (Character) entity;
        if(equals(character)){
            basicHealer.heal(character);
            return;
        }

        if(!hasFaction()){
            basicHealer.heal(character);
            return;
        }

        if(isAlly(character)){
            basicHealer.heal(character);
            //return;
        }
    }

    public void joinFaction(Faction faction) {
        faction.addMember(this);
        this.factions.add(faction);
    }

    public void leaveFaction(Faction faction) {
        int index = this.factions.indexOf(faction);
        this.factions.get(index).removeMember(this);
        if (this.factions != null) {
            this.factions.remove(faction);
        }
    }

    public boolean hasFaction(){
        return !this.factions.isEmpty();
    }

    public boolean isAlly(Character character){
        return shareFaction(character) || isFriend(character);
    }

    public boolean shareFaction(Character character){
        if (!this.hasFaction()) {
            return false;
        }
        for(Faction faction : this.factions) {
            if (faction.hasMember(character)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFriend(Character character){
        if (!this.hasFaction()) {
            return false;
        }
        for(Faction faction : this.factions) {
            if (faction.hasFriend(character.getFactions())) {
                return true;
            }
        }
        return false;
    }
}
