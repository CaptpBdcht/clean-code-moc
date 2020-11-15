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
    Link.alive = false
    Link.health = 0
    Link.attack(target: Ganon)
    Link.heal(target: Link)
}

func characterHealing() {
    Link.alive = true
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
    Ganon.alive = true
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

func fifthIteration(){
    let Metroid = Entity(name: "Metroid")
    Metroid.health = 50
    print(Metroid)
    print(Zelda)
    Zelda.heal(target: Metroid)
    print(Metroid)
}

func sixthIteration(){
    addAllyFaction()
    removeAllyFaction()
    attackAllyFaction()
}

func addAllyFaction(){
    Hyrule.addAlly(ally: Zebes)
    
    Hyrule.addAlly(ally: Zebes)
    Hyrule.addAlly(ally: Hyrule)
    Zebes.addAlly(ally: Hyrule)

    Hyrule.showAlly()
    Zebes.showAlly()
}

func removeAllyFaction(){
Hyrule.removeAlly(ally: Zebes)
Hyrule.showAlly()
Zebes.showAlly()
}

func attackAllyFaction(){
    Hyrule.addAlly(ally: Zebes)
    Hyrule.showAlly(); Zebes.showAlly()
    Link.joinFaction(faction: Hyrule)
    Samus.joinFaction(faction: Zebes)
    print(Link,Samus)
    Link.attack(target: Samus)
    print(Link,Samus)
}

func seventhIteration(){
    addMultipleFaction()
}

func addMultipleFaction(){
    print(Link)
    Link.joinFaction(faction: Hyrule)
    Link.joinFaction(faction: Zebes)
    print(Link)
    Link.leaveFaction(faction: Zebes)
    print(Link)
}

let A1 = Assembly(name: "A1")
let A2 = Assembly(name: "A2")
let c1 = Character(name: "c1")

func eighthIteration(){
    
    A1.addRole(role: "Priest")
    A1.addRole(role: "Warrior")
    Samus.joinAssembly(assembly: A1)
    Zelda.joinAssembly(assembly: A1)
    Link.joinAssembly(assembly: A1)
    Ganon.joinAssembly(assembly: A1)
    print(A1.members)
    print("Master: \(A1.master?.name)")
    Samus.leaveAssembly()
    Samus.leaveAssembly()
    print("Master: \(A1.master?.name)")
    print(A1.members)
    Ganon.leaveAssembly()
    Ganon.leaveAssembly()
    Ganon.leaveAssembly()

    print("Master: \(A1.master?.name)")
    print(A1.members)
    Zelda.leaveAssembly()
    Zelda.leaveAssembly()
    Zelda.leaveAssembly()

    print("Master: \(A1.master?.name)")
    print(A1.members)
    Link.leaveAssembly()
    Link.leaveAssembly()
    Link.leaveAssembly()

    print("Master: \(A1.master?.name)")
    print(A1.members)
    
}

