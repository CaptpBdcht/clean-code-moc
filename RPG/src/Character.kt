abstract class Character (override val name : String, override var health : Int) : Entity(name, health) {
    protected val factions : MutableList<Faction> = mutableListOf()
    private var assembly : Assembly? = null

    protected fun isEnemy(aCharacter: Character): Boolean {
        
        if (this.factions.size > 0) {
            println("${aCharacter.name} is a friend")
            for (faction in this.factions) {
                if (faction.hasMemberOrFriend(aCharacter))
                    return false
            }
        }
        //no faction
        return this != aCharacter
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

    open fun heal(aCharacter : Character, healValue : Int) {
        println("$this healed $aCharacter")

        if (0 < aCharacter.health && aCharacter.health < 100 && !isEnemy(aCharacter))
            aCharacter.health += healValue
    }

    fun join(faction : Faction) {
        this.factions.remove(faction)
        this.factions.add(faction)
        faction.add(this)
    }

    fun leave(faction : Faction) {
        this.factions.remove(faction)
        faction.remove(this)
    }

    fun join(assembly : Assembly) {
        //master if first
        if(assembly.allowedRoles.contains(this::class.simpleName)) {
            if (this.assembly != null)
                this.leave(assembly)

            this.assembly = assembly
            assembly.add(this)
        }
    }

    fun leave(assembly : Assembly) {
        this.assembly = null
        assembly.remove(this)
    }
}