//
//  Assembly.swift
//  KataRPG
//
//  Created by Cindy Nguyen on 07/11/2020.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

public class Assembly: NSObject {
    
    var name: String
    var allowedRoles: [Class] = []
    var memberList: [Characters] = []
    var master:Characters?
    
    init(name: String) { 
        self.name = name
    }
    
    func updateAssemblyName(name: String) {
        self.name = name
    }
    
    private func reassignMaster(_ character: Characters) {
        if !self.memberList.isEmpty {
            let memberCount = self.memberList.count
            var newMasterIndex = 0
            if memberCount > 0 {
                newMasterIndex = Int.random(in: 0..<memberCount)
            }
            self.master = self.memberList[newMasterIndex]
        }else{
            self.master = nil
        }
    }
    
    func deleteMember(character:Characters){
        self.memberList = self.memberList.filter { !($0 === character) }
        if character.isAssemblyMaster(){
            reassignMaster(character)
        }
    }
    
    func addMember(character:Characters){
        if self.allowedRoles.contains(character.classNames){
            if(memberList.isEmpty){
                self.master = character
                self.memberList.append(character)
                character.assembly = self
            }else{
                self.memberList.append(character)
                character.assembly = self
            }
        }
    }
    
    func addAllowedRoles(classAllowed: Class) {
        self.allowedRoles.append(classAllowed)
    }
}
