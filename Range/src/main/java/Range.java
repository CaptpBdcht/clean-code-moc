import java.util.ArrayList;
import java.util.List;

class RangeError extends Exception {
    RangeError(String message){
        super(message);
    }
}

public class Range {
    private int intervalMin;
    private boolean closedMin;

    private int intervalMax;
    private boolean closedMax;

    Range(char endpointMin, int min, int max, char endpointMax) throws RangeError{
        if(endpointMin != '[' && endpointMin != '(')
            throw new RangeError("Il faut utiliser une borne valable : '[' ou '('");

        if(endpointMax != ']' && endpointMax != ')')
            throw new RangeError("Il faut utiliser une borne valable : ']' ou ')'");

        closedMin = endpointMin == '[';
        closedMax = endpointMax == ']';

        this.intervalMin = min;
        this.intervalMax = max;
    }

    public boolean contains(int value){
        int min = closedMin ? intervalMin : intervalMin + 1;
        int max = closedMax ? intervalMax + 1 : intervalMax;

        for(int index = min; index < max; index++){
            if(index == value)
                return true;
        }
        return false;
    }

    public int size(){
        int min = closedMin ? intervalMin : intervalMin + 1;
        int max = closedMax ? intervalMax + 1 : intervalMax;
        return max - min;
    }

    public List<Integer> values(){
        return new ArrayList<>();
    }

    //public List<Integer> endPoints(){ return new ArrayList<>(); }

    //public Range intersect(){ return new Range(); }

    @Override
    public String toString() {
        String borderMin = closedMin ? "[" : "(";
        String borderMax = closedMax ? "]" : ")";
        return borderMin  + intervalMin + ", " + intervalMax + borderMax;
    }
}
