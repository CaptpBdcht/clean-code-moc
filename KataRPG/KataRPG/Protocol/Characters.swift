//
//  Characters.swift
//  KataRPG
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

@objc protocol Characters : class, Entities {
    var name: String { get set }
    var alive: Bool { get set }
    var faction: [Faction] { get set }
    var assembly: Assembly? { get set }
    var classNames: Class { get }
    
    @objc optional func attack(ennemyCharacter: Characters)
    func heal(allyCharacter: Characters)
    func takeDamage(damage: Int)
}
