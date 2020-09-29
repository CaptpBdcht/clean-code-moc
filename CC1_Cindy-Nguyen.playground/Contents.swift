import UIKit

var inputNumber : Int?

func fizzbuzz(inputNumber : Int?) -> String{
    var i: Int = 1
    var result: String = ""
    
    if (inputNumber! < 0) {
        return "Cannot fizzbuzz negative numbers"
    }
    
    if (inputNumber == 0 || inputNumber == nil) {
        return "Please specify a value to fizzbuzz"
    }
    
    while(i <= inputNumber!) {
        switch i {
        case let inputNumber where inputNumber % 3 == 0 && inputNumber % 5 == 0:
            result.append("FizzBuzz")
        case let inputNumber where inputNumber % 3 == 0:
            result.append("Fizz")
        case let inputNumber where inputNumber % 5 == 0:
            result.append("Buzz")
        default:
            result.append("\(i)")
        }
        result.append(" ")
        i += 1
    }
    print(result)
    return result
}

fizzbuzz(inputNumber: 3)
fizzbuzz(inputNumber: 15)
fizzbuzz(inputNumber: 0)
fizzbuzz(inputNumber: -2)
