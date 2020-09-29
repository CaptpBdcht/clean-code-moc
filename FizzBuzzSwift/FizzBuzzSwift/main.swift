//
//  main.swift
//  FizzBuzzSwift
//
//  Created by Moussa Oudjama on 9/29/20.
//  Copyright © 2020 esgi. All rights reserved.
//

import Foundation

print("should print result with 10 iterator on fizzbuzznumber")
FizzBuzzGame(fizzBuzzNumber:10)


print("Please specify a value to fizzbuzz : ")

let readingNumber = String(readLine()!)




FizzBuzzGame(fizzBuzzNumber:Int(readingNumber)!)



//MARK: Function
func FizzBuzzGame(fizzBuzzNumber:NSInteger){
    
    
    print("Fizzbuzz \(fizzBuzzNumber)")
    
    
    if(fizzBuzzNumber < 0){
        
        print("Cannot fizzbuzz negative numbers")
        
    }else{
        var resultGame:[String] = []
        
        for eachNumberToFizzBuzz in 1...fizzBuzzNumber{
            
            if(eachNumberToFizzBuzz%3==0) && (eachNumberToFizzBuzz%5==0){
                resultGame.append("FizzBuzz")
            }else{
                
                if eachNumberToFizzBuzz % 3 == 0 {
                    resultGame.append("Fizz")
                    
                }else   if eachNumberToFizzBuzz % 5 == 0 {
                    resultGame.append("Buzz")
                }else{
                    resultGame.append(String(eachNumberToFizzBuzz))
                }
            }
            
        }
        
        
        print(resultGame)
    }
    
    
    
    
    
}




