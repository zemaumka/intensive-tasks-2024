package com.walking.intensive.chapter3.task15;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.walking.intensive.chapter3.task15.Task15.getMaxFloors;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Task15}.
 */
public class Task15Test {

    @ParameterizedTest
    @MethodSource("testDataSource")
    void testGetMaxFloors(int[][] city, int expectedCountOfFloors) {
        // when
        var result = getMaxFloors(city);

        // then
        assertEquals(expectedCountOfFloors, result);
    }

    static Stream<Arguments> testDataSource() {
        // case 1
        int[][] city1 = {{2, 1}, {1, 3}};

        // case 2
        int[][] city2 = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};

        // case 3 zero city
        int[][] city3 = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

        // case 4 incorrect size arrays
        int[][] city4 = {{3, 0}, {2, 4, 5, 7, 8, 0}, {9, 2, 6}, {8}, {3, 8, 0, 1, 4, 6}};

        // case 5 negative floors
        int[][] city5 = {{3, 0, 8, 4}, {2, -4, 5, 7}, {-5, 2, 6, 3}, {0, 3, -1, 0}};

        // case 6 empty floors
        int[][] city6 = {{}, {}, {}};

        //case 7 empty city
        int[][] city7 = {};

        return Stream.of(
                Arguments.of(city1, 2),
                Arguments.of(city2, 35),
                Arguments.of(city3, 0),
                Arguments.of(city4, -1),
                Arguments.of(city5, -1),
                Arguments.of(city6, -1),
                Arguments.of(city7, -1)
        );
    }
}
