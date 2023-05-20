package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class Step03_Caracing {

    @ParameterizedTest
    @CsvSource({"0", "11"})
    @DisplayName("자동차 대수가 1 미만이거나 10을 초과하는 경우")
    @Order(1)
    void validateCarNum(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    // InputStream을 사용하여 테스트용 입력값으로 설정
                    InputStream in = generateUserInput(input);
                    System.setIn(in);

                    Scanner sc = new Scanner(System.in);
                    new ResultView().validateInputValueByCarNumber(sc.nextInt());
                })
//                .withMessageContaining("test")
                .withMessageContaining("between 1 and 10")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0", "11"})
    @DisplayName("시도 횟수가 0이거나 10회 초과하는 경우")
    @Order(2)
    void validateCount(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    // InputStream을 사용하여 테스트용 입력값으로 설정
                    InputStream in = generateUserInput(input);
                    System.setIn(in);

                    Scanner sc = new Scanner(System.in);
                    new ResultView().validateInputValueByCount(sc.nextInt());
                })
//                .withMessageContaining("test")
                .withMessageContaining("more than zero")
                .isInstanceOf(IllegalArgumentException.class);
    }

    /* Scanner Test를 하기 위해서 사용 */
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
