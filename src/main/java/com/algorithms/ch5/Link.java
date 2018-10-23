package com.algorithms.ch5;

import java.util.Objects;

public class Link<E> {

    private Link<E> next;

    private E data;

    public Link(E data) {
        this.data = data;
    }

    public Link<E> getNext() {
        return next;
    }

    public void setNext(Link<E> next) {
        this.next = next;
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
        Link<?> link = (Link<?>) o;
        return Objects.equals(data, link.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(data);
    }
}
