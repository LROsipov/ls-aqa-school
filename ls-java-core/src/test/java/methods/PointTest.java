package methods;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.ls.qa.school.core.point.Point;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {
    static Stream<Arguments> dataSource() {
        return Stream.of(
                Arguments.of(new Point(3, 4), new Point(6, 8), 5.0),
                Arguments.of(new Point(0, 0), new Point(8, 15), 17.0)
        );
    }
    @ParameterizedTest
    @MethodSource("dataSource")
    @DisplayName("Проверка метода [distance]")
    void checkMethodDistance(Point firstPoint, Point secondPoint, double expectedDistance) {
        assertEquals(expectedDistance, firstPoint.distance(secondPoint), "Актуальная и фактичиские дистанции не совпадают");
    }
}
