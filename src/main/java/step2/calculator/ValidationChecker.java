package step2.calculator;

import java.util.Scanner;

public class ValidationChecker {


    // TODO: 예외처리 클래스를 따로 작성하는게...
    // TODO: 공백처리는 String split(" ") 로 변경

    // 입력받은 숫자 유효성 확인
    public Double readNumber(Scanner scanner, String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return null;
        }

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // 입력받은 연산자 유효성 확인
    public Character readOperator(Scanner scanner) {
        System.out.print("사칙연산을 입력하세요 (+, -, *, /): ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("연산자가 입력되지 않았습니다.");
        }

        // TODO: 추후 삼항 이상의 연산을 고려할것, 일단은 이항 연산자 입력시 무조건 첫 번째 입력값만 뜯어오게 해둠
        char operator = input.charAt(0);

        // TODO: enum 으로 빼면 될듯?
        boolean isValidOperator = operator == '+' || operator == '-' || operator == '*' || operator == '/';
        if (!isValidOperator) {
            throw new IllegalArgumentException("연산자를 올바르게 입력해주세요.");
        }
        return operator;
    }

}
