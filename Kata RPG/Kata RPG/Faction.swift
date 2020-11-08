//
//  Faction.swift
//  Kata RPG
//
//  Created by norm on 08/11/2020.
//

import Foundation

class Faction: CustomStringConvertible {
    
    var name: String
    
    var description: String {
        return "\(self.name )"
    }
    
    init(name: String) {
        self.name = name
        }
    
}
