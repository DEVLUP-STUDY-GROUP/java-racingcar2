package step3;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputView implements InputView {
    public static String carMainMessage ="자동차 대수는?";
    public static String carMainMessage2 ="시도할 회수는 몇 회 인가요?";
    public Scanner scanner ;

    public ConsoleInputView(String input){
        systemIn(input);
        scanner = new Scanner(System.in);
    }
    @Override
    public String getCarNumberPrompt(){
        return carMainMessage;
    }

    @Override
    public String getAttemptCountPrompt(){
        return carMainMessage2;
    }

    @Override
    public int getNextInt(){
        int input = -1;
        try {
            input = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("숫자만 입력해 주세요.");
        }
        if (input < 0) {
            throw new IllegalArgumentException("입력값은 0보다 커야합니다. 입력된 값 : "+ input);
        }
        return input;
    }
    public void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}
