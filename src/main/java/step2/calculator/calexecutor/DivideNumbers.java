package step2.calculator.calexecutor;

import step2.calculator.Calculating;

public class DivideNumbers implements Calculating {

    @Override
    public double twoParamsCal(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }

}
