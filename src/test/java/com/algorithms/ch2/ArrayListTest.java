package com.algorithms.ch2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    private static List<String> strList;

    @BeforeAll
    static void init() {
        strList = new ArrayList<>(Arrays.asList("Tallinn", "Tarta"));
    }

    @Test
    void removeIfTest() {
        strList.removeIf(e -> e.length() > 4);
    }
}
