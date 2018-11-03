package com.algorithms.ch5;

import java.util.Objects;
import java.util.UUID;


/**
 * Task 5.3
 */
public class CycleList<E> {

    private UUID id;
    private CycleList<E> next;
    private E data;


    public CycleList(E data) {
        this.data = data;
        this.next = this;
        this.id = UUID.randomUUID();
    }

    public CycleList<E> add(E e) {
        System.out.println("#add");
        CycleList<E> current = new CycleList<>(e);
        current.next = this.next;
        this.next = current;
        return this;
    }

    public CycleList<E> step() {
        return next;
    }

    public CycleList<E> remove() {
        next = next.next;
        return this;
    }

    public E getData() {
        return next.data;
    }

    public CycleList<E> find(E e) {
        if (data.equals(e))
            return this;

        CycleList<E> cell = next;

        while (!this.id.equals(cell.id)) {
            if (cell.data.equals(e)) {
                return cell;
            }
            cell = cell.next;
        }
        return null;
    }

    public int size() {
        System.out.println("#size");
        int size = 1;
        CycleList<E> cell = next;

        while (!this.id.equals(cell.id)) {
            cell = cell.next;
            size++;
        }

        return size;

    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[").append(data.toString()).append(", ");
        if (this.id.equals(next.id)) {
            return data.toString();
        }

        CycleList<E> cell = next;
        while (!this.id.equals(cell.id)) {
            result.append(cell.data.toString()).append(", ");
            cell = cell.next;
        }
        return result.append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CycleList<?> cycleList = (CycleList<?>) o;
        return Objects.equals(data, cycleList.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}

