import UIKit

@objc protocol Characters : class {
    var name: String { get set }
    var health: Int { get set }
    var alive: Bool { get set }
    var faction: Faction? { get }
    
    @objc optional func attack(ennemyCharacter: Characters)
    func heal(allyCharacter: Characters)
    func takeDamage(damage: Int)
    func joinFaction(faction: Faction)
    func leaveFaction()
}

class Character : Characters {
    var faction: Faction?
    var name: String = ""
    var health: Int = 100
    var alive: Bool = true
    
    init(name: String) {
        self.name = name
    }
    
    func attack(ennemyCharacter: Characters){
        if(ennemyCharacter.alive == true && !(self === ennemyCharacter) && !(ennemyCharacter.faction === self.faction)){
            ennemyCharacter.takeDamage(damage: 1)
        } else {
            print("Character already dead!")
        }
    }
    
    func heal(allyCharacter: Characters){
        if (allyCharacter.health > 99){
            print("Max health reached!")
        } else if(self.faction === allyCharacter.faction) {
            allyCharacter.health += 1
        }
    }
    
    func takeDamage(damage:Int) {
        if(self.alive == true) {
            self.health -= damage
            if(self.health == 0) {
                self.alive = false
            }
        }
    }
    
    func joinFaction(faction: Faction) {
        self.faction = faction
    }
    
    func leaveFaction() {
        self.faction = nil
    }
    
}

class Warrior: Characters {
    var faction: Faction?
    var name: String
    var health: Int = 100
    var alive: Bool = true
    var damage: Int = Int.random(in: 0...9)
    
    init(name: String) {
        self.name = name
    }
    
    func attack(ennemyCharacter: Characters) {
        if(ennemyCharacter.alive == true && (!(ennemyCharacter.faction === self.faction) || (self === ennemyCharacter))){
            ennemyCharacter.takeDamage(damage: damage)
        } else {
            print("Character already dead!")
        }
    }
    
    func heal(allyCharacter: Characters){
        if(self === allyCharacter){
            allyCharacter.health += 1
        } else if (self === allyCharacter && allyCharacter.health > 99){
            print("Max health reached!")
        } else {
            print("You can only heal yourself")
        }
        
        if(allyCharacter.health > 100) {
            allyCharacter.health = 100
        }
    }
    
    func takeDamage(damage:Int) {
        if(self.alive == true) {
            self.health -= damage
            if(self.health == 0) {
                self.alive = false
            }
        }
    }
    
    func joinFaction(faction: Faction) {
        self.faction = faction
    }
    
    func leaveFaction() {
        self.faction = nil
    }
    
}

class Priest: Characters {
    var faction: Faction?
    var name: String
    var health: Int = 100
    var alive: Bool = true
    var damage: Int = Int.random(in: 5...10)
    
    init(name: String) {
        self.name = name
    }
    
    func heal(allyCharacter: Characters){
        if(!(self === allyCharacter) && (self.faction === allyCharacter.faction)){
            allyCharacter.health += damage
        } else if (allyCharacter.health > 99){
            print("Max health reached!")
        } else {
            print("You can only heal yourself")
        }
        
        if(allyCharacter.health > 100) {
            allyCharacter.health = 100
        }
    }
    
    func takeDamage(damage:Int) {
        if(self.alive == true) {
            self.health -= damage
            if(self.health == 0) {
                self.alive = false
            }
        }
    }
    
    func joinFaction(faction: Faction) {
        self.faction = faction
    }
    
    func leaveFaction() {
        self.faction = nil
    }
    
}

class Faction: NSObject {
    var name: String = ""

    init(name: String) {
        self.name = name
    }
}

// TEST
var warrior = Warrior(name: "Bob")
var priest = Priest(name: "Alice")
var gentilWarrior = Warrior(name: "Luc")

warrior.attack(ennemyCharacter: warrior)
warrior.health

warrior.attack(ennemyCharacter: priest)
priest.health

warrior.heal(allyCharacter: warrior)
warrior.health

warrior.heal(allyCharacter: priest)
priest.health

priest.heal(allyCharacter: warrior)
warrior.health

var faction1 = Faction(name: "La Horde")
var faction2 = Faction(name: "La Légion")

//warrior.faction
warrior.joinFaction(faction: faction1)
priest.joinFaction(faction: faction1)
gentilWarrior.joinFaction(faction: faction2)

warrior.attack(ennemyCharacter: gentilWarrior) // OK
gentilWarrior.health
warrior.attack(ennemyCharacter: priest) // OK
priest.health
warrior.attack(ennemyCharacter: warrior)
warrior.health
priest.heal(allyCharacter: gentilWarrior) // OK
gentilWarrior.health
priest.heal(allyCharacter: warrior) // OK
warrior.health


//warrior.faction
//warrior.leaveFaction()
//warrior.faction
//test commit mouss


