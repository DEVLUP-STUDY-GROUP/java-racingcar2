package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import step3.domain.Invalidator;
import step3.domain.Racing;

import java.util.Arrays;
import java.util.List;

// TODO: 'test+메소드네임' 으로 통일
public class RacingTest {

    @Test
    public void testMove() {
        Racing car = new Racing("MovingCar");
        car.move();
        int position = car.getPosition();
        Assertions.assertTrue(position >= 0 && position <= 1, "0~1 이동"); // 랜덤값 4 미만 -> 이동을 안 했을 경우도 존재

        car.move();
        position = car.getPosition();
        Assertions.assertTrue(position >= 0 && position <= 2, "0~2 이동"); // 랜덤값 4 미만 -> 이동을 안 했을 경우도 존재
    }

    @Test
    public void testGetPosition() {
        Racing car = new Racing("PositioningCar");
        int position = car.getPosition();
        Assertions.assertEquals(0, position, "자동차 위치 확인 검사");
    }

    @Test
    public void testCheckStringLength() {
        // 이름이 5자 안 넘는 경우
        String passingName = "Car";
        Assertions.assertTrue(Invalidator.checkStringLength(passingName));

        // 이름이 5자 넘는 경우
        String overFive = "superCar";
        Assertions.assertFalse(Invalidator.checkStringLength(overFive));
    }

    @Test
    public void testHasDuplicates() {

        // 중복되는 이름의 차량 없을 경우
        List<Racing> passingList = Arrays.asList(
                new Racing("Car1"),
                new Racing("Car2"),
                new Racing("Car3")
        );
        String newCar = "Car4";
        Assertions.assertFalse(Invalidator.hasDuplicates(passingList, newCar));

        // 중복되는 이름의 차량 있을 경우
        List<Racing> hasDupleCar = Arrays.asList(
                new Racing("Car1"),
                new Racing("Car2"),
                new Racing("Car3")
        );
        String dupleOne = "Car2";
        Assertions.assertTrue(Invalidator.hasDuplicates(hasDupleCar, dupleOne));
    }

}
