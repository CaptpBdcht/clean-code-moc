//
//  Character.swift
//  Kata RPG
//
//  Created by norm on 04/11/2020.
//

import Foundation

class Character: CustomStringConvertible, Equatable {
    
    static func == (lhs: Character, rhs: Character) -> Bool {
        return lhs.name == rhs.name
    }
    
  
    
    
    var name: String
    var health: Int =  100
    var alive: Bool = true
    var faction: [Faction] = []
    var assembly: Assembly!
    
    var description: String{
        return "\(self.name )|\(self.health)|Faction:\(self.faction)|Assembly:\(self.assembly ?? nil)"
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
