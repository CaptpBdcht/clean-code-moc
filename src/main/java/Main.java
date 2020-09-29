import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String arguments = "";
        System.out.println("fizzbuzz");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            arguments = reader.readLine();
        } catch(IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        if (arguments.length() == 0){
            System.out.println("Please specify a value to fizzbuzz");
        } else if (arguments.contains(",")){
            String[] inputs = arguments.split(",");
            String[] inputs2 = inputs[1].split(" ");

            int fizz = Integer.parseInt(inputs[0]);
            int buzz = Integer.parseInt(inputs2[0]);
            int max = Integer.parseInt(inputs2[1]);

            if(fizz == 1 || buzz == 1){
                System.out.println("Divisor cannot be 1");
            } else if (fizz < 0 || buzz < 0){
                System.out.println("Divisor cannot be negative");
            }else if (fizz == buzz ){
                System.out.println("Divisors must be distinct");
            } else {
                System.out.println(dynamicFizzbuzz(fizz, buzz, max));
            }

        } else {
            System.out.println(dynamicFizzbuzz(3, 5, Integer.parseInt(arguments)));
        }
    }

    public static String dynamicFizzbuzz(int fizz, int buzz, int max){
        int i = 1;
        String result = "";
        while(i <= max){
            if(i%fizz == 0){
                result += "Fizz";
            }
            if (i%buzz == 0){
                result += "Buzz";
            }
            if(i%fizz != 0 && i%buzz != 0){
                result += i ;
            }

            result += " ";
            i++;
        }
        return result;
    }

}
