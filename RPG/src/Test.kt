fun main(){

// ==== WARRIOR ===== //
    println("\n// ==== WARRIOR ===== //")
    val strongWarrior = Warrior("Strong warrior")
    val weakWarrior = Warrior("Weak warrior", 50)

    strongWarrior.attack(strongWarrior, 9)
    println("should have taken damage -> " + strongWarrior + "\n")

    strongWarrior.attack(weakWarrior, 9)
    println("should have taken damage -> " + weakWarrior + "\n")

    weakWarrior.heal()

// ==== PRIEST ===== //
    println("\n// ==== PRIEST ===== //")
    val priest = Priest("Priest", 99)
    priest.heal(weakWarrior, 4)
    priest.heal(weakWarrior)
    println(weakWarrior)
    priest.attack(weakWarrior)

// ==== FACTION ===== //
    println("\n// ==== FACTION ===== //")
    val faction = Faction("super faction")
    val factionWithNobody = Faction("nobody")
    strongWarrior.attack(weakWarrior)
    strongWarrior.join(faction)
    weakWarrior.join(faction)
    println(faction)
    println("contains Garrosh?  ${faction.hasMember(strongWarrior)}")
    println("contains Anduin?  ${faction.hasMember(priest)}")
    weakWarrior.join(faction)
    println("\n" + faction)
    weakWarrior.leave(factionWithNobody)
    strongWarrior.attack(weakWarrior)

// ==== ENTITIES ==== //
// ==== mad warrior attacks a cute pig ===== //
    println("\n// ==== ENTITY ===== //")
    println("A mad warrior attacks a cute pig :0")
    val pig = Entity("Piggy", 2)
    val madWarrior = Warrior("No Pity Warrior")
    println("before attack, piggy is alive ? -> " + pig.isAlive())
    madWarrior.attack(pig, 3)
    println("after attack, piggy is alive ? -> " + pig.isAlive())
    println()


// ==== FACTION FRIENDS ===== //
    val barbare = Warrior("barbare", 99) //warrior without faction
    println("\n// ==== FACTION FRIEND ===== //")
    val famousFaction = Faction("famous")
    val friendFaction = Faction("friend")

    famousFaction.addFactionFriend(friendFaction)

    println(famousFaction)
    println(friendFaction)

    strongWarrior.join(famousFaction)
    weakWarrior.join(friendFaction)

    weakWarrior.attack(strongWarrior)
    println(strongWarrior)
    println(weakWarrior)
    println()

    println("Faction : " + famousFaction)
    println("Faction : " + friendFaction)

   priest.heal(priest)

   // ==== ASSEMBLY ===== //
    println("\n// ==== ASSEMBLY ===== //")
    val assembly = Assembly("assembly", arrayOf(Warrior::class.simpleName.toString(), ""))
    barbare.join(assembly)
    println(assembly)

    //println(barbare::class.simpleName)
}
