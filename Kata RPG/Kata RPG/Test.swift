//
//  Test.swift
//  Kata RPG
//
//  Created by norm on 05/11/2020.
//

import Foundation

let c1 = Character(name: "Link")
let c2 = Character(name: "Ganon")
let c3 = Character(name: "Zelda")

func firstIteration(){
    characterIsDead()
    characterHealing()
}

func characterIsDead() {
  
    print(c1)
    print(c2)

    for _ in 1...150 {
        c1.attack(target: c2)
    }
    print(c2)
}

func characterHealing() {
    print(c1)
    print(c2)
    
    for _ in 1...150 {
        c1.heal(target: c2)
    }
    print(c2)
}


