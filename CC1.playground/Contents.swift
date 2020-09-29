import Cocoa

func isPrime(number: Int) -> Bool {
    return number > 1 && !(2..<number).contains { number % $0 == 0 }
}

func verifyFizzBuzzDivisors(divisors: [Int]) -> String {
    for divisor in divisors {
        if (divisor < 0) {
            return "Divisor cannot be negative"
        }
        
        if (divisor == 1) {
            return "Divisor cannot be 1"
        }
        
        if !isPrime(number: divisor) {
            return "Divisor must be a prime"
        }
    }
    if (divisors[0] == divisors[1]) {
        return "Divisors must be distinct"
    }
    
    return ""
}

func staticFizzbuzz (range: Int) -> String {
    if (range < 0) {
        return "Cannot fizzbuzz negative numbers"
    }
    var result = ""
    for i in 1...range {
        if (i % 3 == 0 && i % 5 == 0 ) {
            result += "FizzBuzz "
        } else if (i % 3 == 0) {
            result += "Fizz "
        } else if (i % 5 == 0) {
            result += "Buzz "
        } else {
            result += "\(i) "
        }
    }
    return result
}

func dynamicFizzbuzz (divisors: [Int], range: Int) -> String {
    if (range < 0) {
        return "Cannot fizzbuzz negative numbers"
    }
    var result = verifyFizzBuzzDivisors(divisors: divisors)
    
    if (result == "") {
        for i in 1...range {
            if (i % divisors[0] == 0 && i % divisors[1] == 0 ) {
                result += "FizzBuzz "
            } else if (i % divisors[0] == 0) {
                result += "Fizz "
            } else if (i % divisors[1] == 0) {
                result += "Buzz "
            } else {
                result += "\(i) "
            }
        }
    }
    return result
}


print("'\(staticFizzbuzz(range: 3))' should be '1 2 Fizz'")
print("'\(staticFizzbuzz(range: 15))' should be '1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz'")
print("'\(staticFizzbuzz(range: -42))' should be 'Cannot fizzbuzz negative numbers'")
print("'\(dynamicFizzbuzz(divisors: [2,5], range: 3))' should be '1 Fizz 3'")
print("'\(dynamicFizzbuzz(divisors: [5,2], range: 3))' should be '1 Buzz 3'")
print("'\(dynamicFizzbuzz(divisors: [3,7], range: 15))' should be '1 2 Fizz 4 5 Fizz Buzz 8 Fizz 10 11 Fizz 13 Buzz Fizz'")
print("'\(dynamicFizzbuzz(divisors: [1,2], range: 3))' should be 'Divisor cannot be 1'")
print("'\(dynamicFizzbuzz(divisors: [-2,5], range: 3))' should be 'Divisor cannot be negative'")
print("'\(dynamicFizzbuzz(divisors: [2,4], range: 3))' should be 'Divisor must be a prime'")
print("'\(dynamicFizzbuzz(divisors: [2,2], range: 3))' should be 'Divisors must be distinct'")

