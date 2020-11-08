//
//  Entity.swift
//  Kata RPG
//
//  Created by norm on 08/11/2020.
//

import Foundation

class Entity: Character {
    
    override func joinFaction(faction: Faction) {
        print("\(self.name) is an entity and can't join a faction")
    }
    
    override func leaveFaction() {
        print("\(self.name) is an entity and can't leave a faction")
    }
    
}
