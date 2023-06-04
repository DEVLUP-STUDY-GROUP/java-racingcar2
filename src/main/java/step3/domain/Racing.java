package step3.domain;

import java.util.List;

public class Racing {

    private String name;
    private int position;

    public Racing(String name) {
        this.name = name;
        this.position = 0;
    }

    // 레이싱 실제 구동부
    public static void race(int raceTryCount, List<Racing> cars) {
        System.out.println("Racing 시작");

        // TODO: 이중중첩문 빼내기
        for (int i = 0; i < raceTryCount; i++) {
            for (Racing car : cars) {
                car.move();
            }
            System.out.println();
        }
    }

    public void move() {
        int randomNumber = (int) (Math.random() * 10);
        if (randomNumber >= 4) {
            position++;
        }
        System.out.println(name + " : " + "-".repeat(position));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
