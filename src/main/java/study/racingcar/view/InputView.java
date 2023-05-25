package study.racingcar.view;

import java.util.Scanner;

public class InputView {
    private static String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private static Scanner scanner = new Scanner(System.in);

    public static String inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
        return scanner.nextLine();
    }

    public static int inputTryNumber() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        return scanner.nextInt();
    }
}
