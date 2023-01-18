package numberguessinggame;

import java.util.Random;

public class NumberGenerator {
    static Random random = new Random();

    public static int generateRandomNumber(byte bound) {
        return random.nextInt(bound);
    }
}
