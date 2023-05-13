import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringUtilsTest {

    @Test
    @DisplayName("괄호제거")
    public void removeParentheses() {
        // sample
        String str = "(1,2)";
        // String 가공
        // 어떤 부분만 살려낼지 잡아내서 변수에 저장, 나머진 버리기
        String result = str.substring(1, str.length() - 1);
        // (1,2) 에서 1,2 만 출력되는지
        assertThat(result).isEqualTo("1,2");
    }

}