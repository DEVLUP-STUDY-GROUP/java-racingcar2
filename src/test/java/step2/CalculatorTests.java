package step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.calculator.Calculating;
import step2.calculator.calexecutor.*;

public class CalculatorTests {
    @Test
    @DisplayName("덧셈 테스트")
    void testAddition() {
        Calculating addTwoParams = new AddNumbers();
        double result = addTwoParams.twoParamsCal(10.5, 5.5);
        Assertions.assertEquals(16.0, result);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void testSubtraction() {
        Calculating subtractTwoParams = new SubtractNumbers();
        double result = subtractTwoParams.twoParamsCal(10.5, 5.5);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    @DisplayName("곱셈 테스트")
    void testMultiplication() {
        Calculating multiplyTwoParams = new MultiplyNumbers();
        double result = multiplyTwoParams.twoParamsCal(10.5, 2.5);
        Assertions.assertEquals(26.25, result);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void testDivision() {
        Calculating divideTwoParams = new DivideNumbers();
        double result = divideTwoParams.twoParamsCal(10.5, 3.5);
        Assertions.assertEquals(3.0, result);
    }

    @Test
    @DisplayName("0 나눗셈 테스트")
    void testDivisionByZero() {
        Calculating divideTwoParams = new DivideNumbers();
        Assertions.assertThrows(ArithmeticException.class,
                () -> divideTwoParams.twoParamsCal(10.5, 0)
        );
    }
}
