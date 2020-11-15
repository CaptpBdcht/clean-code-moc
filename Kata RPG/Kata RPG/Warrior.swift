//
//  Warrior.swift
//  Kata RPG
//
//  Created by norm on 07/11/2020.
//

import Foundation

class Warrior: Character {
   
    func attack(target: Character){
        if(self.alive && [] == self.factions.filter(target.factions.contains)){
               target.health -= Int.random(in: 1...9)
               if (target.health < 0) {
                   target.health = 0
                   target.alive = false
               }
           }
       }
    
    func attackEntity(target: Entity){
        if(self.alive){
               target.health -= Int.random(in: 1...9)
               if (target.health < 0) {
                   target.health = 0
                   target.alive = false
               }
           }
       }

     func heal(target: Character){
        if(self.alive && self === target){
                target.health += 1
                target.alive = true
                if (target.health > 100) {
                    target.health = 100
               }
        }
     }
    
}
