class Faction(val name: String) {
    private val listOfMembers : MutableList<Character> = mutableListOf()
    private var listOfFriends : MutableList<Faction> = mutableListOf()
    
    fun add(character : Character) {
        this.listOfMembers.remove(character) //in case he is already in
        this.listOfMembers.add(character)
    }

    fun acceptFriend(faction : Faction) {
        listOfFriends.remove(faction)
        listOfFriends.add(faction)
    }

    fun addFactionFriend(faction: Faction) {
        listOfFriends.remove(faction)
        listOfFriends.add(faction)
        faction.acceptFriend(this)
    }

    fun remove(character : Character) {
        this.listOfMembers.remove(character)
    }

    fun isMember(character : Character) =
        this.listOfMembers.contains(character)

    fun isMemberOrFriend(character : Character) : Boolean {
        for (friend in this.listOfFriends) {
            if (this.isMember(character))
                return true
        }
        return this.isMember(character)
    }

    fun isFriend(faction : Faction) =
        this.listOfFriends.contains(faction)

    override fun toString(): String {
        var characters = "characters in ${this.name}:\n"
        var friends = "friend factions:\n"

        if (this.listOfMembers.isEmpty()){
            characters = "no characters in faction\n"
        } else {
            for (character in this.listOfMembers)
                characters += "$character\n"
        }

        if (this.listOfFriends.isEmpty()){
            characters = "this faction has no friends\n"
        } else {
            for (friend in this.listOfFriends)
                friends += "$friend\n"
        }

        return characters + friends
    }
}

//problème toString