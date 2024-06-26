package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    @DisplayName("increase 메서드는 position 의 값을 1 증가시킨다.")
    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "2,3"})
    void should_IncreaseByOne_When_UsingIncreaseMethod(int beforeValue, int afterValue) {
        //given
        Position position = new Position(beforeValue);

        //when
        position.increase();

        //then
        assertThat(position.getPosition()).isEqualTo(afterValue);
    }
}
