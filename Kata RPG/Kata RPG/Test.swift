//
//  Test.swift
//  Kata RPG
//
//  Created by norm on 05/11/2020.
//

import Foundation

let c1 = Character(name: "Link")
let w1 = Warrior(name: "Ganon")
let c2 = Character(name: "Zelda")

func firstIteration(){
    
    characterAttack()
    characterisDead()
    characterHealing()
    characterCantAttackHimself()
}

func characterAttack() {
  
    print(c1)
    print(w1)

    for _ in 1...150 {
        c1.attack(target: w1)
    }
    print(w1)
}

func characterisDead(){
    c1.lifeStatus = false
    c1.health = 0
    c1.attack(target: w1)
    c1.heal(target: c1)
}

func characterHealing() {
    c1.lifeStatus = true
    c1.health = 100
    print(c1)
    print(w1)
    
    for _ in 1...150 {
        c1.heal(target: w1)
    }
    print(w1)
}

func characterCantAttackHimself(){
    c1.attack(target: c1)
}



func secondIteration(){
    w1.lifeStatus = true
    w1.health = 100
    print(w1)
    warriorAttackHimself()
    print(w1)
    warriorHealingonOnlyHimself()
}

func warriorAttackHimself(){
    w1.attack(target: w1)
}

func warriorHealingonOnlyHimself(){
    w1.heal(target: w1)
    w1.heal(target: c1)
}


