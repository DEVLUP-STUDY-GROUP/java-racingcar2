package step3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.mockito.Mockito.*;

import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Step3Test {

    /** Car 클래스의 moveAction()메서드 단위 테스트
     * Car는 4보다 크면 이동하고 그렇지 않으면 이동하지 않는다.
     */
    @Test
    public void carActionTrueTest() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(5);
        Car car = new Car(mockRandomGenerator);
        car.moveAction();
    }
    @Test
    public void carActionFalseTest() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(3);
        Car car = new Car(mockRandomGenerator);
        car.moveAction();
    }
    /** CarFactory 클래스의 createCar()메서드 단위 테스트
     * 무조건 이동에 성공하는 Car를 생성하는 메서드
     */
    @Test
    public void createCarAlwaysTrueTest() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(5);
        CarFactory carFactory = new CarFactory(mockRandomGenerator);
        Car trueCar=carFactory.createCar();
        trueCar.moveAction();
    }
    /** CarManager 클래스의 addCar()메서드 단위 테스트
     * 무조건 이동에 성공하는 Car를 5개 생성해서 리스트에 추가
     */
    @Test
    public void createCarListAlwaysTrueTest() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(5);
        CarManager carManager = new CarManager(5,new CarFactory(mockRandomGenerator));

        listMoveAction(carManager);
    }
    public static void listMoveAction(CarManager carManager) {
        for(int i = 0; i< carManager.getCarCount() ; i++){
            carManager.getCar(i).moveAction();
            System.out.println();
        }
    }


    public final int carNumber = 3;
    public final int carChoice=5;
    /**
     * Racing Game 단위테스트
     * 유효하지 않은 값이 들어왔을 경우 테스트
     */
    @ParameterizedTest
    @CsvSource({"-1,5"})
    public void negativeNumberTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl());
    }
    @ParameterizedTest
    @CsvSource({"1,-5"})
    public void negativeNumberTest2(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl());
    }
    @ParameterizedTest
    @CsvSource({"a,b"})
    public void notNumberTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl());
    }
    /**
     * Racing Game 단위테스트
     * totalAction 단위테스트
     */
    @ParameterizedTest
    @CsvSource({carNumber+","+carChoice})
    public void totalActionTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl()).totalAction(carChoice,carNumber);
    }
    /**
     * Racing Game 단위테스트
     * roundAction 단위테스트
     */
    @ParameterizedTest
    @CsvSource({carNumber+","+carChoice})
    public void roundActionTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl()).roundAction(carNumber);
    }

    /**
     * Racing Game 단위테스트
     * gameStart 단위테스트
     */
    @ParameterizedTest
    @CsvSource({carNumber+","+carChoice})
    void miniGameRandomTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl()).gameStart();
    }
    @ParameterizedTest
    @CsvSource({carNumber+","+carChoice})
    void miniGameAlwaysTrueTest(String value1, String value2){
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(10)).thenReturn(5);
        createRacingGame(value1, value2, mockRandomGenerator).gameStart();
    }
    @ParameterizedTest
    @CsvSource({carNumber+","+carChoice})
    void miniGameAlwaysFalseTest(String value1, String value2){
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(10)).thenReturn(3);
        createRacingGame(value1, value2, mockRandomGenerator).gameStart();
    }
    public RacingGame createRacingGame(String value1, String value2, RandomGenerator randomGenerator){
        String input = value1 + " " + value2;
        return new RacingGame(randomGenerator,new ConsoleInputView(input));
    }
}
/*테스트 기록
@Test
    void miniGameTest1(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("자동차 대수는?");
        System.out.println("시도할 회수는 몇 회 인가요?");

        int carNum=3;
        int choice=5;

        ArrayList<Integer> carNumInfo= new ArrayList<>();

        for (int step=0; step<choice ;step++){
            for (int car=0; car<carNum; car++){
                if(step==0) {System.out.println("-");carNumInfo.add(1);continue;}
                Random random = new Random();
                int randomNumber = random.nextInt(10);
                if(randomNumber>4) {
                    carNumInfo.set(car,carNumInfo.get(car)+1);
                }
                extracted(carNumInfo, car);
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void extracted(ArrayList<Integer> carNumInfo, int car) {
        for(int carInNum = 0; carInNum< carNumInfo.get(car); carInNum++){
            System.out.print("-");
        }
    }

    @Test
    void miniGameTest2(){
        System.out.print("자동차 대수는?");
        System.out.println("시도할 회수는 몇 회 인가요?");
        int carNum=3;
        int choice=5;
        ArrayList<Car> carList = new ArrayList<>();
        for(int i=0; i<carNum; i++){
            carList.add(new Car(choice));
        }
        for(int j=0; j<choice;j++){
            for(int i=0; i<carList.size(); i++){
                carList.get(i).action();
                System.out.println();
            }
            System.out.println();
        }
    }

    @Test
    void miniGameTest3(){
        System.out.print("자동차 대수는?");
        System.out.println("시도할 회수는 몇 회 인가요?");
        int carNum=3;
        int choice=5;
        CarFactory cF=new CarFactory(choice,carNum);
        for(int j=0; j<choice;j++){
            for(int i=0; i<cF.carList.size(); i++){
                cF.carList.get(i).action();
                System.out.println();
            }
            System.out.println();
        }
    }


 */