package step4;

import java.util.Arrays;
import java.util.List;

public class RacingGame {

    public CarManager carManager = null;
    public int counts;
    public InputView iView;

    public String[] carNames;
    public RandomGenerator randomGenerator;

    public RacingGame(){}
    public RacingGame(RandomGenerator randomGenerator, InputView iView){
        this.iView = iView;
        this.randomGenerator=randomGenerator;
        System.out.println(iView.getCarNumberPrompt());
        System.out.println(Arrays.toString((this.carNames = iView.getNextCarNames())));
        System.out.println(iView.getAttemptCountPrompt());
        System.out.println(this.counts = iView.getNextInt());
        carManager= new CarManager(this.carNames,new CarFactory());
    }
    public void gameStart(){
        try {
            totalAction(this.counts, carManager.getCarCount());
        } catch (Exception e) {
            System.out.println("totalAction 실행 중 오류가 발생했습니다.: " + e.getMessage());
            e.printStackTrace();
        }
        try {
            ResultView.printWinner(carManager.pickWinner());
        } catch (Exception e) {
            System.out.println("ResultView 실행 중 오류가 발생했습니다.: " + e.getMessage());
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
            //boolean shouldMove = carManager.carList.get(i).randomGenerator.nextInt(Constants.RANDOM_BOUND) >= Constants.FORWARD_LIMIT;
            boolean shouldMove = this.randomGenerator.nextInt(Constants.RANDOM_BOUND) >= Constants.FORWARD_LIMIT;
            carManager.carList.get(i).moveAction(shouldMove);
            ResultView.foward(carManager.carList.get(i).getName(), carManager.carList.get(i).getPosition());
            ResultView.printRound();
        }
    }
}
