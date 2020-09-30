//
//  main.swift
//  RangeSwift
//
//  Created by Moussa Oudjama on 9/30/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation


let rangeTest = Range(stringInterval: "[1,3]")
let isContainValue = rangeTest.contains(value: 1)
print("isContainValue -> \(isContainValue)")

let rangeTest2 = Range(stringInterval: "[1,3]")
let isContainValue2 = rangeTest2.contains(value: 3)
print("isContainValue -> \(isContainValue2)")

let rangeTest3 = Range(stringInterval: "[1,3]")
let rangeSize3 = rangeTest3.size()
print("rangeTest size is 3 -> \(rangeSize3)")

let rangeTest4 = Range(stringInterval: "[1,8]")
let rangeSize4 = rangeTest4.size()
print("rangeTest size is 8 -> \(rangeSize4)")



