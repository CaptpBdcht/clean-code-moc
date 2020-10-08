class Assembly (name : String) : Faction(name) {
    private val listOfMembers : MutableList<Character> = mutableListOf()
    private var listOfFriends : MutableList<Faction> = mutableListOf()
    private var masterUser : Character? = null

    private fun isMaster(aCharacter : Character) : Boolean {
        return aCharacter == masterUser
    }

    // je ne sais pas si on peut faire autrement, car j'ai besoin du character ici
    // avec un setter ça ne m'a pas l'air possible, de passer une autre valeur !
    fun setAssemblyName(aCharacter : Character, name : String) {
        this.name = if (isMaster(aCharacter)) name else this.name
    }

    override fun toString() : String {
        return ""
    }
}