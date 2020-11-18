import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    public static int randomNumber(int min, int max) {
        if(max-min > 1) {
            return ThreadLocalRandom.current().nextInt(min, max);
        }
        return min;
    }
}
