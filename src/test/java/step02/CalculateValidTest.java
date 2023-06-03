package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculateValidTest {

    @Test
    @DisplayName("입력 값 null")
    @Order(1)
    void isNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator().calculateResult(null))
                .withMessageMatching("input value is null or empty")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 공백")
    @Order(2)
    void isEmpty() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator().calculateResult(""))
                .withMessageMatching("input value is null or empty")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            //"1 * 2",
            "1 ! 2",
            "1 + 2 # 3",
            "2 * 3 ! 5",
            "6 ( 1 ~ 5",
            "9 ) 7 $ 8",
    })
    @DisplayName("사칙연산 기호 아닌 경우")
    @Order(3)
    void isNotValidOperator(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator().calculateResult(input))
                .withMessageContaining("not an operator symbol")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "1 / 0")
    @DisplayName("0으로 나눈 경우")
    @Order(4)
    void divideByZero(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator().calculateResult(input))
                .withMessageContaining("cannot divide by zero")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "A / B * C")
    @DisplayName("정수가 아닌 문자인 경우")
    @Order(5)
    void isNotNumeric(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator().calculateResult(input))
                .withMessageContaining("cannot parse none numeric value")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
