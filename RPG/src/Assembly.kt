import kotlin.random.Random

class Assembly (name : String, val allowedRoles : Array<String>) : Faction(name) {
    private var masterUser : Character? = null

    private fun masterIs(aCharacter : Character) : Boolean {
        if (this.masterUser != null)
            aCharacter == masterUser
        else
            false
    }

    fun setAssemblyName(aCharacter : Character, name : String) {
        this.name = if (masterIs(aCharacter)) name else this.name
    }

    override fun add(aCharacter){
        super.add(aCharacter)
        if (this.masterUser == null)
            this.master = aCharacter
    }

    override fun remove(aCharacter){
        super.remove(aCharacter)
        if (aCharacter == this.masterUser)
            Random.nextInt
    }

    changingNameByTo(master : Character, newName : String){
        if (master == this.masterUser)
            this.name = newName
    }
}
