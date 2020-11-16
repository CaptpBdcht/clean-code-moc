//
//  Priest.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

class Priest: Characters {
    var assembly: Assembly?
    var classNames: Class = Class.priest
    var faction: [Faction]
    var name: String
    var health: Int = 100 {
        didSet {
            if self.health > 100 {
                print("Vie superieur à 100 reset à 100")
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
    var damage: Int = Int.random(in: 5...10)
    
    init(name: String) {
        self.name = name
        self.faction = []
    }
    
    func heal(allyCharacter: Characters){
        if self.isAllyCharacter(otherCharacter: allyCharacter) || self === allyCharacter {
            allyCharacter.health += damage
        }
    }
    
   
}

