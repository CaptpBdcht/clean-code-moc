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
    var lifeStatus : Bool = true
    var faction: Faction?
    
    var description: String{
        if let _: Faction = faction  {
            return "\(self.name)|\(self.health)|\(self.faction!)"
        } else {
        return "\(self.name )|\(self.health)"
        }
    }
    
    
    init(name: String) {
        self.name = name
        }
    
    
    
    
    func joinFaction(faction: Faction){
        self.faction = faction
    }
    
    func leaveFaction(){
        self.faction = nil
    }
    
    
}
