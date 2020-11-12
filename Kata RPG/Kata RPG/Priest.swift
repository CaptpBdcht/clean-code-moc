//
//  Priest.swift
//  Kata RPG
//
//  Created by norm on 07/11/2020.
//

import Foundation

class Priest: Character {


    func attack(target: Character){
        print("\(self.name) is a priest and can't attack")
    }
            
    func heal(target: Character) {
        if(self.alive && [] == self.faction.filter(target.faction.contains) ){
                    target.health += Int.random(in: 5...10)
                    target.alive = true
                    if (target.health > 100) {
                        target.health = 100
                    }
        }
    }

}
