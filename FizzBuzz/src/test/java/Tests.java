import org.junit.Test;

public class Tests {
    @Test
    public void create(){
        FizzBuzz fizzBuzz = new FizzBuzz(1);
        assert(fizzBuzz.getNumber() == 1);
    }

    @Test
    public void fizzBuzz2(){
        FizzBuzz fizzBuzz = new FizzBuzz(2);
        assert(fizzBuzz.toString().equals("1 2"));
    }

    @Test
    public void fizzBuzz3(){
        FizzBuzz fizzBuzz = new FizzBuzz(3);
        assert(fizzBuzz.toString().equals("1 2 Fizz"));
    }

    @Test
    public void fizzBuzz5(){
        FizzBuzz fizzBuzz = new FizzBuzz(5);
        assert(fizzBuzz.toString().equals("1 2 Fizz 4 Buzz"));
    }

    @Test
    public void fizzBuzz15(){
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        assert(fizzBuzz.toString().equals("1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz"));
    }

}
