public class Healer {
    private Healing healing;

    Healer(Healing healing){ this.healing = healing; }

    Healer() { this.healing.heal(); }
}
