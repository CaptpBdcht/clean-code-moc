//
//  Assembly.swift
//  Kata RPG
//
//  Created by norm on 11/11/2020.
//

import Foundation

class Assembly: Faction{
    
    var allowedRoles: [String] = []
    var master: Character?
    var members: [Character] = []

    func addRole(role: String){
        if(self.allowedRoles.contains(role)){
            return
        }
        self.allowedRoles.append(role)
    }
    
}
