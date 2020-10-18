//
//  CharacterRPG.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation
public class CharacterRPG:Characters{
    
    vvar faction: Faction?
    var name: String = ""
    var health: Int = 100
    var alive: Bool = true
    
    init(name: String) {
        self.name = name
    }
    
    func attack(ennemyCharacter: Characters){
        if(ennemyCharacter.alive == true && !(self === ennemyCharacter) && !(ennemyCharacter.faction === self.faction)){
            ennemyCharacter.takeDamage(damage: 1)
        } else {
            print("Character already dead!")
        }
    }
    
    func heal(allyCharacter: Characters){
        if (allyCharacter.health > 99){
            print("Max health reached!")
        } else if(self.faction === allyCharacter.faction) { 
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
    
    func joinFaction(faction: Faction) {
        self.faction = faction
    }
    
    func leaveFaction() {
        self.faction = nil
    }
    
    
}

extension CharacterRPG:CustomStringConvertible{
    public var description: String{
        return "name : \(self.name) health : \(self.health)"
    }
}
