package study.racingcar.model;

import java.util.Objects;

public class Car {

    private int nowPosition;
    public Car(int nowPosition) {
        if(nowPosition < 0){
            throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
        }
        this.nowPosition = nowPosition;
    }

    public int getPosition() {
        return nowPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return nowPosition == car.nowPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nowPosition);
    }

    public void move(int diceNumber) {
        if (diceNumber >= 4) {
            this.nowPosition += 1;
        }
    }
}
