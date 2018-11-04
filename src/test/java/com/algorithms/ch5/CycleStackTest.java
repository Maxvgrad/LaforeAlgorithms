package com.algorithms.ch5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CycleStackTest {

    private CycleStack<Integer> stack;

    @BeforeEach
    void init() {
        stack = new CycleStack<>();
    }

    @Test
    void pushTest() {
        assertTrue(stack.isEmpty());
        stack.push(43);
        assertFalse(stack.isEmpty());
        assertThrows(NullPointerException.class, () -> stack.push(null));
    }

    @Test
    void popTest() {
        assertTrue(stack.isEmpty());
        stack.push(32);
        assertEquals(Integer.valueOf(32), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    void peekTest() {
        assertTrue(stack.isEmpty());
        stack.push(32);
        assertEquals(Integer.valueOf(32), stack.peek());
        assertFalse(stack.isEmpty());
    }
}
