//
//  Entity.swift
//  Kata RPG
//
//  Created by norm on 08/11/2020.
//

import Foundation

public class Entity{
    
    var name: String
    var health: Int = 100
    var alive: Bool = true
    
    init(name:String) {
        self.name = name
    }
    
}
