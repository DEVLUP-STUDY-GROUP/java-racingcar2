package step04;

import java.util.Random;

public class Car {
    private String carName;
    private int position;

    public Car() {
    }

    public Car(String carName) {
        if (validateCarNames(carName)) {
            this.carName = carName;
            this.position = 0; // 최초 객체 생성시 position은 0으로 셋팅
        }
    }

    public void move() {
        int random = new Random().nextInt(9);
        if (random > 4) {
            this.position += 1;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public boolean validateCarNames(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하만 가능합니다.");
        }
        return true;
    }
}
