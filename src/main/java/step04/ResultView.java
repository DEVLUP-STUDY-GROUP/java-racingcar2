package step04;

import java.util.List;

public class ResultView {

    public static void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.println("최종 우승자:");
        for (Car winner : winners) {
            System.out.println(winner.getCarName()); // 우승자는 다수가 될 수 있음
        }
    }
}
