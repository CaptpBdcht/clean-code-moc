//
//  Character.swift
//  Kata RPG
//
//  Created by norm on 04/11/2020.
//

import Foundation

class Character: Entity, CustomStringConvertible, Equatable {
    
    var factions: [Faction] = []
    var assembly: Assembly!
    
    static func == (lhs: Character, rhs: Character) -> Bool {
        return lhs.name == rhs.name
    }
    
    var description: String{
        return "\(self.name)|\(self.health)"
    }

    

    func joinFaction(faction: Faction){
        if (self.factions.contains(faction)){
            return
        }
        self.factions.append(faction)
    }
    
    func leaveFaction(faction: Faction){
        if let index = self.factions.firstIndex(of: faction) {
            self.factions.remove(at: index)
        }
    }
    
    func joinAssembly(assembly: Assembly){
        let role = String(describing: type(of: self))
        if(assembly.allowedRoles.contains(role) && self.assembly == nil){
            self.assembly = assembly
            assembly.members.append(self)
            if(assembly.master == nil){
                assembly.master = self
            }
    }
    }
    
    func leaveAssembly(){
        if(self.assembly?.master === self){
            if let index = self.assembly.members.firstIndex(of: self) {
                self.assembly.members.remove(at: index)
            }
            self.assembly.master = self.assembly.members.randomElement()
            }
        self.assembly = nil
    }
    
    func renameAssembly(name: String){
        if(self.assembly?.master == self){
            assembly.name = name
        }
    }
    
}
