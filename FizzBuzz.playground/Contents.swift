import Cocoa


 var scanNumber = readLine()

if (scanNumber.isNan) {
    print("Please specify a value to fizzbuzz")
}

else  if (scanNumber < 0 ) {
    print("Cannot fizzbuzz negative numbers")
}

else {
    FizzFuzz(number: scanNumber)
}

func FizzFuzz(number: Int){
for i in 1...number
{
    switch (i % 3 == 0, i % 5 == 0)
    {
    case (true, false):
        print("Fizz " , terminator:"")
    case (false, true):
        print("Buzz " , terminator:"")
    case (true, true):
        print("FizzBuzz " , terminator:"")
    default:
        print(i, " " , terminator:"")
    }
}
}
