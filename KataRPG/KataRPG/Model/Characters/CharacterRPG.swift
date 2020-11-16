//
//  CharacterRPG.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation
public class CharacterRPG: Characters {
    var classNames: Class = Class.characterRPG
    var faction: [Faction]
    var assembly: Assembly?
    var name: String = ""
    var alive: Bool = true
    var health: Int = 100 {
        didSet {
            if(self.health > 100) {
                print("Vie superieur à 100 reset à 100")
                self.health = 100
            } else if(self.health < 1) {
                self.alive = false
                if(self.health < 0) {
                    self.health = 0
                }
            }
        }
    }
    
    init(name: String) {
        self.name = name
        self.faction = []
    }
    
    func attack(ennemyCharacter: Characters) {
        if !self.isAllyCharacter(otherCharacter: ennemyCharacter) {
            ennemyCharacter.takeDamage(damage: 1)
        }
    }
    
    func attack(entity:Entities) {
        entity.health -= 1
    }
    
    func heal(allyCharacter: Characters) {
        if !self.isAllyCharacter(otherCharacter: allyCharacter) {
            allyCharacter.health += 1
        }
    }
    
    
}
