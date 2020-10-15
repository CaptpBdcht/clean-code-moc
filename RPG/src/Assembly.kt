import kotlin.random.Random

class Assembly (name : String, val allowedRoles : Array<String>) : Faction(name) {
    private var masterUser : Character? = null

    private fun masterIs(aCharacter : Character) : Boolean {
        if (this.masterUser != null)
            return aCharacter == masterUser
        else
            return false
    }

    fun setAssemblyName(character : Character, name : String) {
        this.name = if (masterIs(character)) name else this.name
    }

    override fun add(character : Character){
        super.add(character)
        if (this.masterUser == null)
            this.masterUser = character
    }

    override fun remove(character : Character){
        super.remove(character)
        if (character == this.masterUser && this.listOfMembers.isNotEmpty())
            this.masterUser = this.listOfMembers[Random.nextInt(this.listOfMembers.size)]
    }

    fun renameAssembly(master : Character, newName : String){
        if (master == this.masterUser)
            this.name = newName
    }
}
