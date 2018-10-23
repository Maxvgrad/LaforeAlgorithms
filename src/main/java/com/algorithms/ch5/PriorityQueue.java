package com.algorithms.ch5;

import java.util.AbstractQueue;
import java.util.Iterator;


/**
 * Task 5.1
 */
public class PriorityQueue<E extends Comparable> extends AbstractQueue<E> {

    private Link<E> first = null;
    private int size;

    public PriorityQueue() { }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        if (e == null)
            return false;

        Link<E> cur = first;
        Link<E> prev = null;
        Link<E> newLink = new Link<>(e);

        while (true) {
            if (cur == null || compare(newLink, cur) < 0) {
                break;
            }
            prev = cur;
            cur = cur.getNext();
        }

        if (prev == null) {
            first = newLink;
        } else {
            prev.setNext(newLink);
        }

        newLink.setNext(cur);
        size++;
        return true;
    }

    //todo use comparator
    private int compare(Link<E> l1, Link<E> l2) {
        return l1.getData().compareTo(l2.getData());
    }

    @Override
    public E poll() {
        if (first == null)
            return null;
        Link<E> tmp = first;
        first = tmp.getNext();
        size--;
        return tmp.getData();
    }

    @Override
    public E peek() {
        return first != null ? first.getData() : null;
    }
}
