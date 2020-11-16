//
//  Warrior.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

class Warrior: Characters {
    var assembly: Assembly?
    var classNames: Class = Class.warrior
    var faction: [Faction]
    var name: String
    var health: Int = 100 {
        didSet {
            if self.health > 100 {
                self.health = 100
            } else if self.health < 1 {
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
        self.faction = []
    }
    
    func attack(ennemyCharacter: Characters) {
        if !self.isAllyCharacter(otherCharacter: ennemyCharacter) || self === ennemyCharacter {
            ennemyCharacter.takeDamage(damage: damage)
        }
    }
    
    func attack(entity:Entities){
        if self.alive {
            entity.health -= 1
        }
    }
    
    func heal(allyCharacter: Characters){
        if(self === allyCharacter) && self.alive{
            allyCharacter.health += 1
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
}
