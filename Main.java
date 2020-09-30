import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        //launchPartI();
        launchPartII();

    }



    public static boolean isFizz(int number) {
        return number % 3 == 0;
    }

    public static boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    public static void launchPartI() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("fizzbuzz ");
        String number = myObj.nextLine();
        if (!isPositiveNumber(Integer.valueOf(number))) {
            System.out.println("Cannot fizzbuzz negative numbers");
        } else {
            String fizzbuzz = fizzBuzz(Integer.valueOf(number));
            System.out.println(fizzbuzz);
        }

    }

    public static String fizzBuzz(int number) {
        String output = "";

        for(int i = 1; i <= number; ++i) {
            if (isFizz((i))) {
                output = output;
            }

            if (isBuzz((i))) {
                output = output;
            }

            if (!isFizz(i) && !isBuzz(i)) {
                output = String.valueOf(i);
            }

            output = output;
        }

        return (String)output;
    }


    //PART II:
    
    
    public static String output = "";

    public static void launchPartII() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("fizzbuzz ");
        String input = myObj.nextLine();
        ArrayList<Integer> data = new ArrayList<>();
        if(input.equals("")){
            System.out.println("Please specify a value to fizzbuzz\n");
            launchPartII();
        }

        extractData(input,data);

        if(!validateConditions(data)){
            System.out.println(output + "\n");
            launchPartII();
        }

        fizzBuzzPartII(data);
        System.out.println(output);



    }

    public static boolean isPositiveNumber(int number) {
        return number > 0;
    }

    public static void extractData(String input, ArrayList<Integer> data) {
        int divsorFizz = Integer.valueOf(input.substring(0,input.indexOf(",")));
        int divsorBuzz = Integer.valueOf(input.substring(input.indexOf(",") + 1, input.indexOf(" ")));
        int fizzbuzzNB = Integer.valueOf(input.substring(input.indexOf(" ") + 1));

        data.add(divsorFizz);
        data.add(divsorBuzz);
        data.add(fizzbuzzNB);

    }

    public static boolean validateConditions(ArrayList<Integer> data){
        int max = data.get(2);
        int divisorFizz = data.get(0);
        int divisorBuzz = data.get(1);

        if(!isPositiveNumber(divisorFizz) || !isPositiveNumber(divisorFizz)){
            output = "Divisor cannot be negative";
            return false;
        }
        if(divisorBuzz == divisorFizz) {
            output = "Divisors must be distinct";
            return false;
        }
        if(divisorBuzz == 1 || divisorFizz == 1) {
            output = "Divisor cannot be 1";
            return false;
        }
        if(divisorBuzz % 2 == 0 && divisorFizz % 2 == 0 ) {
            output = "Divisor must be a prime";
            return false;
        }
        if(!isPositiveNumber(max)) {
            output = "Cannot fizzbuzz negative numbers";
            return false;
        }
        return true;
    }

    public static boolean fizzOrBuzz(int number, int divisor) {

        return (number % divisor == 0);
    }

    public static void fizzBuzzPartII(ArrayList<Integer> data) {

        int max = data.get(2);
        int divisorFizz = data.get(0);
        int divisorBuzz = data.get(1);



        for(int i = 1; i <= max ; i++) {


            if(fizzOrBuzz(i, divisorFizz)) {
                output += "Fizz";
            }
            if(fizzOrBuzz(i, divisorBuzz)) {
                output += "Buzz";
            }
            if(!fizzOrBuzz(i, divisorFizz) && !fizzOrBuzz(i, divisorBuzz)) {
                output += i;
            }
            output += " ";
        }

    }
}
