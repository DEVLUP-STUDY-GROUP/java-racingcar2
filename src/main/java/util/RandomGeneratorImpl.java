package util;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator{
    public Random random = new Random();
    @Override
    public int nextInt(int bound){
        return random.nextInt(bound);
    }
}
