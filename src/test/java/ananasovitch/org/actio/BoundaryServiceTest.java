package ananasovitch.org.actio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class BoundaryServiceTest {

    private final BoundaryService boundaryService = new BoundaryService();

    static Stream<Arguments> provideData() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, 1),
                arguments(new int[]{10, 20, 30, 40, 50}, 10),
                arguments(new int[]{100, 200, 300, 400, 500}, 100),
                arguments(new int[]{100, 5, 300, 20, 500}, 5),
                arguments(new int[]{-10, -20, -3, -40, -5}, -40),
                arguments(new int[]{10, 20, 30, 40, 5}, 5),
                arguments(new int[]{1, 2, 3, 4, 5}, 1),
                arguments(new int[]{0, 0, 0, 0, 0}, 0)
        );
    }

    @ParameterizedTest(name = "Test {index}: Минимальный элемент массива {0} равен {1}")
    @MethodSource("provideData")
    void testFindMin(int[] marks, int expectedMin) {
        int min = boundaryService.findMin(marks);
        assertEquals(expectedMin, min, "Минимальное значение неверно для массива " + printArray(marks));
    }

    private String printArray(int[] array) {
        return Arrays.toString(array);
    }
}