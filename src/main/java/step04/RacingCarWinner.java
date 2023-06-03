package step04;

import java.util.ArrayList;
import java.util.List;

public class RacingCarWinner {

    public static void main(String[] args) {
        setUp();
    }

    public static void setUp() {
        String[] carNames = InputView.getInputCarNames();
        int tryCount = InputView.getTryCount();

        startRacing(carNames, tryCount);
    }

    /**
     * 경주 시작
     * @param carNames 사용자가 입력한 자동차 이름 [ pobi, crong, honux ]
     * @param tryCount 사용자가 요청한 시도 횟수 5
     */
    public static void startRacing(String[] carNames, int tryCount) {
        List<Car> cars = createCarsInstance(carNames);
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            ResultView.printCurrentStatus(cars);
        }

        List<Car> winners = getWinners(cars);
        ResultView.printWinners(winners);
    }

    private static List<Car> getWinners(List<Car> cars) {
        int maxPosition = 0;
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > maxPosition) {
                maxPosition = position;
                winners.clear();
                winners.add(car);
            } else if (position == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public static List<Car> createCarsInstance(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }
}
