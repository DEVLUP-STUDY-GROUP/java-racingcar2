package step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        // Set<T> 중복 허용 x, 순서 보장 x
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case

    @Test
    @DisplayName("요구사항 1 - Set 자료구조의 크기 테스트")
    void testSizeBySet() {
        //given
        //when
        //then
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 2 - contains를 통해 특정 값이 포함 되어 있는지 테스트")
    void testContainsDuplicateBySet() {
        //given
        //when
        //then
        // 특정 array 값(1,2,3)을 여러번 검증해야 하는 경우 중복 발생
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("요구사항 2.1 - contains 중복 제거")
    void testContainsNoneDuplicateBySet(int num) {
        //given
        //when
        //then
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
//    @CsvSource(value = {"3:false", "1:true", "2:true", "4:false", "5:false"}, delimiter = ':') // fail
//    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':') // success
    @CsvSource(value = {"3:true", "1:true", "2:true", "4:false", "5:false"}, delimiter = ':') // 순서 상관 없는 듯
    @DisplayName("요구사항 3 - 입력 값에 따라 결과값이 다른 경우 테스트")
    void testContainsPerParameterBySet(int input, boolean expected) {
        //given
        //대상(Target Value -> numbers.contains(input) -> n)
//        System.out.println("intput => " + input + ", expected: " + expected);

        //when
        //then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
