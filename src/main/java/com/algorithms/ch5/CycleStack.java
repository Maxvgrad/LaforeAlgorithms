package com.algorithms.ch5;

import java.util.Objects;

public class CycleStack<E> {
    private CycleList<E> data;
    private int size;

    public CycleStack() {
        size = 0;
    }

    public void push(E e) {
        checkNull(e);
        if (isEmpty()) {
            data = new CycleList<>(e);
        } else {
            data.add(e);
        }
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E e = data.getData();
        data = data.step();
        size--;
        return e;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return data.getData();
    }
    public boolean isEmpty() {
        return size == 0;
    }

    private void checkNull(E e) {
        Objects.requireNonNull(e, "Cycle stack does not support null");
    }
}