open class Faction(var name: String) {
    private val listOfMembers : MutableList<Character> = mutableListOf()
    private val listOfFriends : MutableList<Faction> = mutableListOf()
    
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

    fun hasMember(character : Character) =
        this.listOfMembers.contains(character)

    fun hasMemberOrFriend(character : Character) : Boolean {
        for (friend in this.listOfFriends) {
            if (friend.hasMember(character))
                return true
        }
        return this.hasMember(character)
    }
/*
    fun isFriend(faction : Faction) =
        this.listOfFriends.contains(faction)
 */

    override fun toString(): String {
        val groupType = if(this is Assembly) "assembly" else "faction"
        var characters = "characters in ${this.name}:\n"
        var friends = "friend $groupType:\n"

        if (this.listOfMembers.isEmpty())
            characters = "no characters in $groupType\n"
        else
            for (character in this.listOfMembers)
                characters += "$character\n"

        if (this.listOfFriends.isEmpty())
            characters = "this $groupType has no friends\n"
        else
            for (friend in this.listOfFriends)
                friends += "${friend.name}\n"

        return characters + friends
    }
}