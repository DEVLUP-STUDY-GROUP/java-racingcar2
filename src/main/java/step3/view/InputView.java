package step3.view;

import step3.domain.Invalidator;
import step3.domain.Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);
    public static int inputCarNums() {
        System.out.print("경주에 참가시킬 차량 대수를 입력하세요: ");
        int carCount = scanner.nextInt();

        return carCount;
    }

    public static int inputTryCount() {
        System.out.print("전진을 시도할 회수를 입력하세요: ");
        int tryCount = scanner.nextInt();

        return tryCount;
    }

    public static List inputCarNames(int carNums) {
    List<Racing> cars = new ArrayList<>();
        int i = 0; // for 문 넣었다가 i++ 를 의도대로 핸들링 못 해서 로직 꼬임 -> while 문으로 교체

        // TODO: 이중 중첩문 메소드로 빼내기
        while (i < carNums) {
            String name;

            do {
                System.out.print("경주 차량 이름을 입력하세요. " + "(5글자 이하, 중복되는 경주 차량 이름 불가) : ");
                name = scanner.next();

            } while (!Invalidator.validationCheck(cars, name));
            cars.add(new Racing(name));

            i++; // 차량이 추가되고나서야 다음 차량 입력받도록..
        }

        System.out.println("경주를 시작합니다.");

        return cars;
    }

}
