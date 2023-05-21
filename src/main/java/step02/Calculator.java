package step02;

import step02.constant.Operator;

public class Calculator {

    public int calculateResult(String input) {
        return validateParam(input) ? calculate(input) : 0;
    }

    public int calculate(String input) {
        String[] values = input.split(" ");
        int result = parseNumeric(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            int second = parseNumeric(values[i + 1]);
            result = calculateByOperator(result, values[i], second);
        }
        return result;
    }

    public static int calculateByOperator(int first, String operator, int second) {
        return Operator.getInstanceTypeByOperator(operator).calculate(first, second);
    }

    public static boolean validateParam(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_VALUE_EMPTY.getMessage());
        }
        return true;
    }

    public static int parseNumeric(String input) {
        int result = 0;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.CANNOT_PARSE_NUMERIC.getMessage());
        }
        return result;
    }
}
