package com.walking.intensive.chapter3.task11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.walking.intensive.chapter3.task11.Task11.getOddSubArraysElementsSum;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task11Test {

    @ParameterizedTest
    @MethodSource("testDataSource")
    void testGetSumSubarraysOddLength(int[] array, int expectedSum) {
        // when
        var result = getOddSubArraysElementsSum(array);

        // then
        assertEquals(expectedSum, result);
    }

    static Stream<Arguments> testDataSource() {
        return Stream.of(
                Arguments.of(new int[]{10, 11, 12}, 66),
                Arguments.of(new int[]{1, 2}, 3),
                Arguments.of(new int[]{1, 4, 2, 5, 3}, 58),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{15}, 15),
                Arguments.of(new int[]{1, 2, 3, -1}, -1),
                Arguments.of(new int[]{-10, 2, 3, 4}, -1),
                Arguments.of(new int[]{4, 3, 2, 1, -4, 5, 0, 9}, -1),
                Arguments.of(new int[]{-15}, -1));
    }
}
