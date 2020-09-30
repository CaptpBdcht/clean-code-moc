//
//  Range.swift
//  CC2
//
//  Created by Thomas MARTIN on 30/09/2020.
//

import Foundation

class Range {
    private var range: [Int] = []
    
    init(rangeAsString: String) {
        var firstBound = 0
        var secondBound = 0
        let rangeAsArray = Array(rangeAsString)
        var boundAsString = ""
        for i in 1...rangeAsArray.count - 1 {
            if (rangeAsArray[i].isNumber) {
                boundAsString.append(rangeAsArray[i])
            } else if (rangeAsArray[i] == ",") {
                firstBound = Int(boundAsString)!
                boundAsString = ""
            }
        }
        secondBound = Int(boundAsString)!
        
        if (rangeAsArray[0] == "(") {
            firstBound += 1
        }
        if (rangeAsArray[rangeAsArray.count - 1] == ")") {
            secondBound -= 1
        }
        for i in firstBound...secondBound {
            range.append(i)
        }
    }
    
    func contains(value: Int) -> Bool {
        return range.contains(value)
    }
    
    func size() -> Int {
        return range.count
    }
    
    func values() -> [Int] {
        return range
    }
    
    func endPoints() -> [Int] {
        return [range.first!, range.last!]
    }
}
