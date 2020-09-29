

function FizzBuzzTool(value: number){
    if(!value){
        printError("Please specify a value to fizzbuzz");
        return;
    }else if(value <= 0){
        printError("Cannot fizzbuzz negative numbers");
        return;
    }
    var contentToPrint: String = getContentToPrint(value);
    console.log(contentToPrint);
}

function getContentToPrint(value : number){
    var content: String = "";
    for(let currentValue = 1; currentValue <= value; currentValue++){
        content = content + contentToPrintForNumber(currentValue) + " ";
    }
    return content;
}

function contentToPrintForNumber(value: number){
    if(value%3 === 0) return "Fizz";
    else if(value%5 === 0) return "Buzz";
    else return value.toString();
}

function printError(errorMessage: String){
    console.log(errorMessage);
}

console.log("fizzbuzz -5 (should error) : ");
FizzBuzzTool(-5);
console.log("fizzbuzz 5 (should: 1 2 Fizz 4 Buzz) : ");
FizzBuzzTool(5);
console.log("fizzbuzz 15 (should: 1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 Fizz) : ");
FizzBuzzTool(15);
