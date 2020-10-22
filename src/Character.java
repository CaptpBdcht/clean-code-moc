public abstract class Character {

    protected int MAXHEALTH = 100;
    protected int currentHealth = MAXHEALTH;
    protected enum status {ALIVE,DEAD}
    protected Character.status state = Character.status.ALIVE;

    protected Faction faction = null;

    protected String name;

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character attackTarget);

    public abstract void heal(Character healTarget);

    public void increaseCurrentHealth(int healthPoint){
        if(this.currentHealth + healthPoint <= this.MAXHEALTH && this.state == status.ALIVE){
            this.currentHealth += healthPoint;
        } else if (this.currentHealth + healthPoint > this.MAXHEALTH){
            this.currentHealth = this.MAXHEALTH;
        }
    }

    //Like toString but roleplay
    public String status() {
        String factionName = "null";
        if (this.faction != null){
            factionName = this.faction.getName();
        }
        return this.name + "{ currentHealth=" + this.currentHealth + ", state=" + this.state + ", faction=" + factionName + " }";
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
}
