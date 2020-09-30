//
//  RangeTest.swift
//  Range
//
//  Created by Norman on 30/09/2020.
//  Copyright © 2020 Norman. All rights reserved.
//

import Foundation




func range_test() {
    
    let range1 = Range(closedInterval1: true, minValue: 5, maxValue: 15, closedInterval2: true)
    
    
    var interval1 :String = "["
    var interval2 :String = "]"

    if range1.closedInterval1 == false{
        interval1 = "("
    }
    
    if range1.closedInterval2 == false{
           interval2 = ")"
       }
    
    
    print("Interval: ",interval1,range1.minValue,",",range1.maxValue,interval2)
    
    print(range1.iscontained(number: 7))
    
    print("Number of Element:", range1.numberOfElement() )
    
    print("Interval: ",interval1,range1.minValue,",",range1.maxValue,interval2)
    
    range1.listOfElement()
    
    let range2 = Range(closedInterval1: true, minValue: 8, maxValue: 13, closedInterval2: true)

    print(range1.containInterval(min: 8, max: 13))
    
    
}



