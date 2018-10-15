package com.algorithms.ch2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    private static List<String> strList;

    @BeforeAll
    static void init() {
        strList = Arrays.asList("Tallinn", "Tarta");
    }

    @Test
    void removeIfTest() {
//        strList.removeIf(e -> e.length()>4);
//        strList.remove("tt");
        byte[] b = new byte[3];
        System.out.println(b.hashCode());
        b[0]=4;
        System.out.println(b.hashCode());
        b[1]=2;
        System.out.println(b.hashCode());
        byte[] b2 = new byte[3];

        System.out.println(b.equals(b2));
        System.out.println(b.equals(b));

        Byte[] byteB = new Byte[3];

        System.out.println(byteB.equals(b2));
        new Object().hashCode()
        Arrays.hashCode(b)

    }
}
