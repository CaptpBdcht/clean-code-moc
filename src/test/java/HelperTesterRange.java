import org.junit.Assert;

public class HelperTesterRange {
    private Range range;

    public HelperTesterRange(Range r) {
        range = r;
    }


    public HelperTesterRange isInRange(int value){
        Assert.assertTrue(range.isInRange(value));
        return this;
    }

    public HelperTesterRange isNotInRange(int value){
        Assert.assertFalse(range.isInRange(value));
        return this;
    }

    public HelperTesterRange size(int value){
        Assert.assertEquals(value, range.size());
        return this;
    }

    public HelperTesterRange contents(int[] values){
        Assert.assertArrayEquals(values, range.values());
        return this;
    }

    public HelperTesterRange endPoints(int[] values){
        Assert.assertArrayEquals(values, range.endPoints());
        return this;
    }

}
