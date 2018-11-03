package com.algorithms.ch5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedDequeTest {

    private Deque<Integer> linkedDeque;

    @BeforeEach
    void init() {
        linkedDeque = new LinkedDeque<>();
    }

    @Test
    void addTest() {
        assertTrue(linkedDeque.isEmpty());
        linkedDeque.add(1);
        assertEquals(1, linkedDeque.size());
        linkedDeque.add(3);
        linkedDeque.add(4);
        linkedDeque.add(6);
        assertEquals(4, linkedDeque.size());
    }

    @Test
    void pollTest() {
        linkedDeque.add(1);
        linkedDeque.add(5);
        assertEquals(Integer.valueOf(1), linkedDeque.poll());
        assertEquals(Integer.valueOf(5), linkedDeque.poll());
        assertTrue(linkedDeque.isEmpty());

    }
}
