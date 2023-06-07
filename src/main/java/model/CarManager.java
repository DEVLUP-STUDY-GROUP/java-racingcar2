package model;

import exception.DuplicateNameException;
import model.Car;
import model.CarFactory;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import java.util.*;
import java.util.stream.Collectors;

public class CarManager {
    public List<Car> carList = new ArrayList<>();
    public CarFactory carFactory;

    public CarManager(String[] carNames,CarFactory carFactory){
        this.carFactory = carFactory;
        for(String carName : carNames){
            addCar(carFactory.createCar(carName));
        }
        checkForDuplicateCarNames();
    }

    private void checkForDuplicateCarNames() {
        Set<String> names = new HashSet<>();

//        for(int i=0; i<carList.size() ; i++){
//            for(int j=0; j<carList.size(); j++){
//                if(i==j) continue;
//                if(carList.get(i).equals(carList.get(j))){
//                    throw new DuplicateNameException("duplicate Car Name");
//                }
//            }
//        }
        for(Car car : carList) {
            if(!names.add(car.getName())) {
                throw new DuplicateNameException("duplicate Car Name : "+car.getName());
            }
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
        int maxPosition = getMaxPosition();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        int maxPosition = carList.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
        return maxPosition;
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
