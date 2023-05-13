package step1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class Step1Test {
    /* 로그 추가 테스트 더 추가하겠습니다. */
    @Test
    void splitTest1(){
        String test = "1,2";
        assertThat(test.split(",")).containsExactly("1" , "2");
    }
    @Test
    void splitTest2(){
        assertThat("1,".split(",")).containsExactly("1");
    }
    @Test
    void substringTest(){
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }
    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 StringIndexOutOfBoundsException 발생")
    void charatTest(){
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4");
    }
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    @Test
    void setCollectionTest(){
        assertThat(numbers.size()).isEqualTo(30);
    }
    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true","4:false","5:false"}, delimiter = ':')
    void containsCsv(String input, boolean expected) {
        assertThat(numbers.contains(Integer.parseInt(input))).isEqualTo(expected);
    }
}
