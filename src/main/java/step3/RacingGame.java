package step3;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class RacingGame {

    public CarManager carManager = null;
    public int carNums;
    public int counts;
    public InputView iView;

    public RacingGame(RandomGenerator randomGenerator, InputView iView){
        this.iView = iView;
        System.out.println(iView.getCarNumberPrompt());
        this.carNums = iView.getNextInt();
        System.out.println(iView.getAttemptCountPrompt());
        this.counts = iView.getNextInt();

        carManager= new CarManager(this.carNums,new CarFactory(randomGenerator));
    }
    public void gameStart(){
        try {
            totalAction(this.counts, carManager.getCarCount());
        } catch (Exception e) {
            System.out.println("게임 실행 중 오류가 발생했습니다.: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void totalAction(int choice, int carNums) {
        for(int j = 0; j< choice; j++){
            roundAction(carNums);
            ResultView.printTotal();
        }
    }

    public void roundAction(int carNums) {
        for(int i = 0; i< carNums; i++){
            carManager.carList.get(i).moveAction();
            ResultView.printRound();
        }
    }

    public int getCarNums(){
        return carNums;
    }

    public int getCounts(){
        return counts;
    }

}
