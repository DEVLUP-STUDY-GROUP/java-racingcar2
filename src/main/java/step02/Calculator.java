package step02;

import step02.constant.Operator;

public class Calculator {

    /* 메인 */
    public int calculateResult(String input) {
        return validateParam(input) ? calculate(input) : 0;
    }

    /* 미드 */
    public int calculate(String input) {
        String[] values = input.split(" ");
        int result = parseNumeric(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            int second = parseNumeric(values[i + 1]);
            result = calculateByOperator(result, values[i], second);
        }
        return result;
    }

    /* 사칙 연산 구분자에 따른 계산 */
    private static int calculateByOperator(int first, String operator, int second) {
        return Operator.getInstanceTypeByOperator(operator).calculate(first, second);
    }

    /* 파라미터 공백 검증 */
    private static boolean validateParam(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_EMPTY.getMessage());
        }
        return true;
    }

    /* 문자열 정수 검증 */
    private static int parseNumeric(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.CANNOT_PARSE_NUMERIC.getMessage());
        }
        return result;
    }
}
