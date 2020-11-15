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
    var faction: [Faction]?
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
        if (self === ennemyCharacter) {
            ennemyCharacter.takeDamage(damage: damage)
        } else if ennemyCharacter.alive == true && !(self === ennemyCharacter) && self.alive {
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
                                        ennemyCharacter.takeDamage(damage: damage)
                                    }
                                }
                            }
                        }
                    }
                    
                } else {
                    ennemyCharacter.takeDamage(damage: damage)
                }
                
            }
        } else {
            print("Character already dead or he want to attack himself")
        }
    }
    
    func attack(entity:Entities){
        if self.alive {
            entity.health -= 1
        } else {
            print("\(self.name) cannot attack because is dead")
        }
    }
    
    func heal(allyCharacter: Characters){
        if(self === allyCharacter) && self.alive{
            allyCharacter.health += 1
        } else{
            print("not possible")
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
