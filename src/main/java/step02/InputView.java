package step02;

import java.util.Scanner;

public class InputView {

    public int getNumberOfCar() {
        System.out.println("자동차의 대수는 몇 대 인가요?");
        return validateNumberOfCar(getInput());
    }

    public int getNumberOfLoopCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return validateNumberOfLoopCount(getInput());
    }

    private int getInput() {
        return new Scanner(System.in).nextInt();
    }

    public int validateNumberOfCar(int numberOfCar) {
        if (numberOfCar == 0 || numberOfCar > 10) {
            throw new IllegalArgumentException("car number must be between 1 and 10");
        }
        return numberOfCar;
    }

    public int validateNumberOfLoopCount(int numberOfLoopCount) {
        if (numberOfLoopCount == 0 || numberOfLoopCount > 10) {
            throw new IllegalArgumentException("count is more than zero and no more than 10 times");
        }
        return numberOfLoopCount;
    }
}
