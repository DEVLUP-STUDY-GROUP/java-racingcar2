package step1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTests {

    @Test
    @DisplayName("괄호제거")
    public void testRemoveParentheses() {
        // sample
        String str = "(1,2)";
        // String 가공
        // 어떤 부분만 살려낼지 잡아내서 변수에 저장, 나머진 버리기
        String result = str.substring(1, str.length() - 1);
        // (1,2) 에서 1,2 만 출력되는지
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정 위치 문자 가져오기")
    public void testGetCharFromIndex() {
        String str = "abc";
        char expectedChar = 'a';
        char position = str.charAt(0);

        Assertions.assertEquals(expectedChar, position);
    }

    @Test
    @DisplayName("범위를 벗어난 문자 요청 에러")
    public void testGetCharOutOfIndex() {
        String str = "abc";
        int position = 10;

        Assertions.assertThrows(StringIndexOutOfBoundsException.class, () -> {
            str.charAt(position);
        });
    }


}
