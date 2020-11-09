public class BasicHealer implements Healer {
    @Override
    public void heal(Character character) {
        character.setHealth(character.getHealth() + 1);
    }
}
