class Assembly (name : String, val allowedRoles : Array<String>) : Faction(name) {
    private var masterUser : Character? = null

    private fun isMaster(aCharacter : Character) : Boolean =
        if (this.masterUser != null) aCharacter == masterUser else false

    fun setAssemblyName(aCharacter : Character, name : String) {
        this.name = if (isMaster(aCharacter)) name else this.name
    }
}
