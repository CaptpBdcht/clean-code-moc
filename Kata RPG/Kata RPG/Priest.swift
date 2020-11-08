//
//  Priest.swift
//  Kata RPG
//
//  Created by norm on 07/11/2020.
//

import Foundation


class Priest: Character {

        override func attack(target: Character){
               print("\(self.name) is a priest and can't attack")
            }


    override func heal(target: Character) {
                    if(self.lifeStatus == true){
                        target.health += Int.random(in: 5...10)
                        target.lifeStatus = true
                        if (target.health > 100) {
                            target.health = 100
                        }
                    }
                    else{
                        print("\(self.name) is dead and can't heal")
                    }
            }

}
