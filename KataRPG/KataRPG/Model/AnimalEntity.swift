//
//  Entity.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation
public class AnimalEntity:Entities{
    var name:String
    var health: Int
    
    init(name:String, health:Int) {
        self.name = name
        self.health = health
    }
}
