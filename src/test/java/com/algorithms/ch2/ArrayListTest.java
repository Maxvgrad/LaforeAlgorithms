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
        strList.removeIf(e -> e.length()>4);
//        strList.remove("tt");
    }
}
