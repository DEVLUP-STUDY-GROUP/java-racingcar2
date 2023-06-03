package step04;

import java.util.Scanner;

public class InputView {

    public static String[] getInputCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분):");
        return sc.nextLine().split(", ");
    }

    public static int getTryCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("시도할 횟수는 몇회인가요?");
        return sc.nextInt();
    }
}
