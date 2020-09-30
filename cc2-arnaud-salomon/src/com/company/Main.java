package com.company;

public class Main {

    public static void main(String[] args) {

        final RangeOfNumber rangeOfNumber = new RangeOfNumber(1,3);

        boolean isContains = rangeOfNumber.numberIsInTheRange(rangeOfNumber,2);
        System.out.println("Does it contains the number ? -> " + isContains);

        int rangeNumberSize = rangeOfNumber.sizeOfTheRange(rangeOfNumber);
        System.out.println("Size of the range -> " + rangeNumberSize);

        rangeOfNumber.valuesInTheRange(rangeOfNumber,true,true);
        rangeOfNumber.endPoint(rangeOfNumber);
    }
}
