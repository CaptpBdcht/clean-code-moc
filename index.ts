var stdin = process.openStdin();

function fizzbuzz(value: number): String {
    let resultString: String = "";
    for(let i: number = 1; i <= value; i++){
        if(i % 3 == 0){
            resultString += " fizz";
        } else if (i % 5 == 0){
            resultString += " buzz";
        } else {
            resultString += " " + i.toString();
        }
    }
    return resultString;
}

function startFizzbuzz(value: number){
    if(value < 0){
        console.log("Cannot fizzbuzz negative numbers");
    } else {
        console.log(fizzbuzz(value));
    }
}

console.log('Specify a value to fizz: ');
stdin.addListener("data", function(inputValue) {
    startFizzbuzz(inputValue);
});