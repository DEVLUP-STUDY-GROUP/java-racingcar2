package study.racingcar.view;

import study.racingcar.model.Car;
import study.racingcar.model.Cars;

import java.util.Scanner;

public class ResultView {
    private static final String RESULT_INIT_MESSAGE = "실행 결과";
    private static final String RESULT_END_MESSAGE = "가 우승하였습니다.";
    private static String PRINT_DASH = "-";
    private static String SPLIT_CHAR = " : ";

    public void resultInitMessage(){
        System.out.println(RESULT_INIT_MESSAGE);
    }

    public static void printPosition(Car car) {
        System.out.print(car.getName());
        System.out.print(SPLIT_CHAR);
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(PRINT_DASH);
        }
        breakTime();
    }

    public static void breakTime() {
        System.out.println();
    }

    public static void resultEndMessage(Cars cars) {
        System.out.print(String.join(", ", cars.getWinnerCarNames()));
        System.out.print(RESULT_END_MESSAGE);
    }
}
