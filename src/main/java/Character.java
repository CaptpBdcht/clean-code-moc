public abstract class Character extends Entity {
    private String name;
    private Faction faction;


    Character(String name) {
        super(100);
        this.name = name;
        faction = null;
    }



    public int getHealth() { return health; }

    public String getName() { return name; }

    public Faction getFaction() { return this.faction; }

    public void attack(Entity entity) {
        if(entity instanceof Character) {
            Character character = (Character) entity;

            if (this.getFaction() != null && this.getFaction().isMember(character)) {
                return;
            }
        }

        boolean success = !this.equals(entity) && entity.isAlive();
        if (success) {
            entity.setHealth(entity.getHealth() - 1);
        }
    }

    public void heal(Entity entity) {
        if(!(entity instanceof Character)) {
            return;
        }

        Character character = (Character) entity;
        if (this.getFaction() != null && this.getFaction().isMember(character)) {
            return;
        }
        character.setHealth(character.getHealth() + 1);
    }


    void joinFaction(Faction faction) {
        faction.addMember(this);
        this.faction = faction;
    }

    void leaveFaction() {
        this.faction.deleteMember(this);
        if (this.faction != null) {
            this.faction = null;
        }
    }

}
