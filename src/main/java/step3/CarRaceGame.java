package step3;

import step3.domain.Racing;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.*;

// TODO: 빈값 입력 대응, 유효하지 않은 차량 대수, 시도횟수 방어 필요
public class CarRaceGame {
    public static void main(String[] args) {

        // 레이싱 기본 요소 2종 입력
        int carNums = InputView.inputCarNums();
        int raceTryCount = InputView.inputTryCount();

        // 경주 차량들 입력, 검사
        List<Racing> cars = InputView.inputCarNames(carNums);

        // 실제 레이싱 구동
        Racing.race(raceTryCount, cars);

        // 결과값 출력
        ResultView.printResult(cars);
    }
}