import kotlin.random.Random

class Warrior(
    name: String,
    health: Int = 100,
) : Character(name, health) {

    fun attack(anEntity : Entity) =
        super.attack(anEntity, Random.nextInt(10))

    fun heal() = super.heal(this, 1)
}