package com.walking.intensive.chapter4.task18;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task18Test {

    @ParameterizedTest
    @MethodSource("findTestSource")
    public void findTest(int[] girlAges, int targetAge, int expected) {
        int result = Task18.find(girlAges, targetAge);
        assertEquals(expected, result);
    }

    static Stream<Arguments> findTestSource() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 10, 20, 30, 40, 45}, 20, 20),
                Arguments.of(new int[]{5, 10, 15, 20, 25, 30, 35, 40, 45, 50}, 45, 45),
                Arguments.of(new int[]{1, 3, 5, 7, 9, 11, 13}, 8, 7),
                Arguments.of(new int[]{1, 8, 10, 20, 30, 40, 45}, 41, 40),
                Arguments.of(new int[]{1, 8, 10, 20, 30, 40, 45}, 29, 20),
                Arguments.of(new int[]{}, 7, -1)
        );
    }
}
