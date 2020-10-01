abstract class Character(
    val name: String,
    var health: Int = 100,
    val faction: Faction? = null
) {

    private fun alive() = this.health > 0

    open fun attack(otherCharacter : Character) {
        println("$this attacked $otherCharacter")
        if (otherCharacter.alive() && this != otherCharacter && this.faction != null && this.faction?.isMember(otherCharacter))
            otherCharacter.health -= 1
    }

    open fun heal(aCharacter : Character) {
        println("$this healed $aCharacter")
        if (aCharacter.health < 100)
            aCharacter.health += 1
    }

    fun join(faction : Faction) =
        faction.add(this)

    fun leave(faction : Faction) =
        faction.remove(this)

    override fun toString(): String = "${this.name} [health:${this.health}/100]"
}

//reminder :
//heal a dead man?
//warrior hit itself but not his faction??

//TODO
//always call open function in abstract class