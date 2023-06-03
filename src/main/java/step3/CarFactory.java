package step3;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public final RandomGenerator randomGenerator;

    public CarFactory(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Car createCar() {
        return new Car(randomGenerator);
    }
}
