package step3;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    public List<Car> carList = new ArrayList<>();
    public CarFactory carFactory;

    public CarManager(int carNums,CarFactory carFactory){
        for(int i = 0; i < carNums; i++){
            addCar(carFactory.createCar());
        }
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
