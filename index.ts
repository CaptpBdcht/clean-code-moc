var stdin = process.openStdin();

interface FizzBuzzValues{
    fizz?: number
    buzz?: number
    value?: number
}

console.log('Specify a value to fizz: ');
stdin.addListener("data", function(inputValues) {
    let inputValuesString = inputValues.toString();
    let fizzBuzzValues = extractValuesFromInput(inputValuesString);
    if(!checkData(fizzBuzzValues)){
        return;
    } else {
        console.log(startFizzbuzz(fizzBuzzValues));
    }
});

function checkData(values: FizzBuzzValues): Boolean{
    if(values.fizz == 1 || values.buzz == 1){
        console.log("Divisor cannot be 1");
        return false;
    } else if (values.fizz < 0 || values.buzz < 0){
        console.log("Divisor cannot be negative");
        return false;
    } else if (values.fizz == values.buzz){
        console.log("Divisor must be distinct");
        return false;
    } else {
        return true;
    }
}

function extractValuesFromInput(inputData: String): FizzBuzzValues{
    let fizzBuzzValues: FizzBuzzValues = {};
    if(inputData.indexOf(',') !== -1){
        let fizz = Number(inputData[inputData.indexOf(',') - 1]);
        let buzz = Number(inputData[inputData.indexOf(',') + 1]);
        let value = Number(inputData[inputData.indexOf(' ') + 1]);

        fizzBuzzValues.fizz = fizz;
        fizzBuzzValues.buzz = buzz;
        fizzBuzzValues.value = value;
    }
    return fizzBuzzValues;
}

function startFizzbuzz(data: FizzBuzzValues): String {
    let resultString: String = "";
    for(let i: number = 1; i <= data.value; i++){
        if(i % data.fizz == 0){
            resultString += " fizz";
        } else if (i % data.buzz == 0){
            resultString += " buzz";
        } else {
            resultString += " " + i.toString();
        }
    }
    return resultString;
}