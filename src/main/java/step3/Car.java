package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    public int position=1;
    public RandomGenerator randomGenerator;
    public Car(RandomGenerator randomGenerator){
        this.randomGenerator = randomGenerator;
    }

    public void moveAction(){
        int randomNumber = randomGenerator.nextInt(Constants.RANDOM_BOUND);
        if(randomNumber>Constants.FORWARD_LIMIT) {
            position++;
        }
        ResultView.foward(position);
    }
}
