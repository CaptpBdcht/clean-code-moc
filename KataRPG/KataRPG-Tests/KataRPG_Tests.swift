//
//  KataRPG_Tests.swift
//  KataRPG-Tests
//
//  Created by Moussa Oudjama on 10/18/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import XCTest

class KataRPG_Tests: XCTestCase {
    
    override func setUpWithError() throws {
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }

    
    func testCharacterShouldHaveAName() throws {
        let characterToTest:CharacterRPG = CharacterRPG(name: "John")
        let expectName = "John"
        XCTAssertEqual(characterToTest.name, expectName)
    }
    
    func testCharacterHealthCannotGoAboveOneHundred() throws {
        let characterToTest:CharacterRPG = CharacterRPG(name: "John")
        characterToTest.health += 1
        XCTAssertEqual(characterToTest.health, 100)
    }
    
    func testCharacterShouldBeDead() throws {
          let characterToTest:CharacterRPG = CharacterRPG(name: "John")
          characterToTest.health -= 100
          XCTAssertFalse(characterToTest.alive)
      }
    
    func testCharacterHealthCannotGoUnderZeroAndHisStatusIsDead() throws {
        let characterToTest:CharacterRPG = CharacterRPG(name: "John")
        characterToTest.health -= 101
        XCTAssertEqual(characterToTest.health, 0)
        XCTAssertFalse(characterToTest.alive)
        
    }
    
    
    func testCharacterShouldAttackOtherCharacters() throws {
        let characterToTest:CharacterRPG = CharacterRPG(name: "John")
        let receiverDamageCharacter:CharacterRPG = CharacterRPG(name: "Doe")
        let receiverCharacterInitialHealth = receiverDamageCharacter.health
        characterToTest.attack(ennemyCharacter: receiverDamageCharacter)
        XCTAssertNotEqual(receiverDamageCharacter.health, receiverCharacterInitialHealth)
    }
    
    func testCharacterShouldHealOtherCharacters() throws {
        let characterToTest:CharacterRPG = CharacterRPG(name: "John")
        let receiverHealCharacter:CharacterRPG = CharacterRPG(name: "Doe")
        receiverHealCharacter.health -= 5
        let receiverCharacterInitialHealth = receiverHealCharacter.health
        characterToTest.heal(allyCharacter: receiverHealCharacter)
        XCTAssertNotEqual(receiverHealCharacter.health, receiverCharacterInitialHealth)
    }
    
    func testCharacterAttackEntity() throws {
        let characterToTest:CharacterRPG = CharacterRPG(name: "John")
        let animalEntityToTest:AnimalEntity = AnimalEntity(name: "Wolf", health: 200)
        let initialAnimalHealth = animalEntityToTest.health
        characterToTest.attack(entity: animalEntityToTest)
        XCTAssertNotEqual(animalEntityToTest.health, initialAnimalHealth)
    }
    
    func testFactionShouldBeCreated() throws {
        let factionToBeTested = Faction(name: "Zevent")
        let expectedFactionName = "Zevent"
        XCTAssertEqual(factionToBeTested.name, expectedFactionName)
    }
    
    
    
    func testAllyFactionShouldBeAdded() throws {
        let factionToBeTested = Faction(name: "Zevent")
        let allyFaction = Faction(name: "Amnesty")
        factionToBeTested.addAlly(allyFaction: allyFaction)
        
        var allyFactionListExpected:[Faction] = []
        allyFactionListExpected.append(allyFaction)
    
        
        XCTAssertEqual(factionToBeTested.alliesFactions, allyFactionListExpected)
    }
    
    func testFactionCantAddItselfAsAlly() throws {
        let factionToBeTested = Faction(name: "Zevent")
        factionToBeTested.addAlly(allyFaction: factionToBeTested)
        XCTAssertTrue(factionToBeTested.alliesFactions.isEmpty)
    }
    
    
    func testWarriorShouldAttackEnnemies() throws {
        
        let firstFactionTest = Faction(name: "Zevent")
        let secondFactionTest = Faction(name: "Amnesty")
        
        let warriorTest = Warrior(name: "Marc")
        let warriorEnnemyTest = Warrior(name: "Dylan")
        
        let warriorEnnemyWithFactionTest = Warrior(name: "DylanAvecDesPotes")
        warriorEnnemyWithFactionTest.joinFaction(faction: firstFactionTest)
        
        let secondWarriorEnnemyWithFactionTest = Warrior(name: "Jean")
        secondWarriorEnnemyWithFactionTest.joinFaction(faction: secondFactionTest)
        
        let warriorEnnemyInitialHealth = warriorEnnemyTest.health
        let firstWarriorEnnemyWithFactionInitialHealth = warriorEnnemyWithFactionTest.health
        let secondWarriorEnnemyWithFactionInitialHealth = secondWarriorEnnemyWithFactionTest.health
        
        warriorTest.attack(ennemyCharacter: warriorEnnemyTest)
        warriorTest.attack(ennemyCharacter: warriorEnnemyWithFactionTest)
        warriorEnnemyWithFactionTest.attack(ennemyCharacter: secondWarriorEnnemyWithFactionTest)
        
        
        XCTAssertNotEqual(warriorEnnemyTest.health, warriorEnnemyInitialHealth)
        XCTAssertNotEqual(warriorEnnemyWithFactionTest.health, firstWarriorEnnemyWithFactionInitialHealth)
        XCTAssertNotEqual(secondWarriorEnnemyWithFactionTest.health, secondWarriorEnnemyWithFactionInitialHealth)
    }
    
    func testWarriorShouldNotAttackEnnemies() throws {
        let factionTest = Faction(name: "Zevent")
        let allyFactionTest = Faction(name: "Amnesty")
        let warriorTest = Warrior(name: "Marc")
        let warriorSameFactionTest = Warrior(name: "Dylan")
        let warriorDifferentFactionTest = Warrior(name: "Bob")
        
        factionTest.addAlly(allyFaction: allyFactionTest)
        
        warriorTest.joinFaction(faction: factionTest)
        warriorSameFactionTest.joinFaction(faction: factionTest)
        warriorDifferentFactionTest.joinFaction(faction: allyFactionTest)
        
        factionTest.addAlly(allyFaction: allyFactionTest)
        
        warriorTest.attack(ennemyCharacter: warriorSameFactionTest)
        warriorTest.attack(ennemyCharacter: warriorDifferentFactionTest)
        
        let warriorSameFactionInitialHealth = warriorSameFactionTest.health
        let warriorDifferentInitialHealth = warriorDifferentFactionTest.health
        
        XCTAssertEqual(warriorSameFactionTest.health, warriorSameFactionInitialHealth)
        XCTAssertEqual(warriorDifferentFactionTest.health, warriorDifferentInitialHealth)
    }
}
