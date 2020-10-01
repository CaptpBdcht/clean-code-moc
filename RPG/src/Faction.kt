class Faction(val name: String) {
    private val listOfMembers : MutableList<Character> = mutableListOf()
    
    fun add(character : Character) {
        this.listOfMembers.remove(character) //in case he is already in
        this.listOfMembers.add(character)
    }

    fun remove(character : Character) {
        this.listOfMembers.remove(character)
    }

    fun isMember(character : Character) =
        listOfMembers.contains(character)

    override fun toString(): String {
        var characters = "characters in ${this.name}:\n"
        for (character in listOfMembers)
            characters += "${character}\n"
        return characters
    }
}