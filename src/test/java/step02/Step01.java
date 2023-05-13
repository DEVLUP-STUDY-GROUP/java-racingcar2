package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Step01 {

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    @DisplayName("요구사항 1 - 문자열 1,2 가 주어졌을때 split을 통해 잘 분리가 되는지 테스트")
    void testSplitByStr(String item) {
        //given
        //when
        String[] items = item.split(",");

        //then
        assertThat(items).isNotEmpty();
        assertThat(items[0]).isEqualTo("1");
        assertThat(items[0]).contains("1");
        assertThat(items[1]).isEqualTo("2");
        assertThat(items[1]).contains("2");
    }

    @ParameterizedTest
    @ValueSource(strings = "(1,2)")
    @DisplayName("요구사항 2 - (1,2) 값이 주어졌을 때 String의 subString() 메소드를 활용해 () 제거하고 '1,2'를 반환")
    void testSubStringByStr(String item) {
        //given
        //when
//        String items = item.substring(1, 4);
//        String items = item.substring(1, item.length() - 1);
        String items = item.substring(item.indexOf("(") + 1, item.lastIndexOf(")")); // 하드 코딩이 아닌 다른 문자가 들어오는 경우 대비

        //then
        assertThat(items).isNotEmpty();
        assertThat(items).isEqualTo("1,2");
        assertThat(items.length()).isEqualTo(3);
        assertThat(items.split(",")[0]).isEqualTo("1");
        assertThat(items.split(",")[1]).isEqualTo("2");
    }

    @ParameterizedTest
    @ValueSource(strings = "abc")
    @DisplayName("요구사항 3 - abc 값이 주어졌을 때 String charAt() 메서드 활용 특정 위치의 문자를 가져온다")
    void testCharAtByStr(String item) {
        assertThatThrownBy(() -> {
            char result = item.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
