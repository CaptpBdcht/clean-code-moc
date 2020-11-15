//
//  Allo.swift
//  RpgAppTests
//
//  Created by norm on 15/11/2020.
//

import XCTest
@testable import RPG_Kata

class Test: XCTestCase {

    func testCharacterName() throws {
        let characterName = Character(name: "Mario")
        let Name = "Mario"
        XCTAssertEqual(characterName.name, Name)
    }
    
    func testcharacterAttack() throws {
        let Attacker = Warrior(name: "Link")
        let Defender = Warrior(name: "Ganon")
        for _ in 1...150 {
            Attacker.attack(target: Defender)
        }
        XCTAssertFalse(Defender.alive)
    }
    
    func testHealingCharacter() throws {
        let Healer = Warrior(name: "Link")
        Healer.health = 30
        for _ in 1...150 {
            Healer.heal(target: Healer)
        }
        XCTAssertEqual(Healer.health, 100)
    }
    
    func testWarriorAttackHimself() throws {
        let Attacker = Warrior(name: "Ganon")
        let initialHealth = Attacker.health
        Attacker.attack(target: Attacker)
        XCTAssertNotEqual(Attacker.health, initialHealth)
    }
    
    func testWarriorOnlyHealHimself(){
        let Healer = Warrior(name: "Ganon")
        let Receiver = Warrior(name: "Link")
        Receiver.health = 50
        Healer.heal(target: Receiver)
        XCTAssertEqual(Receiver.health, 50)
    }
    
    func testPriestCantAttack(){
        let Attacker = Priest(name: "Zelda")
        let Receiver = Warrior(name: "Ganon")
        Attacker.attack(target: Receiver)
        XCTAssertEqual(Receiver.health, 100)
    }
    
    func testFactionName() throws {
            let faction:Character = Character(name: "Hyrule")
            let Name = "Hyrule"
            XCTAssertEqual(faction.name, Name)
        }
    
    func testAttackSameFaction() throws {
        let Attacker = Warrior(name: "Ganon")
        let Receiver = Warrior(name: "Link")
        let Hyrule = Faction(name: "Hyrule")
        Attacker.joinFaction(faction: Hyrule)
        Receiver.joinFaction(faction: Hyrule)
        let initialHealth = Receiver.health
        Attacker.attack(target: Receiver)
        XCTAssertEqual(Receiver.health, initialHealth)
    }
    
    func testHealOtherFaction() throws {
        let Healer = Priest(name: "Zelda")
        let Receiver = Warrior(name: "Samus")
        let Hyrule = Faction(name: "Hyrule")
        let Zebes = Faction(name: "Zebes")
        Healer.joinFaction(faction: Hyrule)
        Receiver.joinFaction(faction: Zebes)
        Receiver.health = 50
        Healer.heal(target: Receiver)
        XCTAssertEqual(Receiver.health, 50)
    }
    
    func testEntity() throws {
        let entityName = Entity(name: "Metroid")
        let Name = "Metroid"
        XCTAssertEqual(entityName.name, Name)
    }
    
    func testAttackEntity() throws {
        let Metroid = Entity(name: "Metroid")
        let Attacker = Warrior(name: "Samus")
        Attacker.attackEntity(target: Metroid)
        XCTAssertNotEqual(Metroid.health, 100)
    }
    
    func testAddAlly() throws {
        let Hyrule = Faction(name: "Hyrule")
        let Zebes = Faction(name: "Zebes")
        Hyrule.addAlly(ally: Zebes)
        let ally = Hyrule.allyArray.contains(Zebes)
        XCTAssertTrue(ally)
    }
    
    func testRemoveAlly() throws {
        let Hyrule = Faction(name: "Hyrule")
        let Zebes = Faction(name: "Zebes")
        Hyrule.addAlly(ally: Zebes)
        Zebes.removeAlly(ally: Hyrule)
        let ally = Hyrule.allyArray.contains(Zebes)
        XCTAssertFalse(ally)
    }
    
    func testAddMultipleFactions() throws {
        let Pikachu = Warrior(name: "Pikachu")
        let Kanto = Faction(name: "Kanto")
        let Johto = Faction(name: "Johto")
        Pikachu.joinFaction(faction: Kanto)
        Pikachu.joinFaction(faction: Johto)
        let number = Pikachu.factions.count
        XCTAssertEqual(number, 2)
    }
    
    func testAssemblyName() throws {
        let assemblyName = Assembly(name: "Nintendo")
        let Name = "Nintendo"
        XCTAssertEqual(assemblyName.name, Name)
    }
    
    func testAssemblyRole() throws {
        let Hyrule = Assembly(name: "Hyrule")
        Hyrule.addRole(role: "Warrior")
        let Zelda = Priest(name: "Zelda")
        let Ganon = Warrior(name: "Ganon")
        Ganon.joinAssembly(assembly: Hyrule)
        Zelda.joinAssembly(assembly: Hyrule)
        XCTAssertTrue(Ganon.assembly == Hyrule && Zelda.assembly != Hyrule)
    }
    
    func testLeaveAssembly() throws {
        let Hyrule = Assembly(name: "Hyrule")
        let Gerudo = Assembly(name: "Gerudo")
        Hyrule.addRole(role: "Warrior")
        let Link = Warrior(name: "Link")
        Link.joinAssembly(assembly: Hyrule)
        Link.joinAssembly(assembly: Gerudo)
        XCTAssertTrue(Link.assembly == Hyrule && Link.assembly != Gerudo)
    }
    
    func testAssemblyMaster() throws {
        let Hyrule = Assembly(name: "Hyrule")
        Hyrule.addRole(role: "Warrior")
        let Link = Warrior(name: "Link")
        let Ganon = Warrior(name: "Ganon")
        Link.joinAssembly(assembly: Hyrule)
        Ganon.joinAssembly(assembly: Hyrule)
        XCTAssertTrue(Hyrule.master == Link && Hyrule.master != Ganon)
    }
    
    func testRenameAssembly() throws {
        let assembly = Assembly(name: "Nintendo")
        assembly.addRole(role: "Warrior")
        let Pikachu = Warrior(name: "Pikachu")
        let Mario = Warrior(name: "Mario")
        Pikachu.joinAssembly(assembly: assembly)
        Mario.joinAssembly(assembly: assembly)
        Pikachu.renameAssembly(name: "Kanto")
        Mario.renameAssembly(name: "Mushroom Kingdom")
        XCTAssertTrue(assembly.name == "Kanto")
    }
    
    func testNewAssemblyMaster() throws {
        let assembly = Assembly(name: "Nintendo")
        let Mario = Warrior(name: "Mario")
        let Pikachu = Warrior(name: "Pikachu")
        let Link = Warrior(name: "Link")
        let Samus = Warrior(name: "Samus")
        assembly.addRole(role: "Warrior")
        Mario.joinAssembly(assembly: assembly)
        Pikachu.joinAssembly(assembly: assembly)
        Link.joinAssembly(assembly: assembly)
        Samus.joinAssembly(assembly: assembly)
        Mario.leaveAssembly()
        var master = assembly.master
        XCTAssertTrue(master == Pikachu || master == Link || master == Samus)
        Pikachu.leaveAssembly()
        master = assembly.master
        XCTAssertTrue(master == Link || master == Samus)
    }

}
