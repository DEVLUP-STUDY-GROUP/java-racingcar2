package study.racingcar.view;

import study.racingcar.model.Car;
import study.racingcar.util.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarView {

    private static Scanner scanner = new Scanner(System.in);
    private static int maxNumber = 10;

    public static int inputCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public static int inputTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }

    private static void getStringPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void result(int carNumber, int tryNumber) {
        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            carList.add(new Car(0));
        }

        for (int i = 0; i < tryNumber; i++) {
            for (Car car : carList) {
                car.move(CommonUtil.getRandomNumber(maxNumber));
//                car.move(4);
                getStringPosition(car.getPosition());
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("자동차 대수 : " + carNumber +  " | 시도할 회수 : " + tryNumber);
    }
}

