package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.calculator.Calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


/**
    - 초간단 자동차 경주 게임을 구현한다.
    - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    - 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
    - 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
    - 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 */
public class CarTest {

    // 문자 -> 숫자로 변경
    // 숫자 변경 시 에러 제거

    @DisplayName("입력받은 위치가 1보다 작은 경우")
    @ParameterizedTest(name="{displayName} | 요청식: {0}")
    @ValueSource(ints = {0,  -999})
    public void 입력받은_위치가_1보다_작은_경우(int position) {
        assertThatThrownBy(() -> {
            new Car(position);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("현재 위치 조회")
    @ParameterizedTest(name="{displayName} | 요청식: {0}")
    @ValueSource(ints = {1, 10})
    public void 현재_위치_조회(int position) {
        Car car = new Car(position);
        assertThat(car.getPosition()).isEqualTo(position);
    }



    /**
     * Car가 가지고 있어야 할 것
     * - 현재 위치
     *
     * 랜덤 실행 시 0~9 사이 랜덤 돌리는 것을 따로 뺼것
     * 결과 값이 4 이상이 아닌 경우 테스트
     *
     *
     */



}
