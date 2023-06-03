package step04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarWinnerTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobidunssss", "sudosdddas", "admindddasd"})
    @DisplayName("자동 이름이 5글자를 초과하는 경우")
    void testCarNameOverThan5(String carNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    String[] carNameArr = {carNames};
                    new RacingCarWinner().startRacing(carNameArr, 5);
                }).withMessageContaining("자동차 이름은 5글자 이하만")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
