//
//  Faction.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation
class Faction: NSObject {
    var name: String
    var alliesFactions:[Faction] = []
    
    init(name: String) {
        self.name = name
    }
    
    func addAlly(allyFaction:Faction){
        if !(self === allyFaction) {
            self.alliesFactions.append(allyFaction)
        }else{
            print("U CANT ADD URSELF AS ALLY")
        }
        
    }
    
}
