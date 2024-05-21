package methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ls.qa.school.core.OddTask;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OddTest {
    static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(3,  true),
                Arguments.of(8, false)
        );
    }
    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Проверка метода [isOdd]")
    void checkMethodIsOdd(int number, boolean isOdd) {
        assertEquals(isOdd, OddTask.isOdd(number));
    }
}
