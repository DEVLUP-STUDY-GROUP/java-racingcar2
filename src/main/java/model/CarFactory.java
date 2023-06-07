package model;

import model.Car;

public class CarFactory {

    //public final RandomGenerator randomGenerator;

    public CarFactory(){

    }
    //public CarFactory(RandomGenerator randomGenerator) {
    //    this.randomGenerator = randomGenerator;
    //}

    //public Car createCar(String carName) {
     //   return new Car(carName,randomGenerator);
    //}
    public Car createCar(String carName) {
        return new Car(carName);
    }
}
