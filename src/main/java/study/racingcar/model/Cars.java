package study.racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private List<Car> cars;

    public Cars(int carCount){
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            Car car = new Car();
            cars.add(car);
        }
        this.cars = cars;
    }

    public int getCarCount() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
