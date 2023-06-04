package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("입력받은 위치가 0보다 작은 경우")
    @ParameterizedTest(name="{displayName} | 요청식: {0}")
    @ValueSource(ints = {-1,  -999})
    public void 입력받은_위치가_0보다_작은_경우(int position) {
        assertThatThrownBy(() -> {
            new Car(position);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 위치인 경우")
    @ParameterizedTest(name="{displayName} | 요청식: {0}")
    @ValueSource(ints = {1,  5})
    public void 정상_위치인_경우(int position) {
        Car car = new Car(position);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("차량 이름을 입력 안한 경우")
    @Test
    void 차량_이름을_입력_안한_경우() {
        assertThatThrownBy(() -> {
            new Car("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차량 이름 조회")
    @Test
    void 차량_이름_조회() {
        String name = "pobi";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("객체 생성 이후 위치 조회")
    @Test
    void 객체_생성_이후_위치_조회() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("차량 이동 실패")
    @Test
    void 차량_이동_실패() {
        Car car = new Car();
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("차량 이동 확인")
    @Test
    void 차량_이동_확인() {
        Car car = new Car();
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
