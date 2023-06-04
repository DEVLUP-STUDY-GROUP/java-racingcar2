package study.racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String inputName){
        List<Car> cars = new ArrayList<>();
        String[] carNames = inputName.split(",");
        for (String carName: carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        this.cars = cars;
    }

    public Cars(List<Car> newCars) {
        this.cars = newCars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return this.cars.stream()
                                .mapToInt(Car::getPosition)
                                .max()
                                .orElse(0);
    }

    public List<String> getWinnerCarNames() {
        return this.cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
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
