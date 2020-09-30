//
//  Range.swift
//  Range
//
//  Created by Norman on 30/09/2020.
//  Copyright © 2020 Norman. All rights reserved.
//

import Foundation

class Range {
    
    
   var closedInterval1: Bool
   var minValue : Int
   var maxValue : Int
   var closedInterval2: Bool
    
   init (closedInterval1: Bool, minValue: Int, maxValue: Int, closedInterval2: Bool)  {
        self.closedInterval1 = closedInterval1
        self.minValue = minValue
        self.maxValue = maxValue
        self.closedInterval2 = closedInterval2
    }
 
    
    func iscontained(number: Int) -> Bool {
        
        if (self.minValue <= number && number <= self.maxValue){
            return true
        }
        return false
    }
    
    
    func numberOfElement() -> Int {
        var number = self.maxValue - self.minValue
        return number
    }
 
    func listOfElement(){
        print("[", terminator:"")
        for minValue in minValue...maxValue {
            
            print(minValue,",", terminator:"")
        
        }
        
        print("]")
    }
    
 
    
    func containInterval(min: Int, max: Int) -> Bool {
        if (self.minValue <= min && max <= self.maxValue){
                   return true
               }
               return false
    
    }
    
    
    
}
