//
//  Warrior.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

class Warrior: Characters {
    var faction: Faction? 
    var name: String
    var health: Int = 100 {
        didSet {
            if self.health > 100 {
                print("Vie superieur à 100 reset à 100")
                self.health = 100
            }else if self.health < 1 {
                self.alive = false
                if self.health < 0 {
                    self.health = 0
                }
            }
        }
    }
    var alive: Bool = true
    var damage: Int = Int.random(in: 0...9)
    
    init(name: String) {
        self.name = name
    }
    
    func attack(ennemyCharacter: Characters) {
       
//
//
//        if(ennemyCharacter.alive == true && (!(ennemyCharacter.faction === self.faction) || (self === ennemyCharacter))){
//            ennemyCharacter.takeDamage(damage: damage)
//        } else {
//            print("Character already dead!")
//        }
        
        
        if ennemyCharacter.alive == true  {
                  
            if let myFaction = self.faction {
                       
                       if let ennemyFaction = ennemyCharacter.faction {
                           
                           if !(myFaction === ennemyCharacter.faction){
                               
                               if myFaction.alliesFactions.contains(ennemyFaction){
                                   print("CEST UN POTE")
                               }else {
                                   ennemyCharacter.takeDamage(damage: damage)
                               }
                               
                           }
                           
                       }else {
                           ennemyCharacter.takeDamage(damage: damage)
                       }
                       
                   }else {
                       ennemyCharacter.takeDamage(damage: damage)
                   }
               }else {
                           print("Character already dead!")
                       }
        
        
    }
    
    func attack(entity:Entities){
           entity.health -= 1
       }
    
    
    
    func heal(allyCharacter: Characters){
        if(self === allyCharacter){
            allyCharacter.health += 1
        } else if (self === allyCharacter && allyCharacter.health > 99){
            print("Max health reached!")
        } else {
            print("You can only heal yourself")
        }
        
        if(allyCharacter.health > 100) {
            allyCharacter.health = 100
        }
    }
    
    func takeDamage(damage:Int) {
        if(self.alive == true) {
            self.health -= damage
            if(self.health == 0) {
                self.alive = false
            }
        }
    }
    
    func joinFaction(faction: Faction) {
        self.faction = faction
    }
    
    func leaveFaction() {
        self.faction = nil
    }
    
}
