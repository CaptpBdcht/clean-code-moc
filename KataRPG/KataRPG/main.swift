//
//  main.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

let char1:CharacterRPG = CharacterRPG(name: "Jean")
let char2:CharacterRPG = CharacterRPG(name: "Bernard")

print("Char 1 : \(char1)")
print("Char 2 : \(char2)")

char1.attack(ennemyCharacter: char2)
print("Char 2 : \(char2)")



var faction1:Faction = Faction(name: "toto")
var faction2:Faction = Faction(name: "uuuuu")

faction1.addAlly(allyFaction: faction2)
print(faction1)

faction1.addAlly(allyFaction: faction1)

