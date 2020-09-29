

function FizzBuzzTool(valueForFizz:number, valueForBuzz: number, value: number){
    if(checkErrorValue(value)) return;
    if(checkErrorRules(valueForBuzz, valueForFizz, value)) return;
    var contentToPrint: String = getContentToPrint(valueForFizz, valueForBuzz, value);
    console.log(contentToPrint);
}

function checkErrorValue(value: number){
    if(!value){
        printError("Please specify a value to fizzbuzz");
        return true;
    }else if(value <= 0){
        printError("Cannot fizzbuzz negative numbers");
        return true;
    }
    else return false;
}

function checkErrorRules(divisor1: number, divisor2: number, value: number){
    if(divisor1 === divisor2){
        printError("Divisors must be distinct");
        return true;
    }else if(divisor1 <= 0 || divisor2 <= 0){
        printError("Divisor cannot be negative");
        return true;
    }else if(divisor2>value || divisor1>value){
        printError("Divisor must be a prime");
        return true;
    }
    else return false;
}

function getContentToPrint(divisor1: number, divisor2: number, value : number){
    var content: String = "";
    for(let currentValue = 1; currentValue <= value; currentValue++){
        content = content + contentToPrintForNumber(divisor1, divisor2, currentValue) + " ";
    }
    return content;
}

function contentToPrintForNumber(divisor1: number, divisor2: number, value: number){
    if(value%divisor1 === 0) return "Fizz";
    else if(value%divisor2 === 0) return "Buzz";
    else return value.toString();
}

function printError(errorMessage: String){
    console.log(errorMessage);
}

console.log("fizzbuzz 3,5 -5 (should error) : ");
FizzBuzzTool(3, 5, -5);
console.log("fizzbuzz -3,5 5 (should error) : ");
FizzBuzzTool(-3, 5, 5);
console.log("fizzbuzz 3,5 5 (should: 1 2 Fizz 4 Buzz) : ");
FizzBuzzTool(3, 5, 5);
console.log("fizzbuzz 4,6 15 (should: 1 2 3 Fizz 5 Buzz 7 Fizz 9 10 11 Fizz 13 14 15 ) : ");
FizzBuzzTool(4, 6, 15);
