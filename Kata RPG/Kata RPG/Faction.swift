//
//  Faction.swift
//  Kata RPG
//
//  Created by norm on 08/11/2020.
//

import Foundation

class Faction: CustomStringConvertible, Equatable{
   
    static func == (lhs: Faction, rhs: Faction) -> Bool {
        return lhs.name == rhs.name
    }
    
    var name: String
    var allyArray: [Faction] = []
    
    var description: String{
        return "\(self.name)"
    }
    
    init(name: String) {
        self.name = name
        }
    
    func addAlly(ally: Faction){
        if(self === ally || (self.allyArray.contains(ally))){
            return
        }
            self.allyArray.append(ally)
            ally.allyArray.append(self)
    }
    
    func removeAlly(ally: Faction){
        if(self === ally){
            return
        }
            for object in allyArray {
                if (object == ally) {
                    allyArray.remove(at: allyArray.firstIndex(of: ally)!)
                    ally.allyArray.remove(at: ally.allyArray.firstIndex(of: self)!)
                }
            }
        }
    
}
