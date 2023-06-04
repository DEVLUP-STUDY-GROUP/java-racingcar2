package step3.view;

import step3.domain.Racing;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void printResult(List<Racing> cars) {

        System.out.println("Racing 이 종료되었습니다.");

        int maxPosition = 0;
        for (Racing car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        // TODO: 중첩문 빼내기
        List<String> winners = new ArrayList<>(); // 단일 우승자인 경우도 해야?
        for (Racing car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        // TODO: 중첩문 빼내기
        System.out.print("우승 차량은 ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" 입니다.");
    }

}
