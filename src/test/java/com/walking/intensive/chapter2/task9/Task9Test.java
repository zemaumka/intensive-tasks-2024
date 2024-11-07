package com.walking.intensive.chapter2.task9;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.walking.intensive.chapter2.task9.Task9.getPascalTriangle;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.of;

class Task9Test {

    @Test
    void getPascalTriangleNegativeTest() {
        String pascalTriangle = getPascalTriangle(5);
        System.out.println(pascalTriangle);
        assertEquals("", getPascalTriangle(-10));
        assertEquals("", getPascalTriangle(-0));
    }

    @ParameterizedTest
    @MethodSource("triangleData")
    void getPascalTriangleFloorTest(int expected, int n) {
        String pascalTriangle = getPascalTriangle(n);
        System.out.println(pascalTriangle);
        List<String> splitTriangle = List.of(pascalTriangle.split("\n"));

        assertEquals(expected, splitTriangle.size());
    }

    @ParameterizedTest
    @MethodSource("triangleData")
    void getPascalTriangleLastFloorElementsTest(int expected, int n) {
        String pascalTriangle = getPascalTriangle(n);
        System.out.println(pascalTriangle);

        String[] splitTriangle = pascalTriangle.split("\n");

        String lastElement = splitTriangle[splitTriangle.length - 1];
        List<String> splitLastElement = List.of(lastElement.split(" "));

        assertEquals(expected, splitLastElement.size());
    }

    @ParameterizedTest
    @MethodSource("trianglesEquals")
    void getPascalTriangleEqualsTest(String expected, int n) {
        String pascalTriangle = getPascalTriangle(n);
        System.out.println(pascalTriangle);

        assertEquals(expected, pascalTriangle);
    }

    static Stream<Arguments> triangleData() {
        return Stream.of(
                of(3, 3),
                of(5, 5),
                of(10, 10),
                of(15, 15),
                of(21, 21)
        );
    }

    static Stream<Arguments> trianglesEquals() {
        return Stream.of(
                of("""
                          1
                         1 1
                        1 2 1
                        """, 3),
                of("""
                            1
                           1 1
                          1 2 1
                         1 3 3 1
                        1 4 6 4 1
                        """, 5),
                of("""
                                     1
                                    1 1
                                   1 2 1
                                  1 3 3 1
                                 1 4 6 4 1
                               1 5 10 10 5 1
                             1 6 15 20 15 6 1
                            1 7 21 35 35 21 7 1
                          1 8 28 56 70 56 28 8 1
                        1 9 36 84 126 126 84 36 9 1
                        """, 10),
                of("""
                                                    1
                                                   1 1
                                                  1 2 1
                                                 1 3 3 1
                                                1 4 6 4 1
                                              1 5 10 10 5 1
                                             1 6 15 20 15 6 1
                                           1 7 21 35 35 21 7 1
                                          1 8 28 56 70 56 28 8 1
                                       1 9 36 84 126 126 84 36 9 1
                                   1 10 45 120 210 252 210 120 45 10 1
                                 1 11 55 165 330 462 462 330 165 55 11 1
                               1 12 66 220 495 792 924 792 495 220 66 12 1
                           1 13 78 286 715 1287 1716 1716 1287 715 286 78 13 1
                        1 14 91 364 1001 2002 3003 3432 3003 2002 1001 364 91 14 1
                        """, 15)
        );
    }
}
