package study.racingcar.controller;

import study.racingcar.view.RacingCarView;

public class RacingCarController {
    public static void main(String[] args) {
        int carNumber = RacingCarView.inputCarNumber();
        int tryNumber = RacingCarView.inputTryNumber();

        RacingCarView.result(carNumber, tryNumber);
    }
}
