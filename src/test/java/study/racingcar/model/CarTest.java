package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.calculator.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("입력받은 위치가 0보다 작은 경우")
    @ParameterizedTest(name="{displayName} | 요청식: {0}")
    @ValueSource(ints = {-1,  -999})
    public void 입력받은_위치가_0보다_작은_경우(int position) {
        assertThatThrownBy(() -> {
            new Car("TEST", position);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("초기 생성자 위치 조회")
    @Test
    void 초기_생성자_위치_조회() {
        Car car = new Car("TEST,qwe");
        assertThat(car.getPosition()).isEqualTo(0);
    }

//    @DisplayName("현재 위치 조회")
//    @ParameterizedTest(name="{displayName} | 요청식: {0}")
//    @ValueSource(ints = {1, 10})
//    public void 현재_위치_조회(int position) {
//        Car car = new Car(position);
//        assertThat(car.getPosition()).isEqualTo(position);
//    }
//
//    @DisplayName("이동 조건이 참인 경우")
//    @Test
//    public void 이동_조건이_참인_경우() {
//        Car car = new Car();
//        car.move(() -> true);
//        assertThat(car.getPosition()).isEqualTo(1);
//    }
//
//    @DisplayName("이동 조건이 거짓인 경우")
//    @Test
//    public void 이동_조건이_거짓인_경우() {
//        Car car = new Car();
//        car.move(() -> false);
//        assertThat(car.getPosition()).isEqualTo(0);
//    }
}
