//
//  Assembly.swift
//  KataRPG
//
//  Created by Cindy Nguyen on 07/11/2020.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

public class Assembly: NSObject {
    var allowedRoles: [Class] = []
    var memberList: [Characters] = []
    var name: String
    lazy var master: Characters? = memberList[0] {
        didSet {
            if (master == nil) {
                master = memberList[Int.random(in: 0...memberList.count)]
            }
        }
    }

    init(name: String) {
        self.name = name
    }
    
    func updateAssemblyName(name: String) {
        if master === self {
            self.name = name
        }
    }
    
    func addAllowedRoles(classAllowed: Class) {
        self.allowedRoles.append(classAllowed)
    }
}
