package step02.constant;

import step02.ExceptionMessage;
import step02.repository.OperationStrategy;

import java.util.Arrays;

public enum Operator {
    add("+", (f, s) -> f + s),
    subtract("-", (f, s) -> f - s),
    multiply("*", (f, s) -> f * s),
    divide("/", (f, s) -> {
        if (s == 0) {
            throw new IllegalArgumentException(ExceptionMessage.DIVIDE_BY_ZERO.getMessage());
        } else {
            return f / s;
        }
    });

    private String operator;
    private OperationStrategy operation;

    Operator(String operator, OperationStrategy operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public int calculate(int a, int b) {
        return this.operation.calculateByNumbers(a, b);
    }

    /* operator 조건에 맞는 enum 반환 */
    public static Operator getInstanceTypeByOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_ARITHMETIC_SYMBOL.getMessage()));
    }
}
