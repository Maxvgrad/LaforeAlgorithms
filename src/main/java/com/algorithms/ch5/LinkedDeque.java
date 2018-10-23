package com.algorithms.ch5;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;

/**
 * Task 5.2
 */
public class LinkedDeque<E> implements Deque<E> {

    private DcLink<E> first;
    private DcLink<E> last;

    private int size;
    private int modChanges;

    public LinkedDeque() {

    }

    @Override
    public void addFirst(E e) {
        offerFirst(e);
    }

    @Override
    public void addLast(E e) {
        offerLast(e);
    }

    /**
     * @throws NullPointerException if specified element is null
     */
    private void requireNonNull(E e) {
        Objects.requireNonNull(e, "LinkedDeque does not permit null elements");
    }

    @Override
    public boolean offerFirst(E e) {
        requireNonNull(e);
        if (first == null) {
            first = new DcLink<>(e);
            last = first;
        } else {
            DcLink<E> tmp = first;
            first = new DcLink<>(e);
            first.setNext(tmp);
        }
        size++;
        modChanges++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        requireNonNull(e);
        if (last == null) {
            last = new DcLink<>(e);
            first = last;
        } else {
            DcLink<E> tmp = last;
            last = new DcLink<>(e);
            last.setPrevious(tmp);
        }
        size++;
        modChanges++;
        return true;
    }

    @Override
    public E removeFirst() {

        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E pollFirst() {
        E e = remove(first);
        checkInvariant();
        return e;
    }

    /**
     * Checks if both of links is null, if one of first of last links is null
     */
    private void checkInvariant() {
        if (first == null || last == null) {
            first = null;
            last = null;
        }
    }

    @Override
    public E pollLast() {
        E e = remove(last);
        checkInvariant();
        return e;
    }

    private E remove(DcLink<E> e) {
        if (e == null)
            return null;

        DcLink<E> tmp = e;
        e = tmp.getNext();
        return tmp.getData();
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
