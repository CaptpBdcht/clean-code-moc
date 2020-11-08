//
//  Warrior.swift
//  Kata RPG
//
//  Created by norm on 07/11/2020.
//

import Foundation

class Warrior: Character {
   
     func attack(target: Character){
        if(self.lifeStatus == true && (self.faction !== target.faction && self.faction != nil && target.faction != nil )){
                target.health -= Int.random(in: 0...9)
                if (target.health < 0) {
                    target.health = 0
                    target.lifeStatus = false
                }
            }
        }
    
    
    
     func heal(target: Character){
        if(self.lifeStatus == true){
            if(self === target){
                target.health += 1
                target.lifeStatus = true
                if (target.health > 100) {
                    target.health = 100
                }
               }
        }
     }
    

}
