package study.racingcar.util;

import java.util.Random;

public class CommonUtil {

    public static int getRandomNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber);
    }
}
