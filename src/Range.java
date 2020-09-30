import java.util.ArrayList;
import java.util.List;

public class Range {
    private final int borneA;
    private final boolean isOpenA; // Si il est true : l'intervalle ne contiendra pas la borne.

    private final int borneB;
    private final boolean isOpenB; // Same

    Range(int borneA, boolean isOpenA, int borneB, boolean isOpenB) {
        this.borneA = borneA;
        this.isOpenA = isOpenA;
        this.borneB = borneB;
        this.isOpenB = isOpenB;
    }

    public boolean contains(int value) {
        int counter = delimitCounter();
        int limit = delimitLimit();

        for (;counter <= limit; counter++) {
            if (counter == value) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(Range range) {
        int borneATrueValue = delimitCounter();
        int borneBTrueValue = delimitLimit();

        return (borneATrueValue <= range.getBorneATrueValue()) && (borneBTrueValue >= range.getBorneBTrueValue());
    }

    public int size() {
        int counter = delimitCounter();
        int limit = delimitLimit();
        int result = 0;

        for (;counter <= limit; counter++) {
            result++;
        }
        return result;
    }

    public List<Integer> values() {
        int counter = delimitCounter();
        int limit = delimitLimit();
        List<Integer> result = new ArrayList<Integer>();

        for (;counter <= limit; counter++) {
            result.add(counter);
        }
        return result;
    }

    public List<Integer> endPoints() {
        List<Integer> result = new ArrayList<Integer>();
        result.add(delimitCounter());
        result.add(delimitLimit());

        return result;
    }

    public Range intersect(Range range) {
        int counter = delimitCounter();
        int limit = delimitLimit();
        List<Integer> integerInIntersection = new ArrayList<Integer>();

        for (;counter <= limit; counter++) {
            if (range.contains(counter)) {
                integerInIntersection.add(counter);
            }
        }
        if (integerInIntersection.size() >= 2) {
            return new Range(integerInIntersection.get(0), false, integerInIntersection.get(integerInIntersection.size() - 1), false);
        }
        else {
            return new Range(0, false, 0, false);
        }

    }

    public int getBorneATrueValue() {
        return delimitCounter();
    }

    public int getBorneBTrueValue() {
        return delimitLimit();
    }

    @Override
    public String toString() {
        return "Range{" +
                "borneA=" + borneA +
                ", borneB=" + borneB +
                '}';
    }

    private int delimitCounter() {
        if (isOpenA) {
            return borneA + 1;
        }
        else {
            return borneA;
        }
    }

    private int delimitLimit() {
        if (isOpenB) {
            return borneB - 1;
        }
        else {
            return borneB;
        }
    }
}
