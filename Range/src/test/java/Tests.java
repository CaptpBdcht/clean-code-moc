import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;

public class Tests {

    @Test
    public void create() throws RangeError{
        Range range = new Range('[', 1, 3, ']');
        assert(range.toString().equals("[1, 3]"));
    }

    @Test
    public void rangeContains1() throws RangeError{
        Range range = new Range('[', 1, 3, ']');
        assert(range.contains(2));
    }

    @Test
    public void rangeContains2() throws RangeError{
        Range range = new Range('[', 1, 3, ']');
        assertFalse(range.contains(4));
    }

    @Test
    public void rangeContains3() throws RangeError{
        Range range = new Range('[', 2, 7, ')');
        assertFalse(range.contains(7));
    }

    @Test
    public void rangeSize1() throws RangeError{
        Range range = new Range('[',1, 3, ']');
        assert(range.size() == 3);
    }

    @Test
    public void rangeSize2() throws RangeError{
        Range range = new Range('[',1, 6, ']');
        assert(range.size() == 3);
    }

    @Test
    public void rangeSize3() throws RangeError{
        Range range = new Range('[',2, 7, ')');
        assert(range.size() == 5);
    }

    @Test
    public void rangeValues1() throws RangeError {
        Range range = new Range('[',1, 4, ']');
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assert(range.values().containsAll(list));
    }
}
