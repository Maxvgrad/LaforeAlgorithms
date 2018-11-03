package com.algorithms.ch5;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Task 5.2
 */
public class LinkedDeque<E> implements Deque<E> {

    private DcLink<E> first;
    private DcLink<E> last;

    private int size;
    private int modCount;

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
        } else
            first = new DcLink<>(null, e, first);

        size++;
        modCount++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        requireNonNull(e);
        if (last == null) {
            last = new DcLink<>(e);
            first = last;
        } else
            last = new DcLink<>(last, e, null);

        size++;
        modCount++;
        return true;
    }

    @Override
    public E removeFirst() {
        E e;
        if ((e = pollFirst()) == null)
            throw new NoSuchElementException();
        return e;
    }

    @Override
    public E removeLast() {
        E e;
        if ((e = pollLast()) == null)
            throw new NoSuchElementException();
        return e;
    }

    @Override
    public E pollFirst() {
        if (first == null)
            return null;
        DcLink<E> tmp = first;
        first = tmp.getNext();
        checkInvariant();

        size--;
        modCount++;
        return tmp.getData();
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
        if (last == null)
            return null;

        DcLink<E> tmp = last;
        last = tmp.getNext();
        checkInvariant();
        size--;
        modCount--;
        return tmp.getData();
    }

    @Override
    public E getFirst() {
        if (first == null)
            throw new NoSuchElementException();
        return first.getData();
    }

    @Override
    public E getLast() {
        if (last == null)
            throw new NoSuchElementException();
        return last.getData();
    }

    @Override
    public E peekFirst() {
        return first != null ? first.getData() : null;
    }

    @Override
    public E peekLast() {
        return last != null ? last.getData() : null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return remove(iterator(), o);
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return remove(descendingIterator(), o);
    }

    private boolean remove(Iterator<E> iter, Object o) {
        Objects.requireNonNull(o);
        while (iter.hasNext()) {
            if (Objects.equals(iter.next(), o)) {
                iter.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        return offerLast(e);
    }

    @Override
    public E remove() {
        E e;
        if ((e = pollFirst()) == null)
            throw new NoSuchElementException();
        return e;
    }

    @Override
    public E poll() {
        return pollFirst();
    }

    @Override
    public E element() {
        E e;
        if ((e = peekFirst()) == null)
            throw new NoSuchElementException();
        return e;
    }

    @Override
    public E peek() {
        return peekFirst();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<? extends E> iter = c.iterator();
        while (iter.hasNext()) {
            offerLast(iter.next());
            modified = true;
        }
        return modified;
    }

    //Stack methods

    @Override
    public void push(E e) {
        addFirst(e);
    }

    @Override
    public E pop() {
        return pollFirst();
    }

    // Collection methods

    @Override
    public boolean remove(Object o) {
        return removeFirstOccurrence(o);
    }

    @Override
    public boolean contains(Object o) {
        Objects.requireNonNull(o);
        Iterator<E> iter = iterator();
        while (iter.hasNext()) {
            if (Objects.equals(iter.next(), o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private E unlink(DcLink<E> link) {
        final E data = link.getData();

        final DcLink<E> prev = link.getPrevious();
        final DcLink<E> next = link.getNext();

        if (prev == null) {
            first = next;
        } else {
            prev.setNext(next);
            link.setPrevious(null);
        }

        if (next == null) {
            last = prev;
        } else {
            next.setPrevious(prev);
            link.setNext(null);
        }
        link.setData(null);
        size--;
        modCount++;
        return data;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter(first);
    }

    private class Iter implements ListIterator<E> {
        DcLink<E> prev;
        DcLink<E> next;

        private int expectedModCount;

        public Iter(DcLink<E> l) {
            next = l;
            this.expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            checkConcurMod();
            if (!hasNext())
                throw new NoSuchElementException();
            prev = next;
            next = next.getNext();
            return prev.getData();
        }

        @Override
        public boolean hasPrevious() {
            return prev != null;
        }

        @Override
        public E previous() {
            checkConcurMod();
            if (!hasPrevious())
                throw new NoSuchElementException();
            next = prev;
            prev = prev.getPrevious();
            return next.getData();
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }

        @Override
        public void remove() {
            checkConcurMod();
            if (prev == null)
                throw new NoSuchElementException();

            unlink(prev);

            prev = null;
            expectedModCount = modCount;
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            while (hasNext()) {
                checkConcurMod();
                action.accept(next());
            }
        }

        private void checkConcurMod() {
            if (expectedModCount != modCount)
                throw new ConcurrentModificationException();
        }
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
        final int size = size();
        Object[] resultArr = new Object[size];
        Iterator iter = iterator();
        for (int i = 0; iter.hasNext() && resultArr.length <= size; i++) {
            resultArr[i] = iter.next();
        }

        return resultArr;
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
        Iterator iter = iterator();
        while (iter.hasNext())
            iter.remove();
    }
}
