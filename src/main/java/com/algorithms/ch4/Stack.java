package com.algorithms.ch4;

import java.util.Deque;

/**
 * Task 4.3
 */
public class Stack<E> {
    private Deque<E> data;
    private final int capacity;

    public Stack(int capacity) {
        this.data = new CustomDeque<>(capacity);
        this.capacity = capacity;
    }

    public void push(E e)    // put item on top of stack
    {
        data.addFirst(e); // increment top, insert item
    }
    //--------------------------------------------------------------
    public E pop()           // take item from top of stack
    {
        return data.getFirst();  // access item, decrement top
    }
    //--------------------------------------------------------------
    public E peek()          // peek at top of stack
    {
        return data.getFirst();
    }
    //--------------------------------------------------------------
    public boolean isEmpty()    // true if stack is empty
    {
        return data.isEmpty();
    }
    //--------------------------------------------------------------
    public boolean isFull()     // true if stack is full
    {
        return data.size()==capacity;
    }
}
