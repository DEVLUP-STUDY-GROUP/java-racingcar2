package step2;

import java.util.Objects;

public class Calculator {
    /*
    - 사용자 입력 문자열 값에따라 사칙연산 수행
    - 숫자와 연산기호 사이에는 빈 공백 문자열
     */
    public static int calculate(String value) {
        // 입력 값이 null이거나 빈 공백일 경우 예외를 발생
        if(Objects.isNull(value) || value.trim().isEmpty()){
            throw new IllegalArgumentException("Input value is null or space ");
        }
        // 입력 값을 공백을 기준으로 분리
        String[] splitData = value.split(" ");

        // 첫 번째 숫자를 변환하고 저장
        int result = myParseInt(splitData[0]);

        // 두 번째 숫자부터 시작해서 연산자와 함께 계산
        for (int idx = 2; idx < splitData.length; idx += 2) {
            int operand = myParseInt(splitData[idx]);
            String operator = splitData[idx - 1];
            result = calculateByOperator(result, operator, operand);
        }

        return result;
    }
    // 문자열 정수로 변환
    private static int myParseInt(String str){
        try{
            return Integer.parseInt(str);
        }
       catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닐 경우", e);
        }
    }
    //유효하지 않은 연산자일 경우 예외를 발생
    private static int calculateByOperator(int result, String operator, int operand) {
        switch (operator) {
            case "+":
                return add(result, operand);
            case "-":
                return subtract(result, operand);
            case "*":
                return multiply(result, operand);
            case "/":
                return divide(result, operand);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static int subtract(int a, int b) {
        return a - b;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    //0으로 나눴을때 예외 발생
    private static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divide by zero error.");
        }
        return a / b;
    }

}
