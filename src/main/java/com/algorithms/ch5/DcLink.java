package com.algorithms.ch5;

import java.util.Objects;

public class DcLink<E> {
    private DcLink<E> next;
    private DcLink<E> previous;
    private E data;

    public DcLink(E data) {
        this(null, data, null);
    }

    public DcLink(DcLink<E> previous, E e, DcLink<E> next) {
        this.next = next;
        this.previous = previous;
        this.data = e;
    }

    public DcLink<E> getNext() {
        return next;
    }

    public void setNext(DcLink<E> next) {
        this.next = next;
    }

    public DcLink<E> getPrevious() {
        return previous;
    }

    public void setPrevious(DcLink<E> previous) {
        this.previous = previous;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DcLink<?> dcLink = (DcLink<?>) o;
        return Objects.equals(next, dcLink.next) &&
                Objects.equals(previous, dcLink.previous);
    }

    @Override
    public int hashCode() {

        return Objects.hash(next, previous);
    }
}
