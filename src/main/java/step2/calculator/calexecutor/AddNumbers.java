package step2.calculator.calexecutor;

import step2.calculator.Calculating;

public class AddNumbers implements Calculating {

    @Override
    public double twoParamsCal(double num1, double num2) {
        return num1 + num2;
    }

}
