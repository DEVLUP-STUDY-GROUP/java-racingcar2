package step02;

import java.util.Random;
import java.util.Scanner;

// 핵심 로직을 구현하는 코드와, UI 담당 로직 구분
// UI 로직을 InputView와 ResultView와 같은 클래스를 추가해 분리
public class ResultView {
    private int carNum; // 자동차 대수
    private int count; // 시도 횟수

    /**
     * 자동차 대수는 0이면 안되고, 1대에서 ~ 10대까지만 수용
     */
    public void validateInputValueByCarNumber(int carNum) {
        if (carNum == 0 || carNum > 10) {
            throw new IllegalArgumentException("car number must be between 1 and 10");
        }
        this.carNum = carNum;
    }

    /**
     * 시도 횟수는 0 이상이여야 하고, 10회 초과는 불가능하다
     */
    public void validateInputValueByCount(int count) {
        if (count == 0 || count > 10) {
            throw new IllegalArgumentException("count is more than zero and no more than 10 times");
        }
        this.count = count;
    }

    /**
     * 자동차 경주 게임 시작
     */
    public void startCarGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("자동차 대수는 몇대 인가요? : ");
        validateInputValueByCarNumber(sc.nextInt());

        System.out.println("시도할 횟수는 몇 회 인가요? : ");
        validateInputValueByCount(sc.nextInt());

        // 위에서 검증이 끝났기 때문에 자동차 경주 게임 시작
        System.out.println();
        System.out.println("실행 결과");
        printValueByCarCondition();
    }

    /**
     * 조건에 맞게 자동차 경주 값을 출력한다
     */
    public void printValueByCarCondition() {
        int idx = 0;
        while(idx < count) {
            for (int j = 0; j < carNum; j++) { // 자동차 대수만큼 Loop - n
                for (int k = 0; k < count; k++) { // 시도할 횟수 - n만큼 Loop
                    int uuid = new Random().nextInt(10);

                    if (k == 0) { // 난수가 4 미만인 경우 아무것도 출력하지 않기에, idx -> 0인 경우에는 '-' 한번 출력
                        System.out.print("-");
                        continue;
                    }

                    if (uuid > 4) {
                        System.out.print("-");
                    }
                }
                System.out.println();
            }
            System.out.println();
            idx++;
        }
    }
}
