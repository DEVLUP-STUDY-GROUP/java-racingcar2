package step3.domain;

import java.util.List;

public class Invalidator {

    public static boolean validationCheck(List<Racing> cars, String name) {

        int escapeNum = 0;

        if (!(hasDuplicates(cars, name))) {
            escapeNum++;
        }

        if (checkStringLength(name)) {
            escapeNum++;
        }

        if (escapeNum < 2) {
            System.out.println("유효하지 않은 차량 이름입니다. 다시 입력해주세요. (ex. 5글자를 넘음 OR 중복되는 이름 존재)");
        }

        return escapeNum >= 2;
    }

    public static boolean checkStringLength(String str) {
        return str.length() <= 5;
    }

    public static boolean hasDuplicates(List<Racing> cars, String name) {
        return cars.stream()
                .map(Racing::getName)
                .anyMatch(item -> item.equals(name));
    }
}
