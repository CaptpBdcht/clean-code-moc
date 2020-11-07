//
//  Assembly.swift
//  KataRPG
//
//  Created by Cindy Nguyen on 07/11/2020.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

public class Assembly: NSObject {
    var allowedRoles:[Class] = []
    var name:String

    init(name:String) {
        self.name = name
    }

    func addAllowedRoles(classAllowed: Class) {
        self.allowedRoles.append(classAllowed)
    }
}
