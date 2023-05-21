package study.racingcar.view;

import study.racingcar.model.Car;
import study.racingcar.model.Cars;
import study.racingcar.strategy.MoveStrategy;
import study.racingcar.strategy.RandomMove;

import java.util.Scanner;

public class RacingCarView {
    private static String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static String PRINT_DASH = "-";
    private static final String RESULT_INIT_MESSAGE = "실행 결과";


    public static int inputCarNumber() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
        return getNumber();
    }

    public static int inputTryNumber() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return getNumber();
    }

    public void resultInitMessage(){
        System.out.println(RESULT_INIT_MESSAGE);
    }

    public static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(PRINT_DASH);
        }
        breakTime();
    }

    public static void breakTime() {
        System.out.println();
    }

    private static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}

