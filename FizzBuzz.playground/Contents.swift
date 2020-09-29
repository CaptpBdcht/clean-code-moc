import UIKit


let number = readLine()
print("redaline => \(number)")

FizzBuzzGame(fizzBuzzNumber:45)




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
