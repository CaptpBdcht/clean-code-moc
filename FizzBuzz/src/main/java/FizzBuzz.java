public class FizzBuzz {
    private int number;

    FizzBuzz(int number)  {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return generateFizzBuzz();
    }

    private String generateFizzBuzz(){
        String result = "";
        char separator = ' ';

        for(int index = 1; index <= number; index++){
            boolean isMultipleOf3 = index % 3 == 0;
            boolean isMultipleOf5 = index % 5 == 0;
            boolean displayNumber = !isMultipleOf3 && !isMultipleOf5;
            boolean showSeparator = index != number;

            if(isMultipleOf3)
                result += "Fizz";

            if(isMultipleOf5)
                result += "Buzz";

            if(displayNumber)
                result += index;

            if(showSeparator){
                result += separator;
            }
        }
        return result;
    }
}
