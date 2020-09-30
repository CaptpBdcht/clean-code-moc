//
//  main.swift
//  CC2
//
//  Created by Thomas MARTIN on 30/09/2020.
//

import Foundation

let range = Range(rangeAsString: "[1, 3]")
let range1 = Range(rangeAsString: "[2, 7)")
let range2 = Range(rangeAsString: "[1, 6]")
let range3 = Range(rangeAsString: "[1, 4]")
let range4 = Range(rangeAsString: "(2, 6]")
let range5 = Range(rangeAsString: "(2, 3)")

print("\(range.contains(value: 2)) should be 'true'")
print("\(range.contains(value: 4)) should be 'false'")
print("\(range1.contains(value: 7)) should be 'false'")
print("\(range.size()) should be '3'")
print("\(range2.size()) should be '6'")
print("\(range1.size()) should be '5'")
print("\(range3.values()) should be '[1, 2, 3, 4]'")
print("\(range4.values()) should be '[3, 4, 5, 6]'")

