package com.algorithms.ch4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;


/**
 * Task 4.2
 */
public class CustomDeque<E> implements Deque<E> {

    private Object[] dData;

    private int size;
    private static final int DEFAULT_SIZE = 100;
    private static final Integer MAX_SIZE = Integer.MAX_VALUE - 10;

    public CustomDeque(int capacity) {
        dData = new Object[capacity];
    }

    public CustomDeque() {
        this(DEFAULT_SIZE);
    }


    private boolean ensureSize() {
        return ensureSize(size+1);
    }

    private boolean ensureSize(int newSize) {
        return newSize <= dData.length;
    }

    private void grow() {
        grow(dData.length<<1);
    }

    private void grow(int capacity) {
        Object[] newDataArray = Arrays.copyOf(dData, capacity);
        dData = newDataArray;
    }

    private void throwDequeFull() {
        throw new IllegalStateException("Deque is full. Size: " + size);
    }

    private void throwDequeEmpty() {
        throw new IllegalStateException("Deque is empty.");
    }

    /**
     * @throws IllegalStateException
     */
    @Override
    public void addFirst(E e) {
        if (!ensureSize())
            throwDequeFull();
        shift();
        dData[0] = e;
    }

    private void shift() {
        shift(1);
    }

    private void shift(int num) {
        System.arraycopy(dData, 0, dData, num, size);
    }

    private void shrink(int num) {
        System.arraycopy(dData, num, dData, 0, size-num);
        size=size-num;
    }

    private void cleanUp() {
        for(int i = size; i < dData.length; i++)
            dData[i]=null;
    }

    @Override
    public void addLast(E e) {
        if (isEmpty()) {
            addFirst(e);
            return;
        }
        if (!ensureSize()) {
            throwDequeFull();
        }
        dData[size++] = e;
    }

    @Override
    public boolean offerFirst(E e) {
        if (ensureSize()) {
            addFirst(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean offerLast(E e) {
        if (ensureSize()) {
            addLast(e);
            return true;
        }
        return false;
    }

    @Override
    public E removeFirst() {
        if (isEmpty())
            throwDequeEmpty();
        E e = retrieveElement(0);
        shrink(1);
        cleanUp();
        return e;
    }

    @Override
    public E removeLast() {
        if (isEmpty())
            throwDequeEmpty();
        E e = retrieveElement(--size);
        cleanUp();
        return e;
    }

    @Override
    public E pollFirst() {
        return isEmpty() ? null : removeFirst();
    }

    @Override
    public E pollLast() {
        return isEmpty() ? null : removeLast();
    }

    @Override
    public E getFirst() {
        if (isEmpty())
            throwDequeEmpty();
        return retrieveElement(0);
    }

    @SuppressWarnings("unchecked")
    private E retrieveElement(int index) {
        return (E) dData[index];
    }

    @Override
    public E getLast() {
        if (isEmpty())
            throwDequeEmpty();
        return retrieveElement(size-1);
    }

    @Override
    public E peekFirst() {
        if(isEmpty())
            return null;
        return retrieveElement(0);
    }

    @Override
    public E peekLast() {
        if(isEmpty())
            return null;
        return retrieveElement(size-1);
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
        return 0;
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
        return size==0;
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
    public boolean addAll(Collection<? extends E> c) {
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
