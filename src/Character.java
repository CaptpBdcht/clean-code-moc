public abstract class Character extends Entity {
    protected static final int MAXHEALTH = 100;
    private Faction faction = null;
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
        String factionName = "null";
        if (this.faction != null){
            factionName = this.faction.getName();
        }
        return this.name + "{ currentHealth:" + this.health + ", state:" + this.getState() + ", faction:" + factionName + " }";
    }

    public void joinFaction(Faction faction){
        this.faction = faction;
        faction.addMembers(this);
    }


    public void leaveFaction(Faction faction){
        this.faction = null;
        faction.leaveFaction(this);
    }

    public boolean checkFaction(Character target){
        return this.faction == target.faction;
    }

    public String getName(){
        return this.name;
    }
}
