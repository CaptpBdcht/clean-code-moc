import java.util.ArrayList;
import java.util.List;

public class Range{
    private int start;
    private int end;
    private boolean startIncluded;
    private boolean endIncluded;

    public Range(int start, int end, boolean startIncluded, boolean endIncluded) {
        this.start = start;
        this.end = end;
        this.startIncluded = startIncluded;
        this.endIncluded = endIncluded;
    }

    public boolean isInRange(int valueToSeek){
        if(valueToSeek < start || valueToSeek > end){
            return false;
        } else if (valueToSeek == start && !startIncluded || valueToSeek == end && !endIncluded){
            return false;
        }
        return true;
    }

    public int size(){
        int flag_start = start;
        int flag_end = end;
        if(!startIncluded){
            flag_start++;
        }
        if(!endIncluded){
            flag_end--;
        }
        int counter = 0;
        int flag;
        for(flag = flag_start ; flag <= flag_end ; flag++){
            counter++;
        }
        return counter;
    }

    public int[] values(){
        int[] values = new int[0];

        int flag_start = start;
        int flag_end = end;
        if(!startIncluded){
            flag_start++;
        }
        if(!endIncluded){
            flag_end--;
        }
        int counter = 0;
        int flag;
        for(flag = flag_start ; flag <= flag_end ; flag++){
            values[counter] = flag;
            counter++;
        }

        return values;
    }

    public int[] endPoints(){

        int flag_start = start;
        int flag_end = end;
        if(!startIncluded){
            flag_start++;
        }
        if(!endIncluded){
            flag_end--;
        }

        return new int[]{ flag_start, flag_end};
    }

}