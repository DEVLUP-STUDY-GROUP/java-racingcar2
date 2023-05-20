package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Step03_Calculate {

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
