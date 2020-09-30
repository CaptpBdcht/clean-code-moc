//
//  Range.swift
//  RangeSwift
//
//  Created by Moussa Oudjama on 9/30/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation
public class Range{
    
    private var stringInterval:String?
    
    
    init(stringInterval:String) {
        self.stringInterval = stringInterval
    }
    
    func contains(value:Int) -> Bool {
        
        if self.stringInterval != nil {
            
            let intervalArray = self.stringIntervalToArray()
            if intervalArray.contains("3"){
                return true
            }
        }
        return false
    }
    
    
    func size() -> Int {
        
        var rangeNumber:[String.Element] = []
        
        if self.stringInterval != nil {
            let intervalArray = self.stringIntervalToArray()
            
            intervalArray.forEach() {
                if $0.isNumber {
                    rangeNumber.append($0)
                }
            }
            
        }
        
        print("rangeNumber \(rangeNumber[0]) to \(rangeNumber[1])")
        
        return Int("\(rangeNumber[1])")!
    }
    
    
    private func stringIntervalToArray() -> [String.Element]{
        let string : String = self.stringInterval!
        let characters = Array(string)
        print(characters)
        return characters
        
    }
    
    
    
    
    
    
}



