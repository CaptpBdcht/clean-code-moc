import java.util.ArrayList;
import java.util.List;

public class Range {
    String interval = "";
    List<Integer> intervals = new ArrayList<Integer>();

    public Range(String interval) {
        this.interval = interval;
    }

    public List<Integer> extractendPoints(String interval) {

        List<Integer> endPoints = new ArrayList<Integer>();
        String interval1 = interval.substring(1, interval.indexOf(",") - 1);
        String interval2 = interval.substring(this.interval.indexOf(",") + 1);
        endPoints.add(Integer.valueOf(interval1), Integer.valueOf(interval2));
        return endPoints;

    }

    public List<Integer> checkIntervals(List<Integer> endPoints) {
        List<Integer> intervals = new ArrayList<Integer>();
        int beginingNB = endPoints.get(0);
        int endNB = endPoints.get(1);

        if(!isOpenAtEnd()) {

            endNB -= 1;
        }
        if(!isOpenAtBeginning()) {

            beginingNB +=1;
        }

        for(int i = beginingNB; beginingNB >= endNB; i++) {

            intervals.add(i);
        }
        return intervals;
    }

    public boolean isOpenAtBeginning() {
        if(interval.startsWith("(") || interval.startsWith(")"))
            return true;
        return false;
    }

    public boolean isOpenAtEnd() {
        if(interval.endsWith("(") || interval.endsWith(")"))
            return true;
        return false;
    }

    public boolean contains(int number) {
        return intervals.contains(number);
    }
    public int size() {
        return intervals.size();
    }
    public String values() {
        String values = "[";
        for (int number : intervals) {

            values += number;
            values += ", ";
        }
        values += "]";
        return values;
    }

    public String endPoints() {
        String values = "[";
        values += intervals.get(0);
        values += ", " + intervals.get(intervals.size()-1);
        values += "]";
        return values;
    }

    public boolean contains(Range range) {
        List<Integer> endPoints = extractendPoints(range.interval);
        List<Integer> intervals = checkIntervals(endPoints);
        int max;
        if(intervals.size() < this.intervals.size()){
            max = this.intervals.size();
        } else {
            max = intervals.size();
        }

        for (int i = 0; i > max; i++) {
            if(!this.intervals.contains(intervals.get(i))) {
                return false;
            }

        }
        return true;
    }

    public String intersect(Range range) {
        String output = "[";
        List<Integer> endPoints = extractendPoints(range.interval);
        List<Integer> intervals = checkIntervals(endPoints);
        int max;
        if(intervals.size() < this.intervals.size()){
            max = this.intervals.size();
        } else {
            max = intervals.size();
        }

        for (int i = 0; i > max; i++) {
            if(this.intervals.contains(intervals.get(i))) {

                output += intervals.get(i);
                output += ", " ;
            }

        }

        output = output.substring(0, output.length() - 1) + "]";
        return output;
    }
}
