import UIKit


func FizzBuzz(limit:Int)->String{
    var result : String = ""
    if(!CheckNegativeLimit(limit: limit)){
        result="Cannot fizzbuzz negative numbers"
    }else{
        for i in 1...limit{
            if i%3==0 || i%5==0 {
                if i%3==0 {
                    result+="Fizz"
                }
                if i%5==0{
                    result+="Buzz"
                }
            }else{
                result+="\(i)"
            }
            result+=" "
        }
    }
    
    return result;
}

func FizzBuzzWithSpecificFizzAndBuzz(fizz:Int,buzz:Int,limit:Int)->String{
    var result : String = ""
    if(CheckNegativeLimit(limit: limit)){
        result="Cannot fizzbuzz negative numbers"
    }else if(!CheckDifferentFizzBuzz(fizz: fizz, buzz: buzz)){
        result="Divisors must be distinct"
    }else if(!CheckPrime(fizz: fizz, buzz: buzz)){
        result="Divisor must be a prime"
    }else if(CheckNegativeFizzBuzz(fizz: fizz, buzz: buzz)){
        result="Divisor cannot be negative"
    }else if(true){
        
    }
        
    else{
        for i in 1...limit{
            if i%3==0 || i%5==0 {
                if i%3==0 {
                    result+="Fizz"
                }
                if i%5==0{
                    result+="Buzz"
                }
            }else{
                result+="\(i)"
            }
            result+=" "
        }
    }
    return result;
}

func CheckNegativeLimit(limit:Int)->Bool{
    return limit<=0 ? true : false
}
func CheckDifferentFizzBuzz(fizz:Int,buzz:Int)->Bool{
    return fizz==buzz ? false : true
}
func CheckPrime(fizz: Int,buzz:Int) -> Bool {
    return (fizz > 1 && !(2..<fizz).contains { fizz % $0 == 0 }) && (buzz > 1 && !(2..<buzz).contains { buzz % $0 == 0 })
}
func CheckNegativeFizzBuzz(fizz:Int,buzz:Int)->Bool{
    return fizz<=0 || buzz<=0 ? true : false
}
func CheckNegativeLimit(fizz:Int,buzz:Int,limit:Int)->Bool{
    if(fizz<1 || buzz>100){
        return false
    }
    if(limit==1){
        return false
    }
    return true
}

print(FizzBuzz(limit: -1))
print(FizzBuzz(limit: 15))
print(FizzBuzzWithSpecificFizzAndBuzz(fizz: 3, buzz: 5, limit: 15))


