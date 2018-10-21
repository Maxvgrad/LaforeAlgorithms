package com.algorithms.ch4.task4dot5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Task 4.5
 */
public class GroceryShop {
    private volatile AtomicInteger items;

    private ArrayDeque<Customer> q;

    GroceryShop(int items) {
        this.items = new AtomicInteger(items);
    }

    public boolean isClosed() {
        return !(items.get() > 0);
    }

    public int getItem(int expected) {
        return 1;
    }

    public void pay() {

    }

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();

        GroceryShop shop = new GroceryShop(100);

        while (!shop.isClosed()) {

            service.submit(new Customer(shop));

            TimeUnit.SECONDS.sleep(1);
        }

        service.shutdown();
    }
}
