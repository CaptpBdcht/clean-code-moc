package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.print("Partie 1 :");

        System.out.println("fizzbuzz");
        System.out.println("Please specify a value to fizzbuzz");

        final int valueFizzBuzz = 15;
        System.out.println("fizzbuzz " + valueFizzBuzz);

        if(valueFizzBuzz < 0) {
            System.out.print("Cannot fizzbuzz negative numbers ");
        }else {
            for(int i = 1; i < valueFizzBuzz + 1; i++){
                if(i%3 == 0) {
                    if(i%5 == 0) {
                        System.out.print("FizzBuzz ");
                    }else {
                        System.out.print("Fizz ");
                    }
                }else if (i%5 == 0){
                    System.out.print("Buzz ");
                } else{
                    System.out.print(i + " ");
                }
            }
        }
        System.out.println(" \n Partie 2 :");
        System.out.println("fizzbuzz");

        final int fizzBuzz = 15;
        final int primeNumberOne = 3;
        final int primeNumberTwo = 7;

        if(primeNumberOne > 0 && primeNumberTwo > 0) {
            for(int i = 1; i < fizzBuzz + 1;i++) {
                if(i % primeNumberOne == 0 ) {
                    System.out.print("Fizz ");

                }else if (i % primeNumberTwo == 0) {
                    System.out.print("Buzz ");
                }else {
                    System.out.print(i + " ");

                }
            }
        }else if (primeNumberOne == primeNumberTwo) {
            System.out.println("Divisors must be distinct");
        }else {
            System.out.println("Divisor cannot be negative");

        }
    }
}
