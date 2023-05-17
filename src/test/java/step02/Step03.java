package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Step03 {

    @ParameterizedTest
    @ValueSource(strings = "2 + 3")
    @DisplayName("사칙 연산 - 덧셈")
    void add(String input) {
//        assertThat(new Calculator().calculateResult(input)).isEqualTo(3);
        assertThat(new Calculator().calculateResult(input)).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = "10 - 5")
    @DisplayName("사칙 연산 - 뺄셈")
    void subtract(String input) {
//        assertThat(new Calculator().calculateResult(input)).isEqualTo(3);
        assertThat(new Calculator().calculateResult(input)).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = "10 * 2")
    @DisplayName("사칙 연산 - 곱셈")
    void multiply(String input) {
//        assertThat(new Calculator().calculateResult(input)).isEqualTo(10);
        assertThat(new Calculator().calculateResult(input)).isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(strings = "20 / 2")
    @DisplayName("사칙 연산 - 나눗셈")
    void divide(String input) {
//        assertThat(new Calculator().calculateResult(input)).isEqualTo(12);
        assertThat(new Calculator().calculateResult(input)).isEqualTo(10);
    }

    @Test
    @DisplayName("입력 값이 null 혹은 공백인 경우")
    @Order(2)
    void isNull() {
        assertThatIllegalArgumentException()
                //.isThrownBy(() -> new Calculator().calculate("xxxxxxxx"))
                //.isThrownBy(() -> new Calculator().calculate("3 * 2 / 2 + 1, 4"))
                .isThrownBy(() -> new Calculator().calculate(null))
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
//        int i = new Calculator().calculateResult(input);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Calculator().calculateResult(input))
                .withMessageContaining("cannot parse none numeric value")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "2 + 3 * 4 / 2, 10",
            "5 + 6 * 7 / 2, 38",
            "4 - 3 * 6 / 2, 3",
            "3 + 3 * 4 / 2, 12",
            "3 * 2 / 2 + 1, 4"
    }, delimiter = ',')
    @DisplayName("사칙 연산 - 통합")
    @Order(1)
    void calculateByNumber(String input, int expect) {
        int result = new Calculator().calculateResult(input);
        assertEquals(expect, result);
    }
}
