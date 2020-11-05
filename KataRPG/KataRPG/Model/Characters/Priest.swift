//
//  Priest.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

class Priest: Characters {
    var faction: [Faction]?
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
    }
    
    func heal(allyCharacter: Characters){
        if allyCharacter.alive == true && self.alive {
            if let myFactions = self.faction {
                if let otherFactions = allyCharacter.faction {
                    let commonFaction: [Faction] = Array(Set(myFactions).intersection(otherFactions))
                    if (commonFaction != []){
                        allyCharacter.health += damage
                    } else {
                        for myFaction in myFactions {
                            for otherFaction in otherFactions {
                                if (myFaction.alliesFactions.contains(otherFaction)){
                                    print("C UN POTE")
                                    allyCharacter.health += damage
                                } else {
                                    print("C'est un Ennemy")
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
    
}

