package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Step2Test {

    /**  Test Method
    조건 1. 정수
    2. 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
3. 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
    **/
    @Test
    @DisplayName("입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현")
    public void case1(){
        assertThat(Calculator.calculate("1 + 2 * 4")).isEqualTo(4);
    }

    /**
    1. 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된
다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한
다.
    2. 예를 들어 2 + 3 * 4 / 2 와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10
을 출력해야 한다.
     **/
    @Test
    @DisplayName("2 + 3 * 4 / 2 실행 결과 10")
    public void case2(){
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(-1);
    }


    /**
    사칙연산 기호가 아닌 경우 IllegalArgumentException throw
     **/
    @Test
    @DisplayName("사칙연산 기호가 아닌 경우")
    public void exceptionCase1(){
        assertThatThrownBy(() -> {
            Calculator.calculate("1 ^ 2");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("@Test 사칙연산 기호가 아닌 경우");

    }

    /**
    입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
     **/
    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    public void exceptionCase2(){
        assertThatThrownBy(() -> {
            Calculator.calculate("");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("@Test 입력 값이 null이거나 빈 공백 문자일 경우");
    }
    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자일 경우")
    public void exceptionCase3(){
        assertThatThrownBy(() -> {
            Calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("@Test 입력 값이 null이거나 빈 공백 문자일 경우");
    }
    @Test
    @DisplayName("한번에")
    public void exceptionCase3_1(){
        assertThatThrownBy(() -> {
            Calculator.calculate("");
            Calculator.calculate(null);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("@Test 입력 값이 null이거나 빈 공백 문자일 경우 한 번에");
    }
    /**
    입력 값을 0으로 나눌 경우
     **/
    @Test
    @DisplayName("입력 값을 0으로 나눌 경우")
    public void exceptionCase4(){
        assertThatThrownBy(() -> {
            Calculator.calculate("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("@Test 입력 값을 0으로 나눌 경우");
    }
    /**
     숫자가 아닐 경우
     **/
    @Test
    @DisplayName("숫자가 아닐 경우")
    public void exceptionCase5(){
        assertThatThrownBy(() -> {
            Calculator.calculate("ㅇ + ㄴ");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("@Test 숫자가 아닐 경우");
    }
}
