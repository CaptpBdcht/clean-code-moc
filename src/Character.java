public abstract class Character {

    protected int MAXHEALTH = 100;
    protected int currentHealth = MAXHEALTH;
    protected enum status {ALIVE,DEAD}
    protected Character.status state = Character.status.ALIVE;

    protected String name;

    public void attack(Character attackTarget){
        if(attackTarget.state != status.DEAD && this != attackTarget){
            attackTarget.currentHealth -= 1;
            if (attackTarget.currentHealth == 0){
                attackTarget.state = status.DEAD;
            }
        }
    }

    public void heal(Character healTarget){

        if(healTarget.currentHealth<healTarget.MAXHEALTH && healTarget.state != status.DEAD ){
            healTarget.currentHealth +=1;
        }

    }

}
