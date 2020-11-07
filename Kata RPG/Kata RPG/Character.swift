//
//  Character.swift
//  Kata RPG
//
//  Created by norm on 04/11/2020.
//

import Foundation

class Character: CustomStringConvertible {
   

    
    var name: String
    var health: Int =  100
    var lifeStatus : Bool = true
    
    var description: String{
        return "\(self.name )|\(self.health )|\(self.lifeStatus )"
    }
    
    init(name: String) {
        self.name = name
        }
    
    func attack(target: Character){
        target.health -= 1
        if (target.health < 0) {
            target.health = 0
            target.lifeStatus = false
        }
    }
    
 
    
    func heal(target: Character){
        target.health += 1
        target.lifeStatus = true
        if (target.health > 100) {
            target.health = 100
        }
    }
    
    
}
