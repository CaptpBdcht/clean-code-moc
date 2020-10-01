open class Character (val name : String, var health : Int = 100) {

    private fun alive() = this.health > 0

    open fun attack(otherCharacter : Character) {
        println("$this attacks $otherCharacter")
        if (otherCharacter.alive() && this != otherCharacter)
            otherCharacter.health -= 1
    }

    fun heal(aCharacter : Character) {
        println("$this heal $aCharacter")
        if (aCharacter.health < 100)
            aCharacter.health += 1
    }

    override fun toString(): String = "${this.name} [health:${this.health}/100]"
}