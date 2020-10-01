fun main(){
/*
// ==== CHARACTER ===== //
    val rogue = Character("Valeera")
    val warlock = Character("Guldan", 8)

    println(rogue)
    println(warlock)

    println("\n// ==== CHARACTER ===== //")
    rogue.attack(warlock)
    rogue.attack(rogue)
    println(rogue)
    println(warlock)

    println()
    warlock.heal(rogue)
    warlock.heal(warlock)
    println(rogue)
    println(warlock)
*/
// ==== WARRIOR ===== //
    println("\n// ==== WARRIOR ===== //")
    val strongWarrior = Warrior("Garrosh")
    val weakWarrior = Warrior("WeakGarrosh", 50)

    strongWarrior.attack(strongWarrior, 9)
    println(strongWarrior)

    strongWarrior.attack(weakWarrior, 9)
    println(weakWarrior)

    println()
    strongWarrior.heal()
    println(strongWarrior)

// ==== PRIEST ===== //
    println("\n// ==== PRIEST ===== //")
    val priest = Priest("Anduin")
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
    println("contains Garrosh?  ${faction.isMember(strongWarrior)}")
    println("contains Anduin?  ${faction.isMember(priest)}")
    weakWarrior.join(faction)
    println("\n" + faction)
    weakWarrior.leave(factionWithNobody)
    strongWarrior.attack(weakWarrior)
}