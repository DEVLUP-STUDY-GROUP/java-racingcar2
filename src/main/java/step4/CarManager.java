package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarManager {
    public List<Car> carList = new ArrayList<>();
    public CarFactory carFactory;

    public CarManager(String[] carNames,CarFactory carFactory){
        this.carFactory = carFactory;
        for(String carName : carNames){
            addCar(carFactory.createCar(carName));
        }
    }
    public List<Car> pickWinner() {
        /*List<Car> maxValues = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (Car car : carList) {
            int num=car.getPosition();
            if (num > max) {
                max = num;
            }
        }
        for (Car car : carList) {
            int num=car.getPosition();
            if (num == max) {
                maxValues.add(car);
            }
        }
        return maxValues;*/
        int maxPosition = carList.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
    public void addCar(Car car){
        carList.add(car);
    }

    public Car getCar(int index){
        return carList.get(index);
    }

    public int getCarCount(){
        return carList.size();
    }
}
