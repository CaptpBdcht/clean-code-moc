import kotlin.random.Random

class Warrior(
    name: String,
    health: Int = 100,
) : Character(name, health) {

    fun attack(anEntity : Entity) =
        super.attack(anEntity, Random.nextInt(10))

    override fun isEnemy(aCharacter : Character) : Boolean {
        if (this == aCharacter)
            return true

        return super.isEnemy(aCharacter)
    }

    fun heal() {
        println("$this healed itself")
        if (0 < this.health && this.health < 100)
            this.health++
    }
}