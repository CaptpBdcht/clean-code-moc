import org.junit.Assert;
import org.junit.Test;

// Installer la dépendance JUnit pour utiliser les tests via Maven

public class Tests {
    @Test
    public void contains() {
        Range range = new Range(1, false, 3, false);
        Assert.assertTrue(range.contains(2));

        Range range2 = new Range(1, false, 3, false);
        Assert.assertFalse(range2.contains(4));

        Range range3 = new Range(2, false, 7, true);
        Assert.assertFalse(range3.contains(7));
    }

    @Test
    public void size() {
        Range range = new Range(1, false, 3, false);
        Assert.assertEquals(range.size(), 3);

        Range range2 = new Range(1, false, 6, false);
        Assert.assertEquals(range2.size(), 6);

        Range range3 = new Range(2, false, 7, true);
        Assert.assertEquals(range3.size(), 5);
    }
}
