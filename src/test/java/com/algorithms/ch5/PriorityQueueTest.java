package com.algorithms.ch5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PriorityQueueTest {

    private PriorityQueue<Integer> pQueue;

    @BeforeEach
    void init() {
        pQueue = new PriorityQueue<>();
    }

    @Test
    void offerTest() {
        assertTrue(pQueue.offer(3));
        assertFalse(pQueue.offer(null));
    }

    @Test
    void peekTest() {
        assertNull(pQueue.peek());

        fillQueue(10, 15);

        assertEquals(Integer.valueOf(10), pQueue.peek());
        assertEquals(Integer.valueOf(10), pQueue.peek());
    }

    @Test
    void pollTest() {
        assertNull(pQueue.poll());

        fillQueue(15);

        assertEquals(Integer.valueOf(15), pQueue.poll());
        assertNull(pQueue.poll());

        fillQueue(40, 120, 1);

        assertEquals(Integer.valueOf(1), pQueue.poll());
        assertEquals(Integer.valueOf(40), pQueue.poll());
        assertEquals(Integer.valueOf(120), pQueue.poll());
    }

    @Test
    void clearTest() {
        fillQueue(11, 34);
        pQueue.clear();
        assertEquals(0, pQueue.size());
    }

    private void fillQueue(Integer... content) {
        Arrays.stream(content).forEach(pQueue::offer);
    }
}
