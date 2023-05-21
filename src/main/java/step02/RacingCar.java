package step02;

import java.util.Random;

public class RacingCar {

    public void prepareInputValueByUser() {
        InputView inputView = new InputView();
        int numberOfCar = inputView.getNumberOfCar();
        int numberOfLoopCount = inputView.getNumberOfLoopCount();
        startRacing(numberOfCar, numberOfLoopCount);
    }

    /**
     * @param numberOfCar 차량 대수
     * @param numberOfLoopCount 시도 횟수
     */
    public void startRacing(int numberOfCar, int numberOfLoopCount) {
        for (int i = 0; i < numberOfLoopCount; i++) {
            String[] cars = moveRacingCars(numberOfCar);
            ResultView.printRacingCars(cars);
        }
    }

    public String[] moveRacingCars(int numberOfCar) {
        String [] cars = new String[numberOfCar];
        for (int i = 0; i < cars.length; i++) { // 차량 갯수만큼 배열 공간에 '-' 일단 저장
            cars[i] = "-";
        }

        for (int i = 0; i < cars.length; i++) {
            int randomValue = new Random().nextInt();
            if (randomValue > 4) {
                cars[i] += "-";
            }
        }
        return cars;
    }
}
