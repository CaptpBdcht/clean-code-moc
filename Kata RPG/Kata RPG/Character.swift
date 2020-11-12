//
//  Character.swift
//  Kata RPG
//
//  Created by norm on 04/11/2020.
//

import Foundation

class Character: CustomStringConvertible {
  
    
    var name: String
    var health: Int =  100
    var alive: Bool = true
    var faction: [Faction] = []
    
    var description: String{
        return "\(self.name )|\(self.health)|\(self.faction)"
    }
    
    init(name: String) {
        self.name = name
        }
    
    func joinFaction(faction: Faction){
        if (!(self.faction.contains(faction))){
        self.faction.append(faction)
        }
    }
    
    func leaveFaction(faction: Faction){
        if let index = self.faction.firstIndex(of: faction) {
            self.faction.remove(at: index)
        }
    }
    
}
