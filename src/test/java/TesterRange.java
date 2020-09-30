import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class TesterRange {
    public HelperTesterRange buildARange(int start, int end, boolean startIncluded, boolean endIncluded){
        Range range = new Range(start, end, startIncluded, endIncluded);
        return new HelperTesterRange(range);
    }

    @Test
    @DisplayName("Vérifie que 2 est dans [1,3]")
    public void isInRange(){
        buildARange(1, 3, true, true)
                                .isInRange(2);
    }

    @Test
    @DisplayName("Vérifie que 4 n'est pas dans [1,3]")
    public void isNotInRange(){
        buildARange(1, 3, true, true)
                                .isNotInRange(4);
    }

    @Test
    @DisplayName("Vérifie que la taille de [2,7) est bien 5")
    public void size(){
        buildARange(2, 7, true, false)
                .size(5);
    }

    @Test
    @DisplayName("Les valeurs contenues dans [2, 6] sont [2, 3, 4, 5, 6]")
    public void contents(){
        int[] expectedValues = {2,3,4,5,6};

        buildARange(2, 7, true, true)
                .contents(expectedValues);
    }

    @Test
    @DisplayName("[1, 8] bornes [1, 8]")
    public void endPoints(){
        int[] expectedValues = {1, 8};

        buildARange(1, 8, true, true)
                .endPoints(expectedValues);
    }




}
