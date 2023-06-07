package step4;

import domain.RacingGame;
import model.Car;
import model.CarFactory;
import model.CarManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.Constants;
import util.RandomGenerator;
import util.RandomGeneratorImpl;
import view.ConsoleInputView;
import view.ResultView;

import static org.mockito.Mockito.*;

public class Step4Test {

    /*
    @DisplayName으로 수정.
     */
    public static final String carNames = "car1,car2,car3";
    public static final int carChoice=5;
    public static final String delimiter =":";
    public static final String testString =carNames+delimiter+carChoice;
    public static final String dupChkTest = "car1,car1,car1"+delimiter+carChoice;

    /**
     *  동일한 Car일경우 Exception 발생 테스트
     */
    @ParameterizedTest
    @CsvSource(value = {dupChkTest},delimiter = ':')
    public void dupCarTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl());
    }
    /** Car 클래스의 moveAction()메서드 단위 테스트
     * Car는 4보다 크면 이동하고 그렇지 않으면 이동하지 않는다.
     */
    @Test
    public void carActionTrueTest() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(5);
        Car car = new Car(carNames.split(",")[0]);
        boolean shouldMove = mockRandomGenerator.nextInt(Constants.RANDOM_BOUND) >= Constants.FORWARD_LIMIT;
        car.moveAction(shouldMove);
        ResultView.foward(car.getName(), car.getPosition());
    }
    @Test
    public void carActionFalseTest() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(3);
        Car car = new Car(carNames.split(",")[0]);
        boolean shouldMove = mockRandomGenerator.nextInt(Constants.RANDOM_BOUND) >= Constants.FORWARD_LIMIT;
        car.moveAction(shouldMove);
        ResultView.foward(car.getName(), car.getPosition());
    }
    /** CarFactory 클래스의 createCar()메서드 단위 테스트
     * 무조건 이동에 성공하는 Car를 생성하는 메서드
     */
    @Test
    public void createCarAlwaysTrueTest() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(5);
        CarFactory carFactory = new CarFactory();
        Car trueCar=carFactory.createCar(carNames.split(",")[0]);
        boolean shouldMove = mockRandomGenerator.nextInt(Constants.RANDOM_BOUND) >= Constants.FORWARD_LIMIT;
        trueCar.moveAction(shouldMove);
        //verify(mockRandomGenerator, times(2)).nextInt(Constants.RANDOM_BOUND);
        ResultView.foward(trueCar.getName(), trueCar.getPosition());
    }
    /** CarManager 클래스의 addCar()메서드 단위 테스트
     * 무조건 이동에 성공하는 Car를 3개 생성해서 리스트에 추가
     */
    @Test
    public void createCarListAlwaysTrueTest() {
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(5);
        CarManager carManager = new CarManager(carNames.split(","),new CarFactory());

        listMoveAction(mockRandomGenerator,carManager);
    }
    public static void listMoveAction(RandomGenerator mockRandomGenerator,CarManager carManager) {
        for(int i = 0; i< carManager.getCarCount() ; i++){
            boolean shouldMove = mockRandomGenerator.nextInt(Constants.RANDOM_BOUND) >= Constants.FORWARD_LIMIT;
            carManager.getCar(i).moveAction(shouldMove);
            ResultView.foward(carManager.carList.get(i).getName(), carManager.carList.get(i).getPosition());
            ResultView.printRound();
        }
    }

    /**
     * Racing Game 단위테스트
     * 유효하지 않은 값이 들어왔을 경우 테스트
     */
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
    @CsvSource(value = {testString},delimiter = ':')
    public void totalActionTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl()).totalAction(carChoice,carNames.split(",").length);
    }
    /**
     * Racing Game 단위테스트
     * roundAction 단위테스트
     */
    @ParameterizedTest
    @CsvSource(value = {testString},delimiter = ':')
    public void roundActionTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl()).roundAction(carNames.split(",").length);
    }

    /**
     * Racing Game 단위테스트
     * 이름 5자 초과 테스트
     */
    @ParameterizedTest
    @CsvSource(value = {"carname5more,car1,car2,car3:5"},delimiter = ':')
    void carNameVaildTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl()).gameStart();
    }
    /**
     * Racing Game 단위테스트
     * gameStart 단위테스트
     */
    @ParameterizedTest
    @CsvSource(value = {testString},delimiter = ':')
    void miniGameRandomTest(String value1, String value2){
        createRacingGame(value1, value2, new RandomGeneratorImpl()).gameStart();
    }
    @ParameterizedTest
    @CsvSource(value = {testString},delimiter = ':')
    void miniGameAlwaysTrueTest(String value1, String value2){
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(5);
        createRacingGame(value1, value2, mockRandomGenerator).gameStart();
    }
    @ParameterizedTest
    @CsvSource(value = {testString},delimiter = ':')
    void miniGameAlwaysFalseTest(String value1, String value2){
        RandomGenerator mockRandomGenerator = mock(RandomGenerator.class);
        when(mockRandomGenerator.nextInt(Constants.RANDOM_BOUND)).thenReturn(3);
        createRacingGame(value1, value2, mockRandomGenerator).gameStart();
    }
    public RacingGame createRacingGame(String value1, String value2, RandomGenerator randomGenerator){
        String input = value1 + "\n" + value2;
        return new RacingGame(randomGenerator,new ConsoleInputView(input));
    }
}