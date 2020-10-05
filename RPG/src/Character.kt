abstract class Character (override val name : String, override var health : Int) : Entity(name, health) {
    private val factions : MutableList<Faction> = mutableListOf()

    private fun isEnemy(aCharacter: Character): Boolean {
        if (this.factions.size > 0) {
            for (faction in this.factions) {
                if (!faction.isMemberOrFriend(aCharacter))
                    return true
            }
            println("$aCharacter.name is a friend")
            return false
        }

        //no faction
        return true
    }

    private fun isEnemy(anEntity: Entity) : Boolean {
        if (anEntity is Character)
            return isEnemy(anEntity)

        return true
    }

    open fun attack(anEntity : Entity, damage : Int) {
        println("$this attacked $anEntity")
 
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

    override fun toString(): String = super.toString()
}