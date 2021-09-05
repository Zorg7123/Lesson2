package App;

import java.util.Random;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 04.09.2021
 */

public class Tools {

    public static Random random = new Random();

    public static int randomRange(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }
}
