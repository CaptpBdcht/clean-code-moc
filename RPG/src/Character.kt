abstract class Character (val name : String, var health : Int = 100, val faction: Faction? = null) : Entity(name, health) {

    private fun isEnemy(aCharacter: Character): Boolean {
        if (this.faction != null)
            return !aCharacter.faction?.isMember(aCharacter)!!
        return true
    }

    open fun attack(anEntity : Entity, damage : Int) {
        println("$this attacked $aCharacter")

        if (anEntity.alive() && isEnemy(anEntity))
            anEntity.health -= damage

        if (anEntity.health < 0)
            anEntity.health = 0
    }

    open fun heal(aCharacter : Character, healValue: Int = 1) {
        println("$this healed $aCharacter")

        if (0 < aCharacter.health && aCharacter.health < 100 && !isEnemy(aCharacter))
            aCharacter.health += healValue
    }

    fun join(faction : Faction) =
        faction.add(this)

    fun leave(faction : Faction) =
        faction.remove(this)

    override fun toString(): String = "${this.name} [health:${this.health}/100]"
}