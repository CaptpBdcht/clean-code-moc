import kotlin.random.Random

class Priest(
    name: String,
    health: Int = 100
): Character(name, health) {

    fun attack(anEntity : Entity) {
        super.attack(anEntity, 0)
        println("${anEntity.name} didn't take any damage !")
    }

    fun heal(aCharacter: Character) = 
        super.heal(aCharacter, Random.nextInt(5, 11))
}
