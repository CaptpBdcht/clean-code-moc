public class Character {
    private String name;
    private int health = 100;
    private Faction faction;

    Character(String name) {
        this.name = name;
        faction = null;
    }

    public void setHealth(int health) {
        if (this.isMaximumHealth(health)) {
            this.health = 100;
        }
        else if (this.isMinimumHealth(health)) {
            this.health = 0;
        }
        else {
            this.health = health;
        }
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Character character) {
        if (character.getFaction() == this.faction && this.faction != null) {
            return;
        }
        boolean success = !this.equals(character) && character.isAlive();
        if (success) {
            character.setHealth(character.getHealth() - 1);
        }
    }

    public void heal(Character character) {
        if (this.getFaction() != character.getFaction()) {
            return;
        }
        character.setHealth(character.getHealth() + 1);
    }

    public void joinFaction(Faction faction) {
        this.faction = faction;
    }

    public void leaveFaction() {
        if (this.faction == null) {
            return;
        }
        this.faction = null;
    }

    public Faction getFaction() {
        return this.faction;
    }

    private boolean isMaximumHealth(int value){
        return value > 100;
    }

    private boolean isMinimumHealth(int value){
        return value < 0;
    }

}
