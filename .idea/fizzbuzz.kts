fun divisible(numerator : Int, denominator : Int) : Boolean {
    return numerator % denominator == 0
}

fun fizzbuzz(numberMax : Int) {
    var fizzbuzzString = ""

    for (number in 1..numberMax) {
        if (divisible(number, 3)) {
            fizzbuzz += "fizz"
        } else if (divisible(number, 5)) {
            fizzbuzz += "buzz"
        } else {
            fizzbuzz += getString(number)
        }
        fizzbuzz += " "
    }
    println(fizzbuzzString)
}
