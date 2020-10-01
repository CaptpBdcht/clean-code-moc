import kotlin.random.Random

class Priest(
    name: String,
    health: Int = 100
): Character(name, health) {

    override fun attack(otherCharacter : Character) =
        println("${otherCharacter.name} didn't take any damage !")

    override fun heal(aCharacter: Character) {
        val healValue = Random.nextInt(5, 11)
        println("$this healed $aCharacter for $healValue pv")

        aCharacter.health += healValue

        if (aCharacter.health > 100)
            aCharacter.health = 100
    }

    //for tests
    fun heal(aCharacter: Character, healValue : Int) {
        println("$this healed $aCharacter for $healValue pv")

        aCharacter.health += healValue

        if (aCharacter.health > 100)
            aCharacter.health = 100
    }
}
