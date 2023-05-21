package study.racingcar.model;

import study.racingcar.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private static String INPUT_ERROR_MESSAGE = "입력 문자열이 정상적이지 않습니다.";
    private static int START_POSITION = 0;

    private int position;

    public Car() {
        this(START_POSITION);
    }

    public Car(int nowPosition) {
        if(nowPosition < 0){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        this.position = nowPosition;
    }

    public int getPosition() {
        return position;
    }

    public void move(MoveStrategy moveCar){
        if(moveCar.isMove()){
            this.position += 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
