// Pour executer le projet : lancer la commande "java src/Main.java fizzbuzz 'int'" depuis la racine du projet

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] argv) {
        List<String> arguments = Arrays.asList(argv);
        if (arguments.get(0).equals("fizzbuzz")) {
            try {
                if (arguments.size() == 2) {
                    int number = Integer.parseInt(arguments.get(1));
                    System.out.println(generateFizz(number, 3, 5));
                    return;
                }
                else if (arguments.size() == 3) {
                    String extractNumber[] = arguments.get(1).split(",");
                    int fizzNumber = Integer.parseInt(extractNumber[0]);
                    int buzzNumber = Integer.parseInt(extractNumber[1]);
                    int number = Integer.parseInt(arguments.get(2));

                    if (fizzNumber == 1 || buzzNumber == 1) {
                        System.out.println("Divisor cannot be 1");
                        return;
                    }
                    if (fizzNumber < 0 || buzzNumber < 0) {
                        System.out.println("Divisor cannot be negative");
                        return;
                    }

                    if (fizzNumber == buzzNumber) {
                        System.out.println("Divisors must be distinct");
                        return;
                    }
                    System.out.println(generateFizz(number, fizzNumber, buzzNumber));
                    return;
                }

            }
            catch (Exception e) {
                throw new IllegalArgumentException("Please specify a value to fizzbuzz");
            }
        }

    }

    private static String generateFizz(int number, int fizzNumber, int buzzNumber) {
        if (number < 0) {
            return "Cannot fizzbuzz negative numbers";
        }
        StringBuilder result = new StringBuilder();
        for (int counter = 1; counter <= number; counter++) {
            if (counter % fizzNumber == 0 && counter % buzzNumber == 0) {
                result.append("FizzBuzz ");
                break;
            }
            if (counter % fizzNumber == 0) {
                result.append("Fizz ");
            }
            else if (counter % buzzNumber == 0) {
                result.append("Buzz ");
            }
            else {
                result.append(counter + " ");
            }

        }
        return result.toString();
    }
}
