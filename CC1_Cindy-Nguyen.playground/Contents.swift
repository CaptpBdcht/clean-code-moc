import UIKit

var inputNumber : Int?


func isPrime(_ number: Int) -> Bool {
    return number > 1 && !(2..<number).contains { number % $0 == 0 }
}

func fizzbuzz(firstPrimeNumber: Int, secondPrimeNumber: Int, inputNumber : Int?) -> String{
    var i: Int = 1
    var result: String = ""
    
    if(isPrime(firstPrimeNumber) && isPrime(secondPrimeNumber)){
        while(i <= inputNumber!) {
            switch i {
            case let inputNumber where inputNumber % firstPrimeNumber == 0 && secondPrimeNumber % 5 == 0:
                result.append("FizzBuzz")
            case let inputNumber where inputNumber % firstPrimeNumber == 0:
                result.append("Fizz")
            case let inputNumber where inputNumber % secondPrimeNumber == 0:
                result.append("Buzz")
            default:
                result.append("\(i)")
            }
            result.append(" ")
            i += 1
        }
    }
    
    if (inputNumber! <= 0) {
        result = "Cannot fizzbuzz negative numbers"
        return result
    }
    
    if (inputNumber == 0 || inputNumber == nil) {
        result = "Please specify a value to fizzbuzz"
        return result
    }
    
    print(result)
    return result
}

fizzbuzz(firstPrimeNumber: 3, secondPrimeNumber: 7, inputNumber: 15)
