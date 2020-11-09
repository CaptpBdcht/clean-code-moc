public abstract class Character extends Entity {
    private String name;
    private Faction faction;

    private BasicHealer basicHealer = new BasicHealer();
    private BasicAttacker basicAttacker = new BasicAttacker();

    Character(String name){
        super(100);
        this.name = name;
        faction = null;
    }

    public String getName() { return name; }

    public Faction getFaction() { return this.faction; }

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
        this.faction = faction;
    }

    public void leaveFaction() {
        this.faction.removeMember(this);
        if (this.faction != null) {
            this.faction = null;
        }
    }

    public boolean hasFaction(){
        return this.faction != null;
    }

    public boolean isAlly(Character character){
        return shareFaction(character) || isFriend(character);
    }

    public boolean shareFaction(Character character){
        return this.hasFaction() && this.faction.hasMember(character);
    }

    public boolean isFriend(Character character){
        return this.hasFaction() && character.hasFaction() && this.faction.hasFriend(character.getFaction());
    }
}
