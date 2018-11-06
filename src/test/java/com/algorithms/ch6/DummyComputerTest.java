package com.algorithms.ch6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DummyComputerTest {

    private DummyComputer dummyComputer = new DummyComputer();

    @Test
    void multTest() {
        assertEquals(6, dummyComputer.mult(3, 2));
        assertEquals(10, dummyComputer.mult(2, 5));
    }

    @Test
    void powTest() {
        assertEquals(32, dummyComputer.pow(2, 5));
    }
}