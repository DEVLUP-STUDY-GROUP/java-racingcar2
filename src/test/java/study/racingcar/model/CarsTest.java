package study.racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @DisplayName("자동차 최대 위치 조회")
    @Test
    void 자동차_최대_위치_조회(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 5));
        cars.add(new Car("jimmy", 7));
        cars.add(new Car("google", 2));
        Cars compCars = new Cars(cars);
        assertThat(compCars.getMaxPosition()).isEqualTo(7);
    }

    @DisplayName("자동차 우승 차량 조회")
    @Test
    void 자동차_우승_차량_조회(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi", 5));
        cars.add(new Car("jimmy", 7));
        cars.add(new Car("google", 2));
        Cars compCars = new Cars(cars);
        assertThat(compCars.getWinnerCarNames()).isEqualTo(new ArrayList<>(Arrays.asList("jimmy")));
    }

    @DisplayName("자동차 리스트 비교")
    @Test
    void 자동자_리스트_비교() {
        Cars cars = new Cars("pobi,jimmy,google");

        List<Car> compCars = new ArrayList<>();
        compCars.add(new Car("pobi"));
        compCars.add(new Car("jimmy"));
        compCars.add(new Car("google"));
        assertThat(cars.getCars()).isEqualTo(compCars);
    }
}
