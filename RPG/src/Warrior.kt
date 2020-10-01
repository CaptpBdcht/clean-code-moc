import kotlin.random.Random

class Warrior(
    name: String,
    var damage: Int = Random.nextInt(10),
    health: Int = 100
) : Character(name, health) {

    init{
        if (!(0 <= this.damage && this.damage <= 9))
            this.damage = 0
    }

    override fun attack(aCharacter: Character) {
        println("$this attacks $aCharacter")
        aCharacter.health -= this.damage
        if (aCharacter.health < 0)
            aCharacter.health = 0
    }

    fun heal() = super.heal(this)

    override fun toString(): String = super.toString() + "[Damage: ${this.damage}]"
}