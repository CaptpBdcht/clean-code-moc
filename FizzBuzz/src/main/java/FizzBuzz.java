import java.util.Arrays;
import java.util.OptionalInt;

class FizzBuzzError extends Exception {
    FizzBuzzError(String message){
        super(message);
    }
}

public class FizzBuzz {
    private int max;
    private int fizzDivisor;
    private int buzzDivisor;

    private int[] primeNumbers = {
        2, 3, 5, 7, 11,
        13, 17, 19, 23, 29,
        31, 37, 41, 43, 47,
        53, 59, 61, 67, 71,
        73, 79, 83, 89, 97
    };

    FizzBuzz(int max) throws FizzBuzzError {
        // By default fizzDivisor = 3 && buzzDivisor = 5
        this.handleRangeError(max);
        this.max = max;
        this.fizzDivisor = 3;
        this.buzzDivisor = 5;
    }

    FizzBuzz(int fizz, int buzz, int max) throws FizzBuzzError {
        this.handleRangeError(max);
        handleDivisorErrors(fizz, buzz);
        this.max = max;
        this.fizzDivisor = fizz;
        this.buzzDivisor = buzz;
    }

    public int getMax() {
        return max;
    }

    private void handleRangeError(int max) throws FizzBuzzError {
        if(max < 0)
            throw new FizzBuzzError("Cannot fizzbuzz negative numbers");
    }

    private void handleDivisorErrors(int fizz, int buzz) throws FizzBuzzError {
        if(fizz == 1 || buzz == 1)
            throw new FizzBuzzError("Divisor cannot be 1");

        if(fizz < 0 || buzz < 0)
            throw new FizzBuzzError("Divisor cannot be negative");

        if(fizz == buzz)
            throw new FizzBuzzError("Divisors must be distinct");

        if(!isPrimeNumber(fizz) || !isPrimeNumber(buzz))
            throw new FizzBuzzError("Divisor must be a prime");
    }

    private boolean isPrimeNumber(int number){
        OptionalInt foundPrime = Arrays.stream(primeNumbers).filter(prime -> prime == number).findFirst();
        return foundPrime.isPresent();
    }

    private StringBuilder buildFizzBuzz(){
        StringBuilder fizzBuzz = new StringBuilder();
        char separator = ' ';

        for(int index = 1; index <= max; index++){
            boolean printSeparator = index != max;

            if(isMultiple(index, fizzDivisor))
                fizzBuzz.append("Fizz");

            if(isMultiple(index, buzzDivisor))
                fizzBuzz.append("Buzz");

            if(!isMultiple(index, fizzDivisor) && !isMultiple(index, buzzDivisor))
                fizzBuzz.append(index);

            if(printSeparator)
                fizzBuzz.append(separator);
        }
        return fizzBuzz;
    }

    private boolean isMultiple(int number, int divisor){
        return number % divisor == 0;
    }

    @Override
    public String toString() {
        return buildFizzBuzz().toString();
    }
}
