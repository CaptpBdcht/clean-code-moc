fun main(){
    val character = Character("jean")
    val halfLife = Character("michel", 50)

    println(character)
    println(halfLife)

    println()
    character.attack(halfLife)
    character.attack(character)
    println(character)
    println(halfLife)

    println()

    halfLife.heal(character)
    halfLife.heal(halfLife)
    println(character)
    println(halfLife)

}