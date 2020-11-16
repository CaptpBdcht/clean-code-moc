//
//  Extension+Characters.swift
//  KataRPG
//
//  Created by Cindy Nguyen on 15/11/2020.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

extension Characters {
    
    func hasFaction() -> Bool {
        if !self.faction.isEmpty {
            return true
        }
        return false
    }
    
    func findCommonFaction(otherFaction: [Faction]) -> [Faction] {
        return Array(Set(self.faction).intersection(otherFaction))
    }
    
    func isAllyFaction(otherFactions: [Faction]) -> Bool {
        for myFaction in self.faction {
            for otherFaction in otherFactions {
                if (myFaction.alliesFactions.contains(otherFaction)){
                    return true
                }
            }
        }
        return false
    }
    
    func haveCommonFaction(otherCharacter: Characters) -> Bool {
        if self.hasFaction() && otherCharacter.hasFaction() {
            let commonFaction: [Faction] = findCommonFaction(otherFaction: otherCharacter.faction)
            if(!commonFaction.isEmpty || isAllyFaction(otherFactions: otherCharacter.faction)) {
                return true
            }
        }
        return false
    }
    
    func isAllyCharacter(otherCharacter: Characters) -> Bool {
        if otherCharacter.alive && !(self === otherCharacter) && self.alive {
            if haveCommonFaction(otherCharacter: otherCharacter) {
                return true
            }
        }
        return false
    }
    
    func joinFaction(faction: Faction) {
        self.faction.append(faction)
    }
    
    func leaveFaction(faction: Faction) {
        self.faction = self.faction.filter { $0 != faction}
    }
    
    func joinAssembly(assembly: Assembly) {
        if self.assembly == nil {
            assembly.addMember(character: self)
        }
    }
    
    func leaveAssembly() {
        if self.assembly != nil {
            self.assembly?.deleteMember(character: self)
            self.assembly = nil
        }
    }
    
    func isAssemblyMaster() -> Bool {
        return self === self.assembly?.master
    }
    
    func updateAssemblyName(name: String) {
        if isAssemblyMaster() {
            self.assembly?.updateAssemblyName(name: name)
        }
    }
    
    
}
