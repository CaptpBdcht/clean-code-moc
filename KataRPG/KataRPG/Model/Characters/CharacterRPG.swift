//
//  CharacterRPG.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation
public class CharacterRPG:Characters{
    var faction: Faction?
    var name: String = ""
    var alive: Bool = true
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
    
    init(name: String) {
        self.name = name
    }
    
    func attack(ennemyCharacter: Characters){
        if ennemyCharacter.alive == true && !(self === ennemyCharacter) && self.alive {
            if let myFaction = self.faction {
                if let ennemyFaction = ennemyCharacter.faction {
                    if !(myFaction === ennemyCharacter.faction){
                        if myFaction.alliesFactions.contains(ennemyFaction){
                            print("CEST UN POTE")
                        } else {
                            ennemyCharacter.takeDamage(damage: 1)
                        }
                    }
                } else {
                    ennemyCharacter.takeDamage(damage: 1)
                }
            } else {
                ennemyCharacter.takeDamage(damage: 1)
            }
        } else {
            print("Character already dead or he want to attack himself")
        }
    }
    
    
    func attack(entity:Entities){
        entity.health -= 1
    }
    
    func heal(allyCharacter: Characters){
        
        
        if allyCharacter.alive == true && self.alive {
            if let myFaction = self.faction {
                if let otherFaction = allyCharacter.faction {
                    
                    if  myFaction === otherFaction || myFaction.alliesFactions.contains(otherFaction){
                        
                        allyCharacter.health += 1
                        
                    } else {
                        print("NOT ALLY FACTION")
                    }
                    
                } else {
                    print("cant heal I dont have any faction")
                }
            } else {
                print("cant heal other character dont have any faction")
            }
        } else {
            print("Character is dead")
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
