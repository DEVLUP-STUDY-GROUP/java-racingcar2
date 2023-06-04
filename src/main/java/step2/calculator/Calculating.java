package step2.calculator;

// 3개 이상의 다항 연산 대응, 사칙연산 외의 종류도 클래스 단위로 분리하기 위한 대응
// TODO: 덩치가 커졌을 때의 상황이라면 이 인터페이스의 네이밍이? -> 역할이 와닿기 쉽게
public interface Calculating {

    // 이항 연산
    double twoParamsCal (double num1, double num2);

}
