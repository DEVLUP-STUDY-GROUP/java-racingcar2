package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Step01 {

    @Test
    @DisplayName("1과 2로 잘 분리가 되는지 테스트")
    void splitByStr() throws Exception {
        //given
        String str = "1,2";

        //when
        String[] strList = str.split(",");

        //then
        assertThat(strList).isNotEmpty();
        assertThat(strList[0]).isEqualTo("1");
        assertThat(strList[0]).contains("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 subString() 메소드를 활용해 () 제거하고 '1,2'를 반환")
    void subStrByNumber() throws Exception {
        //given
        String str = "(1,2)";

        //when
        String strList = str.substring(1, 4);
        System.out.println(strList);

        //then
        assertThat(strList).isNotEmpty();
        assertThat(strList).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 String charAt() 메서드 활용 특정 위치의 문자를 가져온다")
    void charAtByStr() throws Exception {
        assertThatThrownBy(() -> {
            String target = "abc";
            char result = target.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
