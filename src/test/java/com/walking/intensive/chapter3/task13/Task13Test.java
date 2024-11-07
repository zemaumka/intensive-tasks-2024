package com.walking.intensive.chapter3.task13;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.walking.intensive.chapter3.task13.Task13.getStepsCount;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Task13}.
 */
public class Task13Test {

    @ParameterizedTest
    @MethodSource("testDataSource")
    void testGetStepsCount(int[] plants, int wateringCanVolume, int expectedCountOfSteps) {
        // when
        var result = getStepsCount(plants, wateringCanVolume);

        // then
        assertEquals(expectedCountOfSteps, result);
    }

    static Stream<Arguments> testDataSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 4, 2, 3}, 4, 30),
                Arguments.of(new int[]{2, 2, 3, 3}, 5, 14),
                Arguments.of(new int[]{7, 7, 7, 7, 7, 7, 7}, 8, 49),
                Arguments.of(new int[]{}, 3, 0),
                Arguments.of(new int[]{7, 1, 0, 5, 3}, 8, -1),
                Arguments.of(new int[]{3, 7, 2, 7, 6, 7, 1, 15, 19}, 0, -1),
                Arguments.of(new int[]{4, 3, 1, 8, 4, 1, 5}, -5, -1),
                Arguments.of(new int[]{4, -1, -2, -4, -5, -6, -7}, 8, -1));
    }
}
