import org.junit.Assert;

public class HelperTesterRange {
    private Range range;

    public HelperTesterRange(Range r) {
        range = r;
    }

    //TODO: assertEquals => AssertTrue
    public HelperTesterRange isInRange(int value, boolean result){
        Assert.assertEquals(result, range.isInRange(value));
        return this;
    }

    public HelperTesterRange size(int value){
        Assert.assertEquals(value, range.size());
        return this;
    }

    public HelperTesterRange contents(int[] values){
        Assert.assertEquals(values, range.values());
        return this;
    }

}
