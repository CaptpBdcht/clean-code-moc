package com.company;

import org.w3c.dom.ranges.Range;

public class RangeOfNumber {

    private  int beginingNumber;
    private int endingNumber;

    public RangeOfNumber(int beginingNumber, int endingNumber) {
        this.beginingNumber = beginingNumber;
        this.endingNumber = endingNumber;
    }

    public boolean numberIsInTheRange(RangeOfNumber rangeOfNumber, int numberToFind) {
        for(int i = rangeOfNumber.beginingNumber; i < rangeOfNumber.endingNumber + 1;i++) {
            if(i == numberToFind) {
                return true;
            }
        }
        return false;
    }

    public int sizeOfTheRange(RangeOfNumber rangeOfNumber) {
        int amountOfNumber = 0;
        for(int i = rangeOfNumber.beginingNumber; i < rangeOfNumber.endingNumber + 1;i++) {
            amountOfNumber++;
        }
        return amountOfNumber;
    }

    public void valuesInTheRange(RangeOfNumber rangeOfNumber, boolean includingBeginingNumber, boolean includingEndingNumber) {
        if(!includingBeginingNumber && includingEndingNumber) {
            seeValuesInRange(rangeOfNumber.beginingNumber+1, rangeOfNumber.endingNumber);
        }else if(includingBeginingNumber && !includingEndingNumber) {
            seeValuesInRange(beginingNumber, endingNumber+1);
        }else {
            seeValuesInRange(beginingNumber, endingNumber);
        }

    }

    public void seeValuesInRange (int beginingNumber, int endingNumber) {
        System.out.print("[");

        for(int i = beginingNumber; i < endingNumber + 1;i++) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public void endPoint(RangeOfNumber rangeOfNumber) {
        int beginingNumber = rangeOfNumber.beginingNumber;
        int endingNumber = rangeOfNumber.endingNumber;

        System.out.println("\n[" + beginingNumber + ", " + endingNumber + "]");
    }

    @Override
    public String toString() {
        return "RangeOfNumber{" +
                "beginingNumber=" + beginingNumber +
                ", endingNumber=" + endingNumber +
                '}';
    }
}
