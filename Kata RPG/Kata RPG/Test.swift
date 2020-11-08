//
//  Test.swift
//  Kata RPG
//
//  Created by norm on 05/11/2020.
//

import Foundation

let Link = Warrior(name: "Link")
let Ganon = Warrior(name: "Ganon")
let Zelda = Priest(name: "Zelda")

func firstIteration(){
    
    characterAttack()
    characterisDead()
    characterHealing()
    characterCantAttackHimself()
}

func characterAttack() {
  
    print(Link)
    print(Ganon)

    for _ in 1...150 {
        Link.attack(target: Ganon)
    }
    print(Ganon)
}

func characterisDead(){
    Link.lifeStatus = false
    Link.health = 0
    Link.attack(target: Ganon)
    Link.heal(target: Link)
}

func characterHealing() {
    Link.lifeStatus = true
    Link.health = 100
    print(Link)
    print(Ganon)
    
    for _ in 1...150 {
        Link.heal(target: Ganon)
    }
    print(Ganon)
}

func characterCantAttackHimself(){
    Link.attack(target: Link)
}



func secondIteration(){
    Ganon.lifeStatus = true
    Ganon.health = 100
    print(Ganon)
    warriorAttackHimself()
    print(Ganon)
    warriorHealingonOnlyHimself()
}

func warriorAttackHimself(){
    Ganon.attack(target: Ganon)
}

func warriorHealingonOnlyHimself(){
    Ganon.heal(target: Ganon)
    Ganon.heal(target: Link)
}

func thirdIteration(){
    priestAttack()
    priestHeal()
}

func priestAttack(){
    Zelda.attack(target: Ganon)
}

func priestHeal(){
    Zelda.health = 5
    print(Zelda)
    Zelda.heal(target: Zelda)
    print(Zelda)
}



let Hyrule = Faction(name: "Hyrule")
let Zebes = Faction(name: "Zebes")
let Samus = Warrior(name: "Samus")

func fourthIteration(){
    attackAnotherFaction()
    healAnotherFaction()
}

func attackAnotherFaction(){
    print(Link,Ganon)
    Link.joinFaction(faction: Hyrule)
    Ganon.joinFaction(faction: Hyrule)
    Link.attack(target: Ganon)
    print(Link,Ganon)
}

func healAnotherFaction(){
  
    Samus.health = 60
    Ganon.health = 60
    
    print(Zelda,Ganon,Samus)
    Zelda.heal(target: Ganon)
    Zelda.heal(target: Samus)
    print(Zelda,Ganon,Samus)
    
    Samus.joinFaction(faction: Zebes)
    Zelda.joinFaction(faction: Hyrule)
    
    print(Zelda,Ganon,Samus)
    Zelda.heal(target: Ganon)
    Zelda.heal(target: Samus)
    print(Zelda,Ganon,Samus)

}
