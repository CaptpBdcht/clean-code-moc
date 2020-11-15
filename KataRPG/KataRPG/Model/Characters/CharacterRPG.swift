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
    var faction: [Faction]?
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
        if ennemyCharacter.alive == true && !(self === ennemyCharacter) && self.alive {
            if let myFactions = self.faction {
               if myFactions != [] {
                    if let ennemyFactions = ennemyCharacter.faction {
                        
                        let commonFaction: [Faction] = Array(Set(myFactions).intersection(ennemyFactions))
                        
                        if(commonFaction != []) {
                            print("It's an ally")
                        } else {
                            for myFaction in myFactions {
                                for ennemyFaction in ennemyFactions {
                                    if (myFaction.alliesFactions.contains(ennemyFaction)){
                                        print("C UN POTE")
                                    } else {
                                        print("C'est un Ennemy")
                                        ennemyCharacter.takeDamage(damage: 1)
                                    }
                                }
                            }
                        }
                    }
                } else {
                    ennemyCharacter.takeDamage(damage: 1)
                }
                
            }
        } else {
            print("Character already dead or he want to attack himself")
        }
    }
    
    
    func attack(entity:Entities) {
        entity.health -= 1
    }
    
    func heal(allyCharacter: Characters) {
        if allyCharacter.alive == true && self.alive {
            if let myFactions = self.faction {
                if myFactions != [] {
                    if let otherFactions = allyCharacter.faction {
                        
                        let commonFaction: [Faction] = Array(Set(myFactions).intersection(otherFactions))
                        if (commonFaction != []){
                            allyCharacter.health += 1
                        } else {
                            for myFaction in myFactions {
                                for otherFaction in otherFactions {
                                    if (myFaction.alliesFactions.contains(otherFaction)){
                                        print("C UN POTE")
                                        allyCharacter.health += 1
                                    } else {
                                        print("C'est un Ennemy")
                                    }
                                }
                            }
                        }
                        
                    }
                }
                
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
        self.faction?.append(faction)
    }
    
    func leaveFaction(faction: Faction) {
        self.faction = self.faction?.filter { $0 != faction}
    }
    
    func joinAssembly(assembly: Assembly) {
        if(self.assembly == nil && assembly.allowedRoles.contains(self.classNames)) {
            self.assembly = assembly
        }
    }
       
    func leaveAssembly() {
        if self.assembly != nil {
            self.assembly = nil
        }
    }
}

extension CharacterRPG:CustomStringConvertible {
    public var description: String{
        return "name : \(self.name) health : \(self.health)"
    }
}
