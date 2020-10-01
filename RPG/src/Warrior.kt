import kotlin.random.Random

class Warrior(
    name: String,
    health: Int = 100,
) : Character(name, health) {

    override fun attack(aCharacter: Character) {
        val damage = Random.nextInt(10)
        println("$this attacked $aCharacter with $damage damage")
        aCharacter.health -= damage
        if (aCharacter.health < 0)
            aCharacter.health = 0
    }

    //for tests
    fun attack(aCharacter : Character, damage : Int) {
        println("$this attacked $aCharacter")
        aCharacter.health -= damage
        if (aCharacter.health < 0)
            aCharacter.health = 0
    }

    fun heal() = super.heal(this)
}