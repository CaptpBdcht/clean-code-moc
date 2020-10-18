//
//  Priest.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

class Priest: Characters {
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
    var damage: Int = Int.random(in: 5...10)
    
    init(name: String) {
        self.name = name
    }
    
    func heal(allyCharacter: Characters){
        if(!(self === allyCharacter) && (self.faction === allyCharacter.faction)){
            allyCharacter.health += damage
        } else if (allyCharacter.health > 99){
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

