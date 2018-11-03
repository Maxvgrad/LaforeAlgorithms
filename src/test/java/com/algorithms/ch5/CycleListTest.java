package com.algorithms.ch5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CycleListTest {

    private CycleList<Integer> cycle;

    @BeforeEach
    void init() {
        cycle = new CycleList<>(55);
    }

    @Test
    void addTest() {
        assertEquals(1, cycle.size());
        for (int i = 0; i < 5; i++) {
            cycle.add(0);
        }
        assertEquals(6, cycle.size());
    }

    @Test
    void getDataTest() {
        assertEquals(1, cycle.size());
        for (int i = 1; i < 6; i++) {
            cycle.add(i);
            assertEquals(Integer.valueOf(i), cycle.getData());
        }
    }

    @Test
    void stepTest() {
        CycleList<Integer> first = cycle;
        assertEquals(1, cycle.size());
        for (int i = 43; i>39; i--) {
            cycle.add(i);
        }

        for (int i = 43; i>38; i--) {
            cycle = cycle.step();
        }
        assertEquals(first, cycle);
    }

    @Test
    void removeTest() {
        assertEquals(1, cycle.size());

        for (int i = 0; i < 5; i++) {
            cycle.add(i);
        }

        for (int i = 5; i!=1; i--) {
            cycle.remove();
            assertEquals(i, cycle.size());
        }
    }

    @Test
    void findTest() {
        for (int i = 0; i < 5; i++) {
            cycle.add(i);
        }
        assertNull(cycle.find(99));
        assertNotNull(cycle.find(3));
    }
}
