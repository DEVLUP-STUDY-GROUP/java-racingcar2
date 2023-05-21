package step2.calculator;

import step2.calculator.calexecutor.AddNumbers;
import step2.calculator.calexecutor.DivideNumbers;
import step2.calculator.calexecutor.MultiplyNumbers;
import step2.calculator.calexecutor.SubtractNumbers;

import java.util.Scanner;

public class Entrance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ValidationChecker checker = new ValidationChecker();

        while (true) {
            // 첫 번째 숫자 입력

            Double num1 = checker.readNumber(scanner, "첫 번째 숫자를 입력하세요: ");
            if (num1 == null) {
                System.out.println("숫자를 올바르게 입력해주세요.");
                scanner.close();
                return;
            }

            // 연산자 입력
            Character operator = checker.readOperator(scanner);
            if (operator == null) {
                System.out.println("연산자를 올바르게 입력해주세요.");
                scanner.close();
                return;
            }

            // 두 번째 숫자 입력
            Double num2 = checker.readNumber(scanner, "두 번째 숫자를 입력하세요: ");

            if (num2 == null) {
                System.out.println("숫자를 올바르게 입력해주세요.");
                scanner.close();
                return;
            }

            // 0으로 나누는지 확인
            if (operator == '/' && num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                scanner.close();
                return;
            }

            // 연산 수행
            double result = calculate(num1, operator, num2);
            System.out.println("결과: " + result);

            System.out.println("계속해서 계산하시겠습니까? (Y = 계속)");
            String input = scanner.nextLine().trim();
            if (!input.equalsIgnoreCase("Y")) {
                break;
            }
        }
        scanner.close();
    }

    // 연산 수행
    static double calculate(double num1, char operator, double num2) {

        Calculating calculating;

        // TODO: else if 문 다 뜯어내기
        if (operator == '+') {
            calculating = new AddNumbers();
        } else if (operator == '-') {
            calculating = new SubtractNumbers();
        } else if (operator == '*') {
            calculating = new MultiplyNumbers();
        } else if (operator == '/') {
            calculating = new DivideNumbers();
        } else {
            throw new IllegalArgumentException("잘못된 연산자 입력입니다.");
        }

        return calculating.twoParamsCal(num1, num2);
    }

}

