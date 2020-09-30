
import org.junit.Test;

public class Tests {

    @Test
    public void create() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(1);
        assert(fizzBuzz.getMax() == 1);
    }

    @Test (expected = FizzBuzzError.class)
    public void negativeMax() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(-42);
    }

    @Test
    public void fizzBuzz2() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(2);
        assert(fizzBuzz.toString().equals("1 2"));
    }

    @Test
    public void fizzBuzz3() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(3);
        assert(fizzBuzz.toString().equals("1 2 Fizz"));
    }

    @Test
    public void fizzBuzz5() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz( 5);
        assert(fizzBuzz.toString().equals("1 2 Fizz 4 Buzz"));
    }

    @Test
    public void fizzBuzz15() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        assert(fizzBuzz.toString().equals("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz"));
    }

    @Test
    public void fizzbuzz2_5_3() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(2, 5, 3);
        assert(fizzBuzz.toString().equals("1 Fizz 3"));
    }

    @Test
    public void fizzbuzz5_2_3() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(5, 2, 3);
        assert(fizzBuzz.toString().equals("1 Buzz 3"));
    }

    @Test
    public void fizzbuzz3_7_15() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(3, 7, 15);
        assert(fizzBuzz.toString().equals("1 2 Fizz 4 5 Fizz Buzz 8 Fizz 10 11 Fizz 13 Buzz Fizz"));
    }

    @Test (expected = FizzBuzzError.class)
    public void divisorEqualOne() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(1, 2, 3);
    }

    @Test (expected = FizzBuzzError.class)
    public void negativeDivisor() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(-2, 5, 3);
    }

    @Test (expected = FizzBuzzError.class)
    public void identicalDivisors() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(2, 2, 3);
    }

    @Test (expected = FizzBuzzError.class)
    public void divisorIsPrimeNumber() throws FizzBuzzError {
        FizzBuzz fizzBuzz = new FizzBuzz(2, 4, 3);
    }
}
