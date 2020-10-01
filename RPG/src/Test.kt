fun main(){
    val character = Character("jean")
    val lowLife = Character("michel", 8)

    println(character)
    println(lowLife)

    println()
    character.attack(lowLife)
    character.attack(character)
    println(character)
    println(lowLife)

    println()
    lowLife.heal(character)
    lowLife.heal(lowLife)
    println(character)
    println(lowLife)

    println()
    val strongWarrior = Warrior("strongman", 9)
    strongWarrior.attack(strongWarrior)
    println(strongWarrior)
    strongWarrior.attack(lowLife)
    println(lowLife)

    println()
    strongWarrior.heal()
    println(strongWarrior)
}