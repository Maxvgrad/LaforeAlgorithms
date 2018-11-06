package com.algorithms.ch6;


/**
 * Task 6.1
 */
public class DummyComputer {

    public int mult(int x, int y) {
        if (y == 1) {
            return x;
        }
        return x + mult(x, y-1);
    }
}
