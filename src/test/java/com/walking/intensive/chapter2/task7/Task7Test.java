package com.walking.intensive.chapter2.task7;

import org.junit.jupiter.api.Test;

import static com.walking.intensive.chapter2.task7.Task7.getFriendlyPair;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task7Test {

    @Test
    void getFriendlyPairTest() {
        assertEquals(0, getFriendlyPair(200));
        assertEquals(284, getFriendlyPair(497));
        assertEquals(6368, getFriendlyPair(10000));
        assertEquals(-1, getFriendlyPair(-200));
        assertEquals(-1, getFriendlyPair(0));
        assertEquals(-1, getFriendlyPair(1_000_001));
        assertEquals(-1, getFriendlyPair(3_123_123));
    }
}
