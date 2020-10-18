public abstract class Character {

    protected int MAXHEALTH = 100;
    protected int currentHealth = MAXHEALTH;
    protected enum status {ALIVE,DEAD}
    protected Character.status state = Character.status.ALIVE;

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
        return this.name + "{ currentHealth=" + this.currentHealth + ", state=" + this.state + '}';
    }
}
